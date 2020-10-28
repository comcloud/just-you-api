package com.cloud.api.controller.VXUser;

import com.cloud.api.bean.vo.UserAttention;
import com.cloud.api.service.VXUser.VXUserService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/27-4:10
 */
@Api(value = "VX 用户信息Controller" ,tags = {"用户信息管理接口"})
@Controller
@RequestMapping("/user")
public class VXUserController {
    @Autowired
    private VXUserService VXUserService;
    @ResponseBody
    @Operation(summary = "当用户授权时存储用户数据信息")
    @GetMapping("/insertUser")
    public Result insertUser(@ApiParam(name = "openid" ,value = "用户OPenID") @RequestParam("openid") String openid,
                             @ApiParam(name = "nickName" ,value = "用户昵称")  @RequestParam("nickName") String nickName,
                             @ApiParam(name = "gender" ,value = "性别 女 0 男 1")  @RequestParam("gender") Integer gender,
                             @ApiParam(name = "avatarUrl" ,value = "头像URL")  @RequestParam("avatarUrl") String avatarUrl,
                             @ApiParam(name = "province" ,value = "用户地址")  @RequestParam("province") String province ){
        if (VXUserService.insertUser(openid, nickName, gender, avatarUrl, province)){
            return ResultGenerator.genSuccessResult("保存成功！！！");
        }else {
            return ResultGenerator.genFailResult("保存失败！！");
        }
    }
    @ResponseBody
    @Operation(summary = "点击关注")
    @GetMapping("/attentionUser")
    public Result attentionUser(@ApiParam(name="MyOpenId",value = "个人的Open_ID") @RequestParam String MyOpenId,
                                @ApiParam(name = "HeOpenId",value = "关注对方的ID") @RequestParam String HeOpenId){
        if (VXUserService.attentionUser(MyOpenId, HeOpenId)){
            return ResultGenerator.genSuccessResult("关注+1");
        }else {
            return ResultGenerator.genFailResult("关注失败");
        }
    }
    @ResponseBody
    @Operation(summary = "点击取消关注")
    @GetMapping("/cancelttentionUser")
    public Result cancelttentionUser(@ApiParam(name="MyOpenId",value = "个人的Open_ID") @RequestParam String MyOpenId,
                                @ApiParam(name = "HeOpenId",value = "关注对方的ID") @RequestParam String HeOpenId){
        if (VXUserService.cancelttentionUser(MyOpenId, HeOpenId)){
            return ResultGenerator.genSuccessResult("已取消");
        }else {
            return ResultGenerator.genFailResult("取消失败");
        }
    }
    @ResponseBody
    @Operation(summary = "获取关注用户列表")
    @GetMapping("/selectAttentionUser")
    public Result selectAttentionUser(@ApiParam(name="open_id",value = "用户的OPenId") @RequestParam String open_id,
                                      @ApiParam(name="pagNum",value = "页数")  @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 10);
        List<UserAttention> userAttentions = VXUserService.selectAttentionUser(open_id);
        return ResultGenerator.genSuccessResult(new PageInfo<>(userAttentions));
    }
    @ResponseBody
    @Operation(summary = "获取粉丝列表")
    @GetMapping("/selectFansUser")
    public Result selectFansUser(@ApiParam(name="open_id",value = "用户的OPenId") @RequestParam String open_id,
                                 @ApiParam(name="pagNum",value = "页数")  @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 10);
        return ResultGenerator.genSuccessResult(new PageInfo<>(VXUserService.selectFansUser(open_id)));
    }
    @ResponseBody
    @Operation(summary = "关注数量")
    @GetMapping("/attentionCount")
    private Result attentionCountAll(@ApiParam(name="open_id",value = "用户的OPenId") @RequestParam String open_id){
        return ResultGenerator.genSuccessResult(VXUserService.attentionCountAll(open_id));
    }

  /*  *//**
     * 返回
     * @param MyOpenId
     * @param HeOpenId
     * @return boolean 值 t有 f 无
     *//*
    @ResponseBody
    @Operation(summary = "判断用户是否关注了哪个用户")
    @GetMapping("iSTtentionUser")
    private Result getISTtentionUser(@ApiParam(name="MyOpenId",value = "用户的OPenId") @RequestParam String MyOpenId,
                                     @ApiParam(name="HeOpenId",value = "用户的OPenId") @RequestParam String HeOpenId){
        return ResultGenerator.genSuccessResult(VXUserService.SelectISTtentionUser(MyOpenId, HeOpenId));
    }*/
}
