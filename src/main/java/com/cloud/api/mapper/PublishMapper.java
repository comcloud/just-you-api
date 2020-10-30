package com.cloud.api.mapper;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskSetTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/30 11:08
 */
@Mapper
public interface PublishMapper {
    Long selectUserIdFromOpenId(@Param("openId") String openId);

    /**
     * 插入任务之后返回自身主键
     * @param task 插入任务
     * @return
     */
    long insertTask(@Param("task") Task task);

    void insertTaskSetTag(@Param("taskSetTag") TaskSetTag taskSetTag);
}
