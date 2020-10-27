package com.cloud.api.bean.entity;

import com.cloud.api.bean.vo.UserVo;
import com.cloud.api.bean.vo.photoVo;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private Long likeCount;
    
    private String openId;

    private UserVo user;

    private List<photoVo> photo=new ArrayList<>();

    private  List<DynamicTag> dynamicTags= new ArrayList<>();

    public Dynamic() {
    }

    public Dynamic(Long dynamicId, String dynamicTitle, Object dynamicContent, Object dynamicStatus, Long dynamicViews, Object dynamicComment, Object dynamicDeleted, Date dynamicTime, Date dynamicUpdateTime, String dAbstract, Long likeCount, String openId, UserVo user, List<photoVo> photo, List<DynamicTag> dynamicTags) {
        this.dynamicId = dynamicId;
        this.dynamicTitle = dynamicTitle;
        this.dynamicContent = dynamicContent;
        this.dynamicStatus = dynamicStatus;
        this.dynamicViews = dynamicViews;
        this.dynamicComment = dynamicComment;
        this.dynamicDeleted = dynamicDeleted;
        this.dynamicTime = dynamicTime;
        this.dynamicUpdateTime = dynamicUpdateTime;
        this.dAbstract = dAbstract;
        this.likeCount = likeCount;
        this.openId = openId;
        this.user = user;
        this.photo = photo;
        this.dynamicTags = dynamicTags;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getdAbstract() {
        return dAbstract;
    }

    public void setdAbstract(String dAbstract) {
        this.dAbstract = dAbstract;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public String getopenId() {
        return openId;
    }

    public void setopenId(String openId) {
        this.openId = openId;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public List<photoVo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<photoVo> photo) {
        this.photo = photo;
    }

    public List<DynamicTag> getDynamicTags() {
        return dynamicTags;
    }

    public void setDynamicTags(List<DynamicTag> dynamicTags) {
        this.dynamicTags = dynamicTags;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dynamicId=" + dynamicId +
                ", dynamicTitle='" + dynamicTitle + '\'' +
                ", dynamicContent=" + dynamicContent +
                ", dynamicStatus=" + dynamicStatus +
                ", dynamicViews=" + dynamicViews +
                ", dynamicComment=" + dynamicComment +
                ", dynamicDeleted=" + dynamicDeleted +
                ", dynamicTime=" + dynamicTime +
                ", dynamicUpdateTime=" + dynamicUpdateTime +
                ", dAbstract='" + dAbstract + '\'' +
                ", likeCount=" + likeCount +
                ", openId='" + openId + '\'' +
                ", user=" + user +
                ", photo=" + photo +
                ", dynamicTags=" + dynamicTags +
                '}';
    }
}