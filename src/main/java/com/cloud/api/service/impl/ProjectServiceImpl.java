package com.cloud.api.service.impl;

import com.cloud.api.bean.dto.SearchObject;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.mapper.ProjectMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:06
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    private Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);


    /**
     * @return 任务数据列表
     */
    @Override
    public List<ModelUtil<Task, ModelUtil<String, String>>> getAllTaskData() {
        return packing(projectMapper.selectAllTask());
    }

    @Override
    public List<ModelUtil<Task, ModelUtil<String, String>>> searchData(JsonNode search) {
        LocalDateTime start = null;
        LocalDateTime end = null;
        final String startStr = search.findPath("start").toString().replace("\"", "").trim();
        final String endStr = search.findPath("end").toString().replace("\"", "").trim();
        if (!"".equals(startStr)) {
            start = LocalDateTime.parse(startStr+"T00:00:00");
        }
        if (!"".equals(endStr)) {
            end = LocalDateTime.parse(endStr+"T00:00:00");
        }
        String chargeStr = search.findPath("charge").toString().replace("\"", "").trim();
        String projectStateStr = search.findPath("projectState").toString().replace("\"", "").trim();
        String projectIdStr = search.findPath("projectId").toString().replace("\"", "").trim();
        Integer charge = null;
        Integer projectState = null;
        Integer projectId = null;
        if (!"".equals(chargeStr)) {
            charge = Integer.parseInt(chargeStr);
        }
        if (!"".equals(projectStateStr)) {
            projectState = Integer.parseInt(projectStateStr);
        }
        if (!"".equals(projectIdStr)) {
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
     * 管理员保存新的任务
     *
     * @param node 任务数据
     * @return 保存结果
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public boolean saveNewProject(JsonNode node) {
        Task task = new Task();
        task.setId((long) 0)
                .setCharge(Integer.parseInt(node.findPath("charge").toString().replace("\"", "")))
                .setClassId((long) Integer.parseInt(node.findPath("sort").toString().replace("\"", "")))
                .setData(node.findPath("projectData").toString().replace("\"", ""))
                .setNeedNumber(Integer.parseInt(node.findPath("needNumber").toString().replace("\"", "")))
                .setRecruitingNumber(Integer.parseInt(node.findPath("recruitingNumber").toString().replace("\"", "")))
                .setReleaseTime(LocalDateTime.parse(node.findPath("releaseTime").toString().replace("\"", "")))
                .setState(Integer.parseInt(node.findPath("state").toString().replace("\"", "")))
                .setTaskComment(Integer.parseInt(node.findPath("comment").toString().replace("\"", "")))
                .setTaskDescription(node.findPath("desc").toString().replace("\"", ""))
                //表示是管理员保存
                .setUserId((long) 1);
        return projectMapper.insertOneTask(task);

    }

    @Override
    public boolean removeTaskById(Integer id) {
        return projectMapper.deleteTaskById(id);
    }

    @Override
    public boolean removeList(Integer[] list) {
        for (Integer integer : list) {
            projectMapper.deleteTaskById(integer);
        }
        return true;
    }

    @Override
    public Map<String, String> getContentById(int id) {
        Task task = projectMapper.selectTaskDataById(id);
        Map<String, String> result = new HashMap<>(15);
        try {
            final JsonNode node = new ObjectMapper().readTree(task.getData());
            final Iterator<String> stringIterator = node.fieldNames();
            while (stringIterator.hasNext()) {
                String key = stringIterator.next();
                result.put(key, node.get(key).toString());
            }
            result.put("任务描述", task.getTaskDescription());
        } catch (JsonProcessingException e) {
            log.error("任务id为{},出现" + e.getMessage().substring(0, e.getMessage().indexOf("at")), id);
        }
        return result;
    }

    /**
     * 将指定的任务以及分类名和用户名打包
     *
     * @param tasks 任务列表
     * @return 打包列表
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
