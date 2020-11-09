package com.cloud.api.service.TaskHall.impl;
import com.alibaba.fastjson.JSON;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.TaskVo;
import com.cloud.api.bean.vo.task_classificationVo;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import com.cloud.api.service.TaskHall.TaskHallService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.JobSheets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-13:26
 */
@Service
public class TaskHallServiceImpl implements TaskHallService {
    @Autowired
    private TaskHallMapper TaskHallMapper;
    @Override
    public List<TaskHallVo> getTask_HallList() {
        List<TaskHallVo> taskHallVos = TaskHallMapper.SelectTask_HallList();
        return getTaskHallVos(taskHallVos);
    }

    public   List<TaskHallVo> getTaskHallVos(List<TaskHallVo> taskHallVos) {
        for (TaskHallVo taskHallVo : taskHallVos) {
            String s = TaskHallMapper.selectData(taskHallVo.getId());
            if (s != null) {
                JsonNode jsonNode = null;
                try {
                    jsonNode = new ObjectMapper().readTree(s).findPath("url");
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                assert jsonNode != null;
                String s1 = jsonNode.get("url_0").toString();
                taskHallVo.setTaskFirstFigure(s1.substring(1, s1.length() - 1));
            }
        }
        return  taskHallVos;
    }

    @Override
    public List<TaskHallVo> getTaskListByClass(Long class_id) {
        List<TaskHallVo> list = TaskHallMapper.SelectTaskListByClass(class_id);
        return getTaskHallVos(list);
    }

    @Override
    public void classTaskList() {
    }

    @Override
    public List<task_classificationVo> getAllClassName() {
        List<task_classificationVo> task_classificationVos = TaskHallMapper.selectClassNameList();
        //按照class_id 排序
        Collections.sort(task_classificationVos,(o1,o2)-> (int) (o1.getClass_id()-o2.getClass_id()));
        return task_classificationVos;
    }
@Transactional
    @Override
    public TaskVo getTaskDetails(Long TaskId) {
        TaskHallMapper.viewsAdd1(TaskId);
        return TaskHallMapper.selectTaskDetails(TaskId);
    }
}
