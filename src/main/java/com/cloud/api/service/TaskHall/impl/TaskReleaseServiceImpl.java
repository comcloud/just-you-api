package com.cloud.api.service.TaskHall.impl;

import com.cloud.api.bean.vo.TaskClassificationVo;
import com.cloud.api.mapper.TaskHall.TaskReleaseMapper;
import com.cloud.api.service.TaskHall.TaskReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/29-19:15
 */
@Service
public class TaskReleaseServiceImpl implements TaskReleaseService {
    @Autowired
    private TaskReleaseMapper TaskReleaseMapper;
    @Override
    public List<TaskClassificationVo> getTaskClassificationAll() {
        return TaskReleaseMapper.selectTaskClassificationAll();
    }
}
