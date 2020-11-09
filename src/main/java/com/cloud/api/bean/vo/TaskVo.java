package com.cloud.api.bean.vo;

import com.cloud.api.bean.entity.Tag;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
public class TaskVo implements Serializable {
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
    private UserVo user;
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

    /**
     * 任务标题
     */
    private String taskTitle;
    /**
     * 任务浏览量
     */
    private int traffic;

    private List<Tag> tags;

    private TaskClassificationVo taskClassificationVo;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public TaskClassificationVo getTaskClassificationVo() {
        return taskClassificationVo;
    }

    public void setTaskClassificationVo(TaskClassificationVo taskClassificationVo) {
        this.taskClassificationVo = taskClassificationVo;
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

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "TaskVo{" +
                "data='" + data + '\'' +
                ", state=" + state +
                ", charge=" + charge +
                ", releaseTime=" + releaseTime +
                ", user=" + user +
                ", needNumber=" + needNumber +
                ", recruitingNumber=" + recruitingNumber +
                ", taskComment=" + taskComment +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", taskDescription='" + taskDescription + '\'' +
                ", money=" + money +
                ", taskTitle='" + taskTitle + '\'' +
                ", traffic=" + traffic +
                ", tags=" + tags +
                ", taskClassificationVo=" + taskClassificationVo +
                '}';
    }
}
