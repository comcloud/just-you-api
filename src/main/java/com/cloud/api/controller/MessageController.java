package com.cloud.api.controller;

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
        return ResultGenerator.genSuccessResultInsertData(redisService.pullUnreadMessage(openid).replace("\\","").replace("\r\n",""));
    }

}
