package com.cloud.api.controller;

import com.cloud.api.bean.dto.MessageDto;
import com.cloud.api.bean.vo.MessageVo;
import com.cloud.api.service.MessageService;
import com.cloud.api.service.RedisService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/25 9:27
 */
@Controller
@RequestMapping(value = "/message")
@Api(tags = "消息管理接口")
public class MessageController {
    private final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private MessageService messageService;

    /**
     * 拉取指定监听路径的未读的WebSocket消息
     *
     * @param openid 拉取的对象
     * @return 结果数据
     */
    @GetMapping("/pullUnreadMessage")
    @ResponseBody
    @Operation(summary = "拉取用户没有读的消息")
    public Result pullUnreadMessage(@Parameter(description = "待拉取的用户的Open id") @RequestParam(value = "openid") String openid) {
        log.info("拉取用户:||{}||数据", openid);
        return ResultGenerator.genSuccessResultInsertData(redisService.pullUnreadMessage(openid).replace("\\", "").replace("\r\n", ""));
    }

    @Operation(summary = "操作消息推送，当用户触发这个类型的事件时候就会执行对应的功能")
    @RequestMapping(value = "/messagePush")
    public void messagePush(@Parameter(description = "消息类型，定义为1：点赞，2：评论，3：任务参加通知，4：关注事件,5：官方通知") @RequestParam(value = "messageType") Integer messageType,
                              @Parameter(description = "执行者Open id") @RequestParam(value = "sender") String sender,
                              @Parameter(description = "被执行者open id，也就是说被点赞的人或者被评论的对象等") @RequestParam(value = "recipient") String recipient,
                              @Parameter(description = "操作的任务id或者动态id") Integer id,
                              @Parameter(description = "操作的类型,1：任务，2：动态") @RequestParam(value = "type") Integer type) {
        final MessageVo messageVo = new MessageVo(messageType, sender, recipient, id, type);
        messageService.pushMessage(messageVo);

    }

}
