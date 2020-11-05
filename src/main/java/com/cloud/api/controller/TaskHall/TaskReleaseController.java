package com.cloud.api.controller.TaskHall;
import com.cloud.api.service.TaskHall.TaskReleaseService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
 * @date 2020/10/29-18:42
 */
@Controller
@ResponseBody
@RequestMapping("/taskRelease")
@Api(tags = "任务发布")
public class TaskReleaseController {
    @Autowired
    private  TaskReleaseService taskReleaseService;

    @Operation(summary="获取全部任务分类")
    @GetMapping("/getTaskClassificationAll")
    public Result getTaskClassificationAll(@Parameter(description = "1为显示页面,2 为更多") @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 7);
        return ResultGenerator.genSuccessResult(new PageInfo<>(taskReleaseService.getTaskClassificationAll()));
    }

}
