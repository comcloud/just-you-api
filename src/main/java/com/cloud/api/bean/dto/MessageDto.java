package com.cloud.api.bean.dto;

import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.entity.Task;

import java.time.LocalDateTime;

/**
 * 消息返回推送类
 * 这个类中除了存储着应该有的头像以及昵称、触发事件事件、触发事件的人的open id
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/28 7:44
 */
public class MessageDto {

    /**
     * 头像base64
     */
    private String base64;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 触发时间事件
     */
    private LocalDateTime eventTime;

    /**
     * open id
     */
    private String openid;

    /**
     * 任务数据
     */
    private Task task;

    /**
     * 动态数据
     */
    private Dynamic dynamic;


    /**
     * 0.关注、任务参加
     * 1.任务
     * 2.动态
     * 3.消息
     */
    private Integer eventType;

    public MessageDto(String base64, String nickName, LocalDateTime eventTime, String openid, Task task, Dynamic dynamic, Integer eventType) {
        this.base64 = base64;
        this.nickName = nickName;
        this.eventTime = eventTime;
        this.openid = openid;
        this.task = task;
        this.dynamic = dynamic;
        this.eventType = eventType;
    }

    public MessageDto() {
    }


    @Override
    public String toString() {
        return "MessageDto{" +
                "base64='" + base64 + '\'' +
                ", nickName='" + nickName + '\'' +
                ", eventTime=" + eventTime +
                ", openid='" + openid + '\'' +
                ", task=" + task +
                ", dynamic=" + dynamic +
                ", eventType=" + eventType +
                '}';
    }

    public String getBase64() {
        return base64;
    }

    public MessageDto setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public MessageDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public MessageDto setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public MessageDto setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public MessageDto setTask(Task task) {
        this.task = task;
        return this;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public MessageDto setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
        return this;
    }

    public Integer getEventType() {
        return eventType;
    }

    public MessageDto setEventType(Integer eventType) {
        this.eventType = eventType;
        return this;
    }
}
