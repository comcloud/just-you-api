package com.cloud.api.bean.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime releaseTime;
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
     * 任务开始时间
     */
    private LocalDateTime startTime;

    /**
     * 任务结束时间
     */
    private LocalDateTime endTime;

    /**
     * 任务描述
     * */
    private String taskDescription;

    /**
     * 任务赏金
     */
    private double money;

    public String getTaskDescription() {
        return taskDescription;
    }

    public double getMoney() {
        return money;
    }

    public Task setMoney(double money) {
        this.money = money;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Task setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Task setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public Task setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getClassId() {
        return classId;
    }

    public Task setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public String getData() {
        return data;
    }

    public Task setData(String data) {
        this.data = data;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Task setState(Integer state) {
        this.state = state;
        return this;
    }

    public Integer getCharge() {
        return charge;
    }

    public Task setCharge(Integer charge) {
        this.charge = charge;
        return this;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public Task setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Task setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getNeedNumber() {
        return needNumber;
    }

    public Task setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
        return this;
    }

    public Integer getRecruitingNumber() {
        return recruitingNumber;
    }

    public Task setRecruitingNumber(Integer recruitingNumber) {
        this.recruitingNumber = recruitingNumber;
        return this;
    }

    public Integer getTaskComment() {
        return taskComment;
    }

    public Task setTaskComment(Integer taskComment) {
        this.taskComment = taskComment;
        return this;
    }
}