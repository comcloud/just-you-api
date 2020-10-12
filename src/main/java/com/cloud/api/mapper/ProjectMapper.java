package com.cloud.api.mapper;

import com.cloud.api.bean.dto.SearchObject;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:35
 */
@Mapper
public interface ProjectMapper {

    List<Task> selectAllTask();

    String selectUsernameByUserId(@Param("userId") Long userId);

    String selectSortNameByClassId(@Param("classId") Long classId);

    List<Task> selectTaskBySearch(@Param("searchObject") SearchObject searchObject);

    List<TaskClassification> selectAllTaskClassification();

    boolean insertOneTask(@Param("task") Task task);

    boolean deleteTaskById(@Param("id") Integer id);
}
