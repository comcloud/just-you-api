package com.cloud.api.controller;

import com.cloud.api.bean.entity.User;
import com.cloud.api.service.CountService;
import com.cloud.api.service.UserService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/6-19:51
 */
@Controller
@RequestMapping(value = "/members")
public class membersController {
    @Autowired
    private UserService userService;
    @Autowired
    private CountService countService;

    /**
     * 返回统计页面统计数据 ， 跳转到统计页面
     * @param model
     * @return   "/X-admin/members/welcome";
     */
    @RequestMapping(value = "/welcome")
    public String welcome(Model model){
        int taskCount0 = countService.SelecttaskCount(0);
        int taskCount1 = countService.SelecttaskCount(1);
        int userCount = countService.selectUserCount();
        int dynamiccount = countService.selectDynamiccount();
        int taskOrder3 = countService.sekectTaskOrder3();
        model.addAttribute("taskCount0",taskCount0);
        model.addAttribute("taskCount1",taskCount1);
        model.addAttribute("userCount",userCount);
        model.addAttribute("dynamiccount",dynamiccount);
        model.addAttribute("taskOrder3",taskOrder3);
        return "/X-admin/members/welcome";
    }

    /**
     * 数据统计页面请求
     * @return  "/X-admin/members/welcome1"
     */
    @RequestMapping(value = "/welcome1")
    public String welcome1(){
        return "/X-admin/members/welcome1";
    }

    /**
     * 删除会员页面的请求
     * 用到 MyBatis  PageHelper 进行分页处理
     * @param model
     * @param pageNum 页码
     * @return
     */
    @RequestMapping(value = "/member_del")
    public String memberDel(Model model,
                            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<User> allUser = userService.getAllUser(1);
        PageInfo<User> userPageInfo = new PageInfo<>(allUser);
        model.addAttribute("pageInfo", userPageInfo);
        return "/X-admin/members/member-del";
    }

    /**
     * 会员的删除
     * @param id 会员ID
     * @return  返回响应结果
     */
    @ResponseBody
    @PostMapping(value = "/member_delete")
    public Result memberDeleteUse(@RequestBody() Long id){
        if (userService.deleteUser(id)){
            return  ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 根据用户ID 恢复删除的用户
     * @param UserId 用户id
     * @return 返回响应状态结果
     */
    @ResponseBody
    @PostMapping(value = "/replyUser")
    public Result replyUser(@RequestBody Long UserId ){
        if (userService.replyUser(UserId)){
            return  ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("恢复失败");
        }
    }

    /**
     * 批量恢复
     * @param ids 恢复用户ID 的 数组集合
     * @return 放映状态码
     */
    @ResponseBody
    @PostMapping(value = "/replyAllUser")
    public Result replyAllUser(@RequestBody Integer[] ids ){
        if (userService.replyAllUserByUserId(ids)){
            return  ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("恢复失败");
        }
    }

    /**
     * 批量删除用户
     * @param ids 用户ID 的 集合
     * @return 响应状态码
     */
    @PostMapping(value = "/member_deleteAll")
    @ResponseBody
    public Result memberDeleteUseAll(@RequestBody Integer[] ids){
        if (userService.updateUserDeleteAll(ids)){
            return  ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 根据用户ID 永久删除用户信息
     * @param UserId 用户id
     * @return 响应状态码
     */
    @ResponseBody
    @PostMapping("/permanentDeleteUser")
    public Result PermanentDeleteUser(@RequestBody Long  UserId){
        if (userService.PermanentDeleteUser(UserId)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 会员列表请求
     */
    @RequestMapping(value = "/member_list")
    public String memberList(Model model,
                             @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<User> allUser = userService.getAllUser(0);
        PageInfo<User> userPageInfo = new PageInfo<>(allUser);
        model.addAttribute("pageInfo", userPageInfo);
        return "/X-admin/members/member-list";
    }

    /**
     * 根据ID 修改用户状态 停用 或者 为停用
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/updateByState")
    public Result updateByState(@RequestBody Long id) {
         if (userService.selectUserStateByUserId(id)) {
            if (userService.updateUserStateTo0(id)) {
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("修改失败");
            }
        } else {
            if (userService.updateUserStateTo1(id)) {
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("修改失败");
            }
        }
    }

    /**
     *d
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/member_lists")
    public Result memberLists(){
        List<User> allUser = userService.getAllUser(0);
        Result result = ResultGenerator.genSuccessResult(allUser);
        return result;
    }
    @RequestMapping(value = "/member_list1")
    public String memberList1(){
        return  "/X-admin/members/member-list1";
    }

    /**
     * 根据加入时间或者ID 查询 用户 信息
     * @param start 开始时间
     * @param end 截止时间
     * @param username 用户OPenID
     */
    @PostMapping("/searchUser")
    public String searchUser (@RequestParam("start") String start,
                          @RequestParam("end") String end,
                          @RequestParam("username") String username,
                          Model model,
                          @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<User> users = userService.searchUserByOpen(start, end, username);
        System.out.println(users);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo", userPageInfo);
        return  "/X-admin/members/member-list";
    }
    @PostMapping("/searchDleUser")
    public String searchDleUser(@RequestParam("start") String start,
                                 @RequestParam("end") String end,
                                  @RequestParam("username") String username,
                                  Model model,
                                   @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) throws ParseException {
        PageHelper.startPage(pageNum, 10);
        List<User> users = userService.searchDelUserByOpen(start, end, username);
        System.out.println(users);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo", userPageInfo);
        return "/X-admin/members/member-del";
    }
    @ResponseBody
    @PostMapping("/recently7CountUser")
    public Result<Map<String,Object>> Recently7CountUser(){
        System.out.println(countService.get7CountUser());
        return countService.get7CountUser();
    }
}
