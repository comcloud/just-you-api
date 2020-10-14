package com.cloud.api.service;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.util.ModelUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:06
 */
public interface ProjectService {
    List<ModelUtil<Task,ModelUtil<String,String>>> getAllTaskData();

    List<ModelUtil<Task, ModelUtil<String, String>>> searchData(JsonNode search);

    List<TaskClassification> getAllTaskClassification();

    boolean saveNewProject(JsonNode node);

    boolean removeTaskById(Integer id);

    boolean removeList(Integer[] list);

    Map<String,String> getContentById(int id);
}
