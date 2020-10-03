package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (TaskSetTag)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:22
 */
public class TaskSetTag implements Serializable {
    private static final long serialVersionUID = 134665391863822589L;

    private Long taskId;

    private Long tagId;


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

}