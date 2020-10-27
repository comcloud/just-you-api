package com.cloud.api.controller;

import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.service.classificationService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @author hds
 * <p>项目名称: 对于分类的控制层
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/19-19:11
 */
@Controller
@RequestMapping("/cate")
public class classificationController {
    @Autowired
    private classificationService classificationService;

    /**
     * 遍历分类页面
     * @param model
     * @param pageNum 页码
     * @return "/X-admin/cate/cate"
     */
    @RequestMapping("/listCate")
    public String gotoCate(Model model,
                           @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<TaskClassification> allfTaskClassification = classificationService.getAllfTaskClassification();
        PageInfo<TaskClassification> pageInfo = new PageInfo<>(allfTaskClassification);
        System.out.println(pageInfo);
        model.addAttribute("pageInfo", pageInfo);
        return "/X-admin/cate/cate";
    }
    @ResponseBody
    @PostMapping("updateSort")
    public Result updateSort(@RequestParam Integer sort, @RequestParam Long class_id){

        if ( classificationService.updateSort(sort+"",class_id)){
            return ResultGenerator.genSuccessResult("修改成功");
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 根据class_id 删除分类
     * @param class_id 分类ID
     * @return 响应体
     */
    @ResponseBody
    @PostMapping("/member_del")
    public Result member_del(@RequestParam Long class_id){
        if (classificationService.deleteClassificationByClassId(class_id)){
            return ResultGenerator.genSuccessResult("删除成功");
        }else {
            return ResultGenerator.genFailResult("删除失败！！");
        }
    }
    @GetMapping("/cate_edit")
    public String goTocate_edit(){
        return "/X-admin/cate/cate-edit";
    }

    /**
     * 遍历删除页面
     * @param model
     * @param pageNum 删除页面页码
     * @return "/X-admin/cate/cate-del"
     */
    @GetMapping("/cate_del")
    public String goTocateDel(Model model,
                              @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        model.addAttribute("pageInfo",new PageInfo<>(classificationService.getDelAllTaskClassification()));
        return "/X-admin/cate/cate-del";
    }
    @ResponseBody
    @PostMapping("/restoreClass")
    public Result restoreClass(@RequestBody Long class_id){
        if (classificationService.restoreClassificationByClassId(class_id)){
            return ResultGenerator.genSuccessResult("恢复成功！！");
        }else {
            return ResultGenerator.genFailResult("操作失败！！");
        }
    }

    /**
     * 彻底删除分类 如果是父分类 然后删除父分类加子分类
     * @param class_id 分类ID
     * @return 相应结果
     */
    @ResponseBody
    @PostMapping("/thoroughlyDeleteClass")
    public Result thoroughlyDeleteClass(@RequestBody Long class_id){
        if (classificationService.thoroughlyDeleteClassificationByClassId(class_id)){
            return ResultGenerator.genSuccessResult("已经彻底删除！！");
        }else{
            return ResultGenerator.genFailResult("操作失败！！");
        }
    }

    @ResponseBody
    @PostMapping("/cate_deleteAll")
    public Result cateDeleteAll(@RequestBody Long[] ids) {
        if (classificationService.cateDeleteAll(ids)) {
            return ResultGenerator.genSuccessResult("删除成功！！");
        } else {
            return ResultGenerator.genFailResult("操作失败！！");
        }
    }
    @ResponseBody
    @PostMapping("/restoreDeleteAll")
    public Result restoreDeleteAll(@RequestBody Long[] ids) {
        if (classificationService.restoreDeleteAll(ids)) {
            return ResultGenerator.genSuccessResult("删除成功！！");
        } else {
            return ResultGenerator.genFailResult("操作失败！！");
        }
    }
}

