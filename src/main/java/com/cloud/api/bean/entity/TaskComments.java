package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (TaskComments)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:22
 */
public class TaskComments implements Serializable {
    private static final long serialVersionUID = 563531721082294571L;
    /**
     * 评论id
     */
    private Long commId;
    /**
     * 评论者用户id
     */
    private Long userId;
    /**
     * 评论内容
     */
    private String commContent;
    /**
     * 评论时间
     */
    private Object commTime;
    /**
     * 任务id
     */
    private Long taskId;
    /**
     * 0：存在 1：删除
     */
    private Integer commDelete;
    /**
     * 父评论id
     */
    private Long commFatherId;


    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent;
    }

    public Object getCommTime() {
        return commTime;
    }

    public void setCommTime(Object commTime) {
        this.commTime = commTime;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getCommDelete() {
        return commDelete;
    }

    public void setCommDelete(Integer commDelete) {
        this.commDelete = commDelete;
    }

    public Long getCommFatherId() {
        return commFatherId;
    }

    public void setCommFatherId(Long commFatherId) {
        this.commFatherId = commFatherId;
    }

}