package com.cloud.api.controller;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

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
    public String projectList(Model model) {
        final List<ModelUtil<Task, ModelUtil<String, String>>> allTaskData = projectService.getAllTaskData();
        model.addAttribute("modelObject", allTaskData);
        return "/X-admin/order/order-list";
    }

    @RequestMapping(value = "/search_data", method = RequestMethod.POST)
    public String searchData(@RequestBody String requestBody,
                             Model model) throws JsonProcessingException {

        String decode = URLDecoder.decode(requestBody, StandardCharsets.UTF_8);
        JsonNode search = new ObjectMapper().readTree(decode.substring(decode.indexOf("=") + 1));
        List<ModelUtil<Task, ModelUtil<String, String>>> modelObject = projectService.searchData(search);
        model.addAttribute("modelObject", modelObject);
        return "/X-admin/order/order-list::table_fragment";
    }

    @RequestMapping(value = "/project_add",method = RequestMethod.GET)
    public String orderAdd(){
        return "/X-admin/order/order-add";
    }

    @ResponseBody
    @RequestMapping(value = "/sort_data",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String sortData(Model model){
        List<TaskClassification> classifications =  projectService.getAllTaskClassification();
        model.addAttribute("classifications",classifications);
        return JsonNodeFactory.instance.objectNode().put("success", true).toPrettyString();
    }

    @RequestMapping(value = "/order_list")
    public String orderList() {
        return "/X-admin/order/order-list1";
    }
}
