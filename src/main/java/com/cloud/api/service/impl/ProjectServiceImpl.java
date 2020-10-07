package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.mapper.ProjectMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ModelUtil<Task, ModelUtil<String,String>>> getAllTaskData() {
        List<Task> tasks = projectMapper.selectAllTask();
        List<ModelUtil<Task,ModelUtil<String,String>>> modelUtilList = new ArrayList<>();
        tasks.forEach(task -> {
            ModelUtil<Task, ModelUtil<String,String>> first = new ModelUtil<>();
            ModelUtil<String, String> last = new ModelUtil<>();
            last.setFirstValue(projectMapper.selectSortNameByClassId(task.getClassId()))
                .setLastValue(projectMapper.selectUsernameByUserId(task.getUserId()));
            first.setFirstValue(task).setLastValue(last);
            modelUtilList.add(first);
        });
        return modelUtilList;
    }
}
