package com.cloud.api.controller.BlogThehall;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import com.cloud.api.service.BlogThehall.DynamicCommentsService;
import com.cloud.api.service.BlogThehall.Impl.DynamicCommentsServiceImpl;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;

/**
 * @author hds
 * <p>项目名称: 动态大厅
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-9:20
 */
@Api(value = "动态的Controller" ,tags = {"动态大厅的操作接口"})
@Controller
public class BlogThehallController {
    @Autowired
    private BlogThehallService blogThehallService;
    @Autowired
    private DynamicCommentsService dynamicCommentsService;

    /**
     * 动态页面
     * @param pageNum 页码
     * @return https://s1.ax1x.com/2020/10/23/BA4qCF.png
     */
    @Operation(summary = "获取动态大厅首页显示列表" )
    @ResponseBody
    @GetMapping("/gotoHomePage")
    public Result gotoHomePage(@ApiParam(name="pageNum",value = "页码 默认值为1",required = true) @RequestParam(defaultValue="1" ,value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        return ResultGenerator.genSuccessResult(new PageInfo<>(blogThehallService.getPushAllBlog()));
    }
    @Operation(summary = "获取动态详情页面信息" )
    @ResponseBody
    @GetMapping("/gotoDynamicDetails")
    public Result gotoDynamicDetails(@ApiParam(name="dynamic_id" ,value = "动态iD") @RequestParam Long dynamic_id){
        return ResultGenerator.genSuccessResult(blogThehallService.getDynamicDetails(dynamic_id));
    }
    @Operation(summary = "获取动态评论" )
    @GetMapping("/comm")
    @ResponseBody
    public Result comm(@ApiParam(name="dynamic_id" ,value = "动态iD") @RequestParam Long dynamic_id){
        return ResultGenerator.genSuccessResult(dynamicCommentsService.getAllTaskComm(dynamic_id));
    }




}
