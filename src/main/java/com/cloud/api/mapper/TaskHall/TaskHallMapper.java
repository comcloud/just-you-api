package com.cloud.api.mapper.TaskHall;

import com.cloud.api.bean.vo.taskHallVo;
import com.cloud.api.bean.vo.task_classificationVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-16:34
 */
@Mapper
public interface TaskHallMapper {
    /**
     * 对全部数据进行查询任务列表 开始任务前一个小时的
     * @return
     */
    List<taskHallVo> SelectTask_HallList();

    /**
     * 根据Class_Id 获取任务集合
     * @return
     */
    List<taskHallVo> SelectTaskListByClass(Long class_id);

    /**
     * 获取全部类名
     * @return
     */
    List<task_classificationVo> selectClassNameList();
}




















