package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 883124815847773875L;
    /**
     * 任务id
     */
    private Long id;
    /**
     * 类别id
     */
    private Long classId;
    /**
     * 数据
     */
    private String data;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 0收费1不收费
     */
    private Integer charge;
    /**
     * 发布时间
     */
    private Object releaseTime;
    /**
     * 发布用户id
     */
    private Long userId;
    /**
     * 需要人数
     */
    private Integer needNumber;
    /**
     * 招募人数
     */
    private Integer recruitingNumber;
    /**
     * 0：开启评论 1：关闭评论
     */
    private Integer taskComment;

    /**
     * 任务描述
     * */
    private String taskDescription;

    public String getTaskDescription() {
        return taskDescription;
    }

    public Task setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Object getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Object releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }

    public Integer getRecruitingNumber() {
        return recruitingNumber;
    }

    public void setRecruitingNumber(Integer recruitingNumber) {
        this.recruitingNumber = recruitingNumber;
    }

    public Integer getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(Integer taskComment) {
        this.taskComment = taskComment;
    }

}