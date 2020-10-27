package com.cloud.api.config.websocket;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.cloud.api.bean.dto.Constants;
import com.cloud.api.service.RedisService;
import com.cloud.api.util.SpringUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 每个websocket服务都是一个单独的聊天通道
 * 存放着自己的open id以及对方的open id
 * 每次收到消息时候都是获取对方的Open id对应的session然后发送message
 *
 * @author HP
 */
@Slf4j
@Component
@EnableWebSocket
@EnableWebSocketMessageBroker
@ServerEndpoint(value = "/websocket/{openid}/{toOpenid}")
public class WebSocketServer {


    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * 关联用户的open id与他对应的websocket对象
     */
    private static Map<String, Integer> data = new ConcurrentHashMap<>();

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /*** 接收openid */
    private String sender = "";

    /***接收者 */
    private String recipient = "";

    @Qualifier(value = "redisService")
    private RedisService redisService;

    /**
     * 连接建立成功调用的方法
     **/
    @OnOpen
    public void onOpen(Session session,
                       @PathParam("openid") String openid,
                       @PathParam("toOpenid") String toOpenid) {
        this.session = session;
        webSocketSet.add(this);
        data.put(openid, WebSocketServer.getOnlineCount());
        addOnlineCount();
        log.info("刚刚执行打开事件，集合内容：" + webSocketSet.toString());
        log.info("sender = {}", sender);
        log.info("recipient = {}", this.recipient);
        this.sender = openid;
        this.recipient = toOpenid;
        log.info("sender = {}", sender);
        log.info("recipient = {}", this.recipient);

    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("收到来自窗口" + sender + "的信息:" + message + "，发送给：" + recipient);
        log.info("当前我是：" + this.sender + ",我对应的集合存储位置是：" + data.get(this.sender));
        sendMessage(message);
    }


    private void sendMessage(String message) throws IOException {
        AtomicReference<WebSocketServer> recipientServer = new AtomicReference<>();
        final Integer recipientServerLocation = data.get(this.recipient);
        if (recipientServerLocation != null) {
            webSocketSet.forEach(value -> {
                //一个websocket对象的sender说明这是属于谁的
                if(value.sender.equals(this.recipient)){
                    recipientServer.set(value);
                }
            });

            log.info("recipientServer.get().sender = {}", recipientServer.get().sender);
            assert false;
            if (recipientServer.get() != null) {
                recipientServer.get().session.getBasicRemote().sendText(message);
                log.info("已经发送");
                try {
                    Db.use().insert(
                            Entity.create("chat_record")
                                    .set("chat_record_content", message)
                                    .set("send_open_id", this.sender)
                                    .set("receive_open_id", this.recipient)
                                    .set("send_time", LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //此时将信息暂时存放到redis
            log.info(MessageFormat.format("消息接收者{0}还未建立WebSocket连接，{1}发送的消息【{2}】将被存储到Redis的【{3}】列表中", recipient, sender, message, this.recipient));
            //存储消息到Redis中
            final ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("sender",this.sender);
            node.put("message",message);
            node.put("sendTime",LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            final RedisService redisService = (RedisService)SpringUtil.getBean("redisService");
            redisService.addKey(this.recipient,node.toString());
        }
    }

    @OnClose
    public void onClose() {
        //从set中删除当前对象
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
