package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskSetTag;
import com.cloud.api.mapper.PublishMapper;
import com.cloud.api.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/30 8:45
 */
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private PublishMapper publishMapper;

    @Override
    public void saveReleaseInfo(String info) {
        JsonNode node = null;
        Task task = new Task();
        TaskSetTag taskSetTag = new TaskSetTag();
        try {
            node = new ObjectMapper().readTree(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert node != null;
        task.setUserId(publishMapper.selectUserIdFromOpenId(node.findPath("open_id").toString()))
                .setTaskDescription(node.findPath("task_description").toString())
                .setRecruitingNumber(Integer.parseInt(node.findParent("recruiting_number").toString()))
                .setNeedNumber(Integer.parseInt(node.findPath("need_number").toString()))
                .setData(node.findPath("data").toString())
                .setClassId(Long.parseLong(node.findPath("class_id").toString()))
                .setCharge(Integer.parseInt(node.findPath("charger").toString()))
                .setMoney(Double.parseDouble(node.findParent("money").toString()))
                .setReleaseTime(LocalDateTime.parse(LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                .setTaskTitle(node.findParent("task_title").toPrettyString())
                .setTraffic(0)
                .setStartTime(LocalDateTime.parse(node.findPath("start_time").toString()))
                .setEndTime(LocalDateTime.parse(node.findPath("end_time").toString()))
                .setState(1);
        long taskId = publishMapper.insertTask(task);
        taskSetTag.setTaskId(taskId);
        publishMapper.insertTaskSetTag(taskSetTag);
    }

    @Override
    public Map<Integer, String> getAllTag() {
        List<Tag> tagList = publishMapper.selectAllTag();
        Map<Integer,String> map = new HashMap<>();
        tagList.forEach(tag -> map.put(tag.getTagId(),tag.getTagName()));
        return map;
    }
}
