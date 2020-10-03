package com.cloud.api.bean.entity;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * (Dynamic)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:20
 */
public class Dynamic implements Serializable {
    private static final long serialVersionUID = -45492878416056204L;
    /**
     * 动态表主键id
     */
    private Long dynamicId;
    /**
     * 动态标题
     */
    private String dynamicTitle;
    /**
     * 动态内容
     */
    private Object dynamicContent;
    /**
     * 0-草稿 1-发布
     */
    private Object dynamicStatus;
    /**
     * 阅读量
     */
    private Long dynamicViews;
    /**
     * 0-允许评论 1-不允许评论
     */
    private Object dynamicComment;
    /**
     * 是否删除 0=否 1=是
     */
    private Object dynamicDeleted;
    /**
     * 发布时间
     */
    private Date dynamicTime;
    /**
     * 修改时间
     */
    private Date dynamicUpdateTime;

    private String dAbstract;

    private Long userId;



    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getDynamicTitle() {
        return dynamicTitle;
    }

    public void setDynamicTitle(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle;
    }

    public Object getDynamicContent() {
        return dynamicContent;
    }

    public void setDynamicContent(Object dynamicContent) {
        this.dynamicContent = dynamicContent;
    }

    public Object getDynamicStatus() {
        return dynamicStatus;
    }

    public void setDynamicStatus(Object dynamicStatus) {
        this.dynamicStatus = dynamicStatus;
    }

    public Long getDynamicViews() {
        return dynamicViews;
    }

    public void setDynamicViews(Long dynamicViews) {
        this.dynamicViews = dynamicViews;
    }

    public Object getDynamicComment() {
        return dynamicComment;
    }

    public void setDynamicComment(Object dynamicComment) {
        this.dynamicComment = dynamicComment;
    }

    public Object getDynamicDeleted() {
        return dynamicDeleted;
    }

    public void setDynamicDeleted(Object dynamicDeleted) {
        this.dynamicDeleted = dynamicDeleted;
    }

    public Date getDynamicTime() {
        return dynamicTime;
    }

    public void setDynamicTime(Date dynamicTime) {
        this.dynamicTime = dynamicTime;
    }

    public Date getDynamicUpdateTime() {
        return dynamicUpdateTime;
    }

    public void setDynamicUpdateTime(Date dynamicUpdateTime) {
        this.dynamicUpdateTime = dynamicUpdateTime;
    }

    public String getAbstract() {
        return dAbstract;
    }

    public void setAbstract(String dAbstract) {
        this.dAbstract =dAbstract;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}