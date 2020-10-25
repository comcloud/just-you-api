package com.cloud.api.config.websocket;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.cloud.api.bean.dto.Constants;
import com.cloud.api.bean.dto.ExpireEnum;
import com.cloud.api.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.concurrent.ConcurrentHashMap;

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
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static Map<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /*** 接收openid */
    private String sender = "";

    /***接收者 */
    private String recipient = "";

    @Autowired
    private RedisService redisService;

    /**
     * 连接建立成功调用的方法
     **/
    @OnOpen
    public void onOpen(Session session,
                       @PathParam("openid") String openid,
                       @PathParam("toOpenid") String toOpenid) {
        this.session = session;
        addOnlineCount();
        webSocketSet.put(openid, this);
        this.sender = openid;
        this.recipient = toOpenid;
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("收到来自窗口" + sender + "的信息:" + message + "，发送给：" + recipient);
        sendMessage(message);
    }


    private void sendMessage(String message) throws IOException {
        final WebSocketServer recipientServer = webSocketSet.get(recipient);
        if (recipientServer != null) {
            recipientServer.session.getBasicRemote().sendText(message);
            try {
                Db.use().insert(
                        Entity.create("chat_record")
                                .set("chat_record_content", message)
                                .set("send_open_id",this.sender)
                                .set("receive_open_id",this.recipient)
                                .set("send_time", LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //此时将信息暂时存放到redis
            String listKey = Constants.REDIS_UNREAD_MSG_PREFIX + recipient + ":" + "/topic/reply";
            log.info(MessageFormat.format("消息接收者{0}还未建立WebSocket连接，{1}发送的消息【{2}】将被存储到Redis的【{3}】列表中", recipient, sender, message, listKey));
            //存储消息到Redis中
            redisService.addToListRight(listKey, ExpireEnum.UNREAD_MSG, message);
        }
    }

    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(session.getId());
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
