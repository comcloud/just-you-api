package com.cloud.api.controller;

import com.cloud.api.bean.dto.Constants;
import com.cloud.api.bean.dto.ExpireEnum;
import com.cloud.api.bean.entity.User;
import com.cloud.api.config.websocket.WebSocketServer;
import com.cloud.api.service.RedisService;
import com.cloud.api.util.websocket.SpringContextUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/25 9:27
 */
@Controller
@Api(tags = "消息管理接口")
public class MessageController {
    private final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private WebSocketServer webSocketServer;

    @Autowired
    private RedisService redisService;

    @Operation(summary = "向指定用户发送消息")
    @RequestMapping(value = "/sendToUser",method = RequestMethod.POST)
    public void greeting(@Parameter(description = "存放接收者以及发送的消息json串", example = "{\n" +
            "  \"sender\": \"xxxx\",\n" +
            "  \"receiver\": \"yyyy\",\n" +
            "  \"payload\": \"你好，我是消息\"\n" +
            "}")
                         @RequestBody String obj) throws JsonProcessingException {
        log.info("服务器端向客户端的指定用户发送消息");
        final JsonNode node = new ObjectMapper().readTree(obj);
        final String receiver = node.findPath("receiver").toString();
        final String sender = node.findPath("sender").toString();
        final String payload = node.findPath("payload").toString();
        this.webSocketServer = WebSocketServer.webSocketSet.get(receiver);
        //如果接收者存在，则发送消息
        if (webSocketServer != null) {
            this.simpMessagingTemplate.convertAndSendToUser(receiver, "/topic/reply", payload);
        }
        //否则将消息存储到redis，等用户上线后主动拉取未读消息
        else {
            //存储消息的Redis列表名
            String listKey = Constants.REDIS_UNREAD_MSG_PREFIX + receiver + ":" + "/topic/reply";
            log.info(MessageFormat.format("消息接收者{0}还未建立WebSocket连接，{1}发送的消息【{2}】将被存储到Redis的【{3}】列表中", receiver, sender, payload, listKey));
            //存储消息到Redis中
            redisService.addToListRight(listKey, ExpireEnum.UNREAD_MSG, payload);
        }

    }

    /**
     * 拉取指定监听路径的未读的WebSocket消息
     *
     * @param destination 指定监听路径
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/pullUnreadMessage")
    @ResponseBody
    @Operation(summary = "拉取用户没有读的消息")
    public Map<String, Object> pullUnreadMessage(@Parameter(description = "指定监听路径，默认为/topic/reply") String destination) {
        Map<String, Object> result = new HashMap<>();
        destination = destination == null || "".equals(destination) ? "/topic/reply" : destination;
        try {
            HttpSession session = SpringContextUtil.getSession();
            User loginUser = (User) session.getAttribute(Constants.SESSION_USER);

            //存储消息的Redis列表名
            String listKey = Constants.REDIS_UNREAD_MSG_PREFIX + loginUser.getUserName() + ":" + destination;
            //从Redis中拉取所有未读消息
            List<Object> messageList = redisService.rangeList(listKey, 0, -1);

            result.put("code", "200");
            if (messageList != null && messageList.size() > 0) {
                //删除Redis中的这个未读消息列表
                redisService.delete(listKey);
                //将数据添加到返回集，供前台页面展示
                result.put("result", messageList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "500");
            result.put("msg", e.getMessage());
        }

        return result;
    }

}
