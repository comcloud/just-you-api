package com.cloud.api.controller.publish;

import com.cloud.api.service.PublishService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/29 20:08
 */
@Api(value = "/publish", tags = "发布接口")
@Controller
@RequestMapping(value = "/publish")
public class PublishController {

    @Autowired
    private PublishService publishService;


    /**
     * @param requestBody 发布的任务信息
     * @return 保存结果
     */
    @ResponseBody
    @Operation(summary = "保存最新发布任务信息")
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result publish(@Parameter(example = "{\n" +
            "  \"class_id\": \"\",\n" +
            "  \"open_id\": \"\",\n" +
            "  \"charge\": \"\",\n" +
            "   \"need_number\": \"\",\n" +
            "  \"recruiting_number\": \"\",\n" +
            "  \"task_comment\": \"\",\n" +
            "  \"task_description\": \"\",\n" +
            "  \"start_time\": \"\",\n" +
            "  \"end_time\": \"\",\n" +
            "  \"money\": \"\",\n" +
            "  \"task_title\": \"\",\n" +
            "  \"tag\": {\n" +
            "\n" +
            "  },\n" +
            "  \"data\": \"\"\n" +
            "\n" +
            "}\n", description = "存储保存的发布任务信息") @RequestBody String requestBody) {
        publishService.saveReleaseInfo(requestBody);
        return ResultGenerator.genSuccessResult();
    }

}
