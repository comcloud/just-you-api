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
import java.time.Instant;
import java.util.stream.Stream;

/**
 * @author hds
 * <p>项目名称: 动态大厅
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-9:20
 */
@Api(value = "动态的Controller", tags = {"动态大厅的操作接口"})
@Controller
@ResponseBody
@RequestMapping("/dynamic")
public class BlogThehallController {
    @Autowired
    private BlogThehallService blogThehallService;
    @Autowired
    private DynamicCommentsService dynamicCommentsService;

    /**
     * 动态页面
     *
     * @param pageNum 页码
     * @return https://s1.ax1x.com/2020/10/23/BA4qCF.png
     */
    @Operation(summary = "获取动态大厅首页显示列表")
    @GetMapping("/gotoHomePage")
    public Result gotoHomePage(@ApiParam(name = "pageNum", value = "页码 默认值为1", required = true) @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                               @ApiParam(name = "openId", value = "用户ID") @RequestParam String openId
    ) {
        PageHelper.startPage(pageNum, 3);
        return ResultGenerator.genSuccessResult(new PageInfo<>(blogThehallService.getPushAllBlog(openId)));
    }

    @Operation(summary = "获取动态详情页面信息")
    @GetMapping("/gotoDynamicDetails")
    public Result gotoDynamicDetails(@ApiParam(name = "dynamic_id", value = "动态iD") @RequestParam Long dynamic_id,
                                     @ApiParam(name = "openId", value = "用户ID") @RequestParam String openId) {
        return ResultGenerator.genSuccessResult(blogThehallService.getDynamicDetails(dynamic_id, openId));
    }

    @Operation(summary = "获取动态评论")
    @GetMapping("/comm")
    public Result comm(@ApiParam(name = "dynamic_id", value = "动态iD") @RequestParam Long dynamic_id) {
        return ResultGenerator.genSuccessResult(dynamicCommentsService.getAllTaskComm(dynamic_id));
    }

    @Operation(summary = "点赞")
    @GetMapping("/giveALike")
    public Result giveALike(@ApiParam(name = "dynamic_id", value = "动态iD") @RequestParam Long dynamic_id,
                            @ApiParam(name = "openId", value = "用户openID") @RequestParam String openId) {
        if (dynamicCommentsService.giveALike(dynamic_id, openId)) {
            return ResultGenerator.genSuccessResult("+1");
        } else {
            return ResultGenerator.genFailResult("点赞失败");
        }
    }

    @Operation(summary = "取消点赞")
    @GetMapping("/cancelGiveALike")
    public Result cancelGiveALike(@ApiParam(name = "dynamic_id", value = "动态iD") @RequestParam Long dynamic_id,
                                  @ApiParam(name = "openId", value = "用户openID") @RequestParam String openId) {
        if (dynamicCommentsService.selectIFAddLike(dynamic_id, openId)) {
            return ResultGenerator.genSuccessResult("-1");
        } else {
            return ResultGenerator.genFailResult("点赞取消失败");
        }
    }

    @Operation(summary = "用户评论")
    @GetMapping("/comments")
    public Result comments(@ApiParam(name = "dynamic_id", value = "动态iD") @RequestParam Long dynamic_id,
                           @ApiParam(name = "open_id", value = "用户ID") @RequestParam String open_id,
                           @ApiParam(name = "comm_father_id", value = "父评论ID 没有默认为0 顶级评论父评论Id为0") @RequestParam Long comm_father_id,
                           @ApiParam(name = "content", value = "评论内容") @RequestParam String content
    ) {
        if (dynamicCommentsService.insertComments(dynamic_id, open_id, comm_father_id, content)) {
            return ResultGenerator.genSuccessResult("评论成功！！");
        } else {
            return ResultGenerator.genFailResult("评论失败");
        }
    }

    @Operation(summary = "删除用户评论")
    @GetMapping("/deleteComm")
    public Result deleteComm(@ApiParam(name = "comId", value = "评论ID") @RequestParam Long commId) {
        if (dynamicCommentsService.deleteComm(commId)) {
            return ResultGenerator.genSuccessResult("评论已删除");
        } else {
            return ResultGenerator.genFailResult("删除失败比");
        }
    }


    @Operation(summary = "发布动态接口")
    @PostMapping(value = "/publishDynamic")
    public Result publishDynamic(@RequestBody String dynamicData){
        blogThehallService.addDynamic(dynamicData);
        return ResultGenerator.genSuccessResult();
    }
}
