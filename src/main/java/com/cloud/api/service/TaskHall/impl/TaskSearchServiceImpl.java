package com.cloud.api.service.TaskHall.impl;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.TaskSearchVo;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import com.cloud.api.mapper.TaskHall.TaskSearchMapper;
import com.cloud.api.service.TaskHall.TaskSearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-11:34
 */
@Service
public class TaskSearchServiceImpl implements TaskSearchService {
    @Autowired
    private TaskSearchMapper taskSearchMapper;
    @Autowired
    private TaskHallServiceImpl TaskHallServiceImpl;
    @Override
    public Set<String> getRecentlySearch(String open_id) {
        List<TaskSearchVo> taskSearchVos = taskSearchMapper.SelectRecentlySearch(open_id);
        HashMap<String, Date> stringDateHashMap = new HashMap<>();

        for (TaskSearchVo taskSearchVo : taskSearchVos) {
            if (stringDateHashMap.isEmpty()){
                stringDateHashMap.put(taskSearchVo.getSearchName(), taskSearchVo.getSearchTime());
            }
            if (stringDateHashMap.containsKey(taskSearchVo.getSearchName())) {
                if (taskSearchVo.getSearchTime().getTime() > stringDateHashMap.get(taskSearchVo.getSearchName()).getTime()) {
                    stringDateHashMap.put(taskSearchVo.getSearchName(), taskSearchVo.getSearchTime());
                }
            }else {
                stringDateHashMap.put(taskSearchVo.getSearchName(), taskSearchVo.getSearchTime());
            }
        }
        Set<String> strings = stringDateHashMap.keySet();
        return strings;
    }

    @Override
    public List<TaskHallVo> setLinkTaskSearchVos(String content) {
        List<TaskHallVo> taskSearchVos = taskSearchMapper.SelectLinkTaskSearchVos(content);
        return TaskHallServiceImpl.getTaskHallVos(taskSearchVos);
    }

    @Override
    public List<Tag> selectHotTag() {
        return taskSearchMapper.selectHotTag();
    }

    @Override
    public List<TaskSearchVo> getLinkTaskByTagId(Long tag_id) {
        List<TaskSearchVo> taskSearchVos = taskSearchMapper.SelectLinkTaskByTagId(tag_id);
        return taskSearchVos;
    }
    @Transactional
    @Override
    public boolean insertSearch(String content,String open_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchName",content);
        map.put("searchOpenId",open_id);
        return taskSearchMapper.insertSearch(map)>0;
    }
}
