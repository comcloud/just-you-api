package com.cloud.api.service.TaskHall;
import com.cloud.api.bean.vo.taskHallVo;
import com.cloud.api.bean.vo.task_classificationVo;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-13:24
 */
public interface TaskHallService {
    List<taskHallVo> getTask_HallList();
    List<taskHallVo> getTaskListByClass(Long class_id);
    void  classTaskList();
    List<task_classificationVo> getAllClassName();
}