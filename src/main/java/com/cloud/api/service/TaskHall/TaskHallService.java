package com.cloud.api.service.TaskHall;

import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.TaskVo;
import com.cloud.api.bean.vo.task_classificationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-13:24
 */
public interface TaskHallService {
    List<TaskHallVo> getTask_HallList();

    List<TaskHallVo> getTaskListByClass(Long class_id);

    @Deprecated
    void classTaskList();

    List<task_classificationVo> getAllClassName();
    TaskVo getTaskDetails(Long TaskId);
}