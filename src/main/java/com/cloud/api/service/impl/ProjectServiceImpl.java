package com.cloud.api.service.impl;

import com.cloud.api.bean.dto.SearchObject;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.mapper.ProjectMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:06
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ModelUtil<Task, ModelUtil<String, String>>> getAllTaskData() {
        List<Task> tasks = projectMapper.selectAllTask();
        return packing(tasks);
    }

    @Override
    public List<ModelUtil<Task, ModelUtil<String, String>>> searchData(JsonNode search) {
        LocalDateTime start = null;
        LocalDateTime end = null;
        final String startStr = search.findPath("start").toString().replace("\"", "").trim();
        final String endStr = search.findPath("end").toString().replace("\"", "").trim();
        if (!"".equals(startStr)) {
            start = LocalDateTime.parse(startStr);
        }
        if (!"".equals(endStr)) {
            end = LocalDateTime.parse(endStr);
        }
        String chargeStr = search.findPath("charge").toString().replace("\"", "").trim();
        String projectStateStr = search.findPath("projectState").toString().replace("\"", "").trim();
        String projectIdStr = search.findPath("projectId").toString().replace("\"", "").trim();
        Integer charge = null;
        Integer projectState = null;
        Integer projectId = null;
        if(!"".equals(chargeStr)){
            charge = Integer.parseInt(chargeStr);
        }
        if(!"".equals(projectStateStr)){
            projectState = Integer.parseInt(projectStateStr);
        }
        if(!"".equals(projectIdStr)){
            projectId = Integer.parseInt(projectIdStr);
        }
        SearchObject searchObject = new SearchObject();
        searchObject.setStart(start).setEnd(end).setCharge(charge).setProjectState(projectState).setProjectId(projectId);
        List<Task> tasks = projectMapper.selectTaskBySearch(searchObject);
        return packing(tasks);
    }

    @Override
    public List<TaskClassification> getAllTaskClassification() {
        return projectMapper.selectAllTaskClassification();
    }

    /**
     * 将指定的任务以及分类名和用户名打包
     *
     * @param tasks 任务列表
     * @return
     */
    private List<ModelUtil<Task, ModelUtil<String, String>>> packing(List<Task> tasks) {
        List<ModelUtil<Task, ModelUtil<String, String>>> modelUtilList = new ArrayList<>();
        tasks.forEach(task -> {
            ModelUtil<Task, ModelUtil<String, String>> first = new ModelUtil<>();
            ModelUtil<String, String> last = new ModelUtil<>();
            last.setFirstValue(projectMapper.selectSortNameByClassId(task.getClassId()))
                    .setLastValue(projectMapper.selectUsernameByUserId(task.getUserId()));
            first.setFirstValue(task).setLastValue(last);
            modelUtilList.add(first);
        });
        return modelUtilList;
    }
}
