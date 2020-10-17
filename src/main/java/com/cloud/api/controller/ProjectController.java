package com.cloud.api.controller;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 跳转到projectList页面
     * 存储任务列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/project_list")
    public String projectList(Model model) {
        final List<ModelUtil<Task, ModelUtil<String, String>>> allTaskData = projectService.getAllTaskData();
        model.addAttribute("modelObject", allTaskData);
        return "/X-admin/order/order-list";
    }

    /**
     * 查询数据
     *
     * @param requestBody 存储搜索的依据
     * @param model
     * @return 查询结果
     * @throws JsonProcessingException json解析异常
     */
    @RequestMapping(value = "/search_data", method = RequestMethod.POST)
    public String searchData(@RequestBody String requestBody,
                             Model model) throws JsonProcessingException {
        String decode = URLDecoder.decode(requestBody, StandardCharsets.UTF_8);
        JsonNode search = new ObjectMapper().readTree(decode.substring(decode.indexOf("=") + 1));
        List<ModelUtil<Task, ModelUtil<String, String>>> modelObject = projectService.searchData(search);
        model.addAttribute("modelObject", modelObject);
        return "/X-admin/order/order-list::table_fragment";
    }


    /**
     * @param model 存储任务数据
     * @param id    要查看的任务id
     * @return 查看任务view
     */
    @RequestMapping(value = "/project_view", method = RequestMethod.GET)
    public String lookProject(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("taskMap", projectService.getContentById(id));
        return "/X-admin/members/member-add";
    }

    /**
     * @return 跳转到任务添加页面
     */
    @RequestMapping(value = "/project_add", method = RequestMethod.GET)
    public String orderAdd(Model model) {
        List<TaskClassification> classifications = projectService.getAllTaskClassification();
        model.addAttribute("classifications", classifications);
        return "/X-admin/order/order-add";
    }

    @ResponseBody
    @RequestMapping(value = "/delete_task", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String deleteTask(@RequestBody Integer id) {
        return JsonNodeFactory.instance.objectNode().put("success", projectService.removeTaskById(id)).toPrettyString();
    }

    /**
     * 保存任务数据到数据库中
     *
     * @param requestBody 请求体
     * @return 保存任务结果
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/add_project", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String addProject(@RequestBody String requestBody) throws JsonProcessingException {
        final String decode = URLDecoder.decode(requestBody, StandardCharsets.UTF_8);
        final JsonNode node = new ObjectMapper().readTree(decode.substring(decode.indexOf("=") + 1));
        return JsonNodeFactory.instance.objectNode().put("success", projectService.saveNewProject(node)).toPrettyString();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String deleteList(@RequestBody Integer[] list) {
        return JsonNodeFactory.instance.objectNode().put("success", projectService.removeList(list)).toPrettyString();
    }

    /**
     * 将分类数据存储到model中
     *
     * @param model 存储模型
     * @return 结果
     */
    @ResponseBody
    @RequestMapping(value = "/sort_data", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String sortData(Model model) {
        List<TaskClassification> classifications = projectService.getAllTaskClassification();
        model.addAttribute("classifications", classifications);
        return JsonNodeFactory.instance.objectNode().put("success", true).toPrettyString();
    }


}
