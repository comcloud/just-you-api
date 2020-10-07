package com.cloud.api.controller;

import com.cloud.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 12:00
 */
@RequestMapping(value = "/project")
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project_list")
    public String projectList(Model model){
        model.addAttribute("modelObject",projectService.getAllTaskData());
        return "/X-admin/order/order-list";
    }

    @RequestMapping(value = "/order_list")
    public String orderList(){
        return "/X-admin/order/order-list1";
    }
}
