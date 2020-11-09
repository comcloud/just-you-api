package com.cloud.api.controller.TaskHall;

import com.cloud.api.service.TaskHall.TaskSearchService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-11:08
 */
@Api(value = "动态的Controller", tags = {"任务搜索类接口"})
@Controller
@RequestMapping("/taskSearch")
@ResponseBody
public class TaskSearchController {
    @Autowired
    private TaskSearchService taskSearchService;

    @Operation(summary = "最近搜索数据")
    @GetMapping("/recentlySearch")
    public Result recentlySearch(@Parameter(description = "用户的Open_id") @RequestParam("open_id") String open_id) {
        return ResultGenerator.genSuccessResult(taskSearchService.getRecentlySearch(open_id));
    }

    @Operation(summary = "热门标签")
    @GetMapping("/hotTag")
    public Result hotTag() {
        return ResultGenerator.genSuccessResult(taskSearchService.selectHotTag());
    }

    @Operation(summary = "点击热门标签")
    @GetMapping("/getLinkTaskByTagId")
    public Result getLinkTaskByTagId(@Parameter(description = "标签ID") @RequestParam("tag_id") Long tag_id,
                                     @Parameter(description = "页码") @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        return ResultGenerator.genSuccessResult(taskSearchService.getLinkTaskByTagId(tag_id));
    }

    @Operation(summary = "任务搜索 占时还是没有做出来")
    @RequestMapping(value = "/SearchDynamicAll", method = RequestMethod.GET)
    public Result SearchDynamicAll(@Parameter(description = "搜索框输入的内容") @RequestParam String content,
                                   @Parameter(description = "open_id") @RequestParam String open_id,
                                   @Parameter(description = "页码 默认为1") @RequestParam(defaultValue = "1", value = "pageNum") Integer pagNum) {
        PageHelper.startPage(pagNum, 5);
        taskSearchService.insertSearch(content, open_id);
        return ResultGenerator.genSuccessResult(new PageInfo<>(taskSearchService.setLinkTaskSearchVos(content)));
    }
}
