package com.cloud.api.bean.entity;

import com.cloud.api.bean.vo.UserVo;
import com.cloud.api.bean.vo.photoVo;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
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
    private String dynamicContent;
    /**
     * 0-草稿 1-发布
     */
    private int dynamicStatus;
    /**
     * 阅读量
     */
    private Long dynamicViews;
    /**
     * 0-允许评论 1-不允许评论
     */
    private int dynamicComment;
    /**
     * 是否删除 0=否 1=是
     */
    private int dynamicDeleted;
    /**
     * 发布时间
     */
    private LocalDateTime dynamicTime;
    /**
     * 修改时间
     */
    private Date dynamicUpdateTime;

    private String dAbstract;

    private Long likeCount;
    

    private UserVo user;

    private List<photoVo> photo=new ArrayList<>();

    private  List<DynamicTag> dynamicTags= new ArrayList<>();

    private boolean isAttention;

    private boolean ifLike;



    public boolean isAttention() {
        return isAttention;
    }

    public void setAttention(boolean attention) {
        isAttention = attention;
    }

    public boolean isIfLike() {
        return ifLike;
    }

    public void setIfLike(boolean ifLike) {
        this.ifLike = ifLike;
    }

    public Dynamic() {
    }

    public Dynamic(Long dynamicId, String dynamicTitle, String dynamicContent, int dynamicStatus, Long dynamicViews, int dynamicComment, int dynamicDeleted, LocalDateTime dynamicTime, Date dynamicUpdateTime, String dAbstract, Long likeCount, UserVo user, List<photoVo> photo, List<DynamicTag> dynamicTags, boolean isAttention, boolean ifLike) {
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
        this.user = user;
        this.photo = photo;
        this.dynamicTags = dynamicTags;
        this.isAttention = isAttention;
        this.ifLike = ifLike;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public Dynamic setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
        return this;
    }

    public String getDynamicTitle() {
        return dynamicTitle;
    }

    public Dynamic setDynamicTitle(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle;
        return this;
    }

    public Object getDynamicContent() {
        return dynamicContent;
    }

    public Dynamic setDynamicContent(String dynamicContent) {
        this.dynamicContent = dynamicContent;
        return this;
    }

    public int getDynamicStatus() {
        return dynamicStatus;
    }

    public Dynamic setDynamicStatus(int dynamicStatus) {
        this.dynamicStatus = dynamicStatus;
        return this;
    }

    public Long getDynamicViews() {
        return dynamicViews;
    }

    public Dynamic setDynamicViews(Long dynamicViews) {
        this.dynamicViews = dynamicViews;
        return this;
    }

    public Object getDynamicComment() {
        return dynamicComment;
    }

    public Dynamic setDynamicComment(int dynamicComment) {
        this.dynamicComment = dynamicComment;
        return this;
    }

    public int getDynamicDeleted() {
        return dynamicDeleted;
    }

    public Dynamic setDynamicDeleted(int dynamicDeleted) {
        this.dynamicDeleted = dynamicDeleted;
        return this;
    }

    public LocalDateTime getDynamicTime() {
        return dynamicTime;
    }

    public Dynamic setDynamicTime(LocalDateTime dynamicTime) {
        this.dynamicTime = dynamicTime;
        return this;
    }

    public Date getDynamicUpdateTime() {
        return dynamicUpdateTime;
    }

    public Dynamic setDynamicUpdateTime(Date dynamicUpdateTime) {
        this.dynamicUpdateTime = dynamicUpdateTime;
        return this;
    }

    public String getdAbstract() {
        return dAbstract;
    }

    public Dynamic setdAbstract(String dAbstract) {
        this.dAbstract = dAbstract;
        return this;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public Dynamic setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    public UserVo getUser() {
        return user;
    }

    public Dynamic setUser(UserVo user) {
        this.user = user;
        return this;
    }

    public List<photoVo> getPhoto() {
        return photo;
    }

    public Dynamic setPhoto(List<photoVo> photo) {
        this.photo = photo;
        return this;
    }

    public List<DynamicTag> getDynamicTags() {
        return dynamicTags;
    }

    public Dynamic setDynamicTags(List<DynamicTag> dynamicTags) {
        this.dynamicTags = dynamicTags;
        return this;
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
                ", user=" + user +
                ", photo=" + photo +
                ", dynamicTags=" + dynamicTags +
                ", isAttention=" + isAttention +
                ", ifLike=" + ifLike +
                '}';
    }
}