package com.cloud.api.controller.TaskHall;

import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.service.TaskHall.TaskCommService;
import com.cloud.api.service.TaskHall.TaskHallService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;


/**
 * @author hds
 * <p>项目名称: 小程序 任务大厅
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-13:29
 */
@RequestMapping("/taskHall")
@Controller
@Api(tags = "任务大厅管理接口")
public class TaskHallController {
    @Autowired
    private TaskHallService taskHallService;
    @Autowired
    private TaskCommService taskCommService;

    /**
     * 任务大厅任务展示
     *
     * @param pageNum 触底刷新后，前端将pageNum加1返回给后端
     * @return https://s1.ax1x.com/2020/10/23/BAVfLd.png
     * {
     * resultCode : 200(成功) / 500（失败）
     * message：反应结果字符串
     * data：[
     * list : [{TaskHallVo} ,{TaskHallVo}]
     * pageNum  : 当前页码
     * pageSize : 每页的数量
     * size : 当前页的数量
     * startRow :
     * endRow : 当前页面最后一个元素在数据库中的行号
     * pages : 总页数
     * prePage : 前一页
     * nextPage : 下一页
     * isFirstPage:  是否为第一页
     * isLastPage : 是否为最后一页
     * hasPreviousPage : 是否有前一页
     * hasNextPage : 是否有后一页
     * navigatePages : 导航栏页码数
     * navigatepageNums : [] 所有导航栏业号
     * navigateFirstPage :
     * navigateLastPage :
     * lastPage :
     * firstPage :
     * ]
     * }
     */
    @ResponseBody
    @Operation(summary = "获取任务大厅数据")
    @RequestMapping(value = "/TaskList", method = RequestMethod.GET)
    public Result taskHallList(@Parameter(description = "页码，默认是1") @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<TaskHallVo> task_hallList = taskHallService.getTask_HallList();
        System.out.println("8888888888888888888888888888888888888888888888888888888");
        System.out.println(task_hallList);
        System.out.println("8888888888888888888888888888888888888888888888888888888");
        return ResultGenerator.genSuccessResult(new PageInfo<>(task_hallList));
    }


    /**
     * 返回分类集合
     *
     * @return https://s1.ax1x.com/2020/10/23/BAVaM4.png
     */
    @ResponseBody
    @Operation(summary = "返回分类集合")
    @GetMapping("/listClassName")
    public Result listClassName() {
        return ResultGenerator.genSuccessResult(taskHallService.getAllClassName());
    }

    /**
     * @param pageNum  页码
     * @param class_id 分类Id
     * @return https://s1.ax1x.com/2020/10/23/BAVfLd.png
     */
    @ResponseBody
    @Operation(summary = "根据分类id获取任务")
    @GetMapping("/TaskByClass")
    public Result getClassNameAll(@Parameter(description = "页码数，默认是1") @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                  @Parameter(description = "分类id") @RequestParam("class_id") Long class_id) {
        PageHelper.startPage(pageNum, 3);
        return ResultGenerator.genSuccessResult(new PageInfo(taskHallService.getTaskListByClass(class_id)));
    }

    @Operation(summary = "获取任务评论")
    @GetMapping("/comm")
    @ResponseBody
    public Result comm(@ApiParam(name = "task_id", value = "任务Id") @RequestParam Long task_id) {
        return ResultGenerator.genSuccessResult(taskCommService.getAllTaskComm(task_id));
    }
    @ResponseBody
    @Operation(summary="获取全部任务分类")
    @GetMapping("/getTaskDetails")
    public Result getTaskDetails(@Parameter(description = "任务ID") @RequestParam Long TaskId) {
        return ResultGenerator.genSuccessResult(taskHallService.getTaskDetails(TaskId));
    }

}