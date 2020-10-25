package com.cloud.api.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HP
 */
@Slf4j
@Component
@EnableWebSocket
@EnableWebSocketMessageBroker
@ServerEndpoint(value = "/websocket/{openid}/{toOpenid}")
public class WebSocketServer {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    public static Map<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收openid
     */
    private String sender = "";

    /**
     *  接收者
     */
    private String recipient;

    /**
     * 连接建立成功调用的方法
     **/
    @OnOpen
    public void onOpen(Session session,
                       @PathParam("openid") String openid,
                       @PathParam("toOpenid") String toOpenId) {
        this.session = session;
        //加入set中
        webSocketSet.put(session.getId(), this);
        //在线数加1
        addOnlineCount();
        log.info("有新窗口开始监听:" + openid + ",当前在线人数为" + getOnlineCount());
        this.sender = openid;
        this.recipient = toOpenId;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this.sender);
        //在线数减1
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     **/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口" + sender + "的信息:" + message);
        simpMessagingTemplate.convertAndSendToUser(sender, recipient,message);
        //群发消息
        webSocketSet.forEach((k, y) -> {
            try {
                y.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);

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

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
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
