package com.cloud.api.bean.entity;

import java.util.Date;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:35
 */
public class UserBrowsingHistory {
    /*
    历史记录ID
     */
    private Long browsingHistoryId;
    /*
    分类 0 动态 1 任务
     */
    private Integer browsingHistoryClass;
    /*
    浏览时间
     */
    private Date browsingHistoryTime;
    /*
    浏览用户openID
     */
    private String browsingHistoryOpenId;
    /*
    浏览 用户 ID
     */
    private String browsingHistoryUserId;
    /*
    浏览 任务ID
     */
    private Long browsingHistoryTaskId;

    public UserBrowsingHistory() {
    }

    public UserBrowsingHistory(Long browsingHistoryId, Integer browsingHistoryClass, Date browsingHistoryTime, String browsingHistoryOpenId, String browsingHistoryUserId, Long browsingHistoryTaskId) {
        this.browsingHistoryId = browsingHistoryId;
        this.browsingHistoryClass = browsingHistoryClass;
        this.browsingHistoryTime = browsingHistoryTime;
        this.browsingHistoryOpenId = browsingHistoryOpenId;
        this.browsingHistoryUserId = browsingHistoryUserId;
        this.browsingHistoryTaskId = browsingHistoryTaskId;
    }

    public Long getBrowsingHistoryId() {
        return browsingHistoryId;
    }

    public void setBrowsingHistoryId(Long browsingHistoryId) {
        this.browsingHistoryId = browsingHistoryId;
    }

    public Integer getBrowsingHistoryClass() {
        return browsingHistoryClass;
    }

    public void setBrowsingHistoryClass(Integer browsingHistoryClass) {
        this.browsingHistoryClass = browsingHistoryClass;
    }

    public Date getBrowsingHistoryTime() {
        return browsingHistoryTime;
    }

    public void setBrowsingHistoryTime(Date browsingHistoryTime) {
        this.browsingHistoryTime = browsingHistoryTime;
    }

    public String getBrowsingHistoryOpenId() {
        return browsingHistoryOpenId;
    }

    public void setBrowsingHistoryOpenId(String browsingHistoryOpenId) {
        this.browsingHistoryOpenId = browsingHistoryOpenId;
    }

    public String getBrowsingHistoryUserId() {
        return browsingHistoryUserId;
    }

    public void setBrowsingHistoryUserId(String browsingHistoryUserId) {
        this.browsingHistoryUserId = browsingHistoryUserId;
    }

    public Long getBrowsingHistoryTaskId() {
        return browsingHistoryTaskId;
    }

    public void setBrowsingHistoryTaskId(Long browsingHistoryTaskId) {
        this.browsingHistoryTaskId = browsingHistoryTaskId;
    }

    @Override
    public String toString() {
        return "UserBrowsingHistory{" +
                "browsingHistoryId=" + browsingHistoryId +
                ", browsingHistoryClass=" + browsingHistoryClass +
                ", browsingHistoryTime=" + browsingHistoryTime +
                ", browsingHistoryOpenId='" + browsingHistoryOpenId + '\'' +
                ", browsingHistoryUserId='" + browsingHistoryUserId + '\'' +
                ", browsingHistoryTaskId=" + browsingHistoryTaskId +
                '}';
    }
}
