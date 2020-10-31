package com.cloud.api.util.websocket;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.cloud.api.config.websocket.WebSocketServer;
import com.cloud.api.service.RedisService;
import com.cloud.api.util.SpringUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/29 14:26
 */
public class MessageUtil {

    private static Logger log = LoggerFactory.getLogger(MessageUtil.class);

    /**
     * @param message 消息
     * @param recipient 接收者
     * @param sender 发送者
     * @throws IOException
     */
    public static void sendMessage(String message,String recipient,String sender) throws IOException {
        AtomicReference<WebSocketServer> recipientServer = new AtomicReference<>();
        final Integer recipientServerLocation = WebSocketServer.data.get(recipient);
        if (recipientServerLocation != null) {
            WebSocketServer.webSocketSet.forEach(value -> {
                //一个websocket对象的sender说明这是属于谁的
                if (value.sender.equals(recipient)) {
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
                                    .set("send_open_id", sender)
                                    .set("receive_open_id", recipient)
                                    .set("send_time", LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //此时将信息暂时存放到redis
            log.info(MessageFormat.format("消息接收者{0}还未建立WebSocket连接，{1}发送的消息【{2}】将被存储到Redis的【{3}】列表中", recipient, sender, message, recipient));
            //存储消息到Redis中
            final ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("sender", sender);
            node.put("message", message);
            node.put("sendTime", LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            final RedisService redisService = (RedisService) SpringUtil.getBean("redisService");
            redisService.addKey(recipient, node.toString());
        }
    }
}
