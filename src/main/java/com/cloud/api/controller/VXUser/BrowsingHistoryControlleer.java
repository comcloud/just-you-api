package com.cloud.api.controller.VXUser;

import com.cloud.api.service.VXUser.BrowsingHistoryService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:31
 */
@Api(tags = "用户的历史浏览")
@RequestMapping("/user")
@Controller
public class BrowsingHistoryControlleer {
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
    @GetMapping("/getUserBrowsingHistoryVoByTask")
    @ResponseBody
    public Result getUserBrowsingHistoryVoByTask(@RequestParam String browsingHistoryOpenId){
        return ResultGenerator.genSuccessResult(browsingHistoryService.getUserBrowsingHistory(browsingHistoryOpenId));
    }
}
