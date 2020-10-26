package com.cloud.api.controller;

import com.cloud.api.bean.dto.Constants;
import com.cloud.api.bean.entity.User;
import com.cloud.api.config.websocket.WebSocketServer;
import com.cloud.api.service.RedisService;
import com.cloud.api.util.websocket.SpringContextUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    private RedisService redisService;

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
