package com.cloud.api.controller.upload;

import com.cloud.api.service.GraphBedService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义的一个图床接口
 * 这个接口规则生成地址：https://mrkleo.op/年/月/日/图片随机ID.jpg
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/27 10:22
 */
@Controller
@Api(tags = "图床接口")
@RequestMapping(value ="/upload")
@SuppressWarnings("all")
public class GraphBedController {

    @Autowired
    private GraphBedService graphBedService;

    /**
     * @param body 图片数据请求体
     * @return 图片访问地址
     */
    @ResponseBody
    @Operation(summary = "上传图片接口，使用Post请求")
    @PostMapping("/upload_image")
    public Result upload(@Parameter(description = "请求体，要求图片base64对应的键名为image") @RequestBody String body){
        return ResultGenerator.genSuccessResultInsertData(graphBedService.upload(body));
    }
}
