package com.cloud.api.bean.vo;

import com.cloud.api.bean.entity.DynamicTag;
import com.cloud.api.bean.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-13:47
 */
public class BlogVo {
    /*
    动态Id
     */
    private Long id;
    /*
    标题
     */
    private String dynamicTitle;
    /*
    摘要
     */
    private String abstracts;
    /*
    浏览量
     */
    private Long dynamicViews;
    /*
    点赞数量
     */
    private Long likeCount;
    /*
    发布时间
     */
    private Date dynamicTime;
    /*
        用户ID
     */
    private String openId;

    private List<photoVo> photo=new ArrayList<>();
    private  List<DynamicTag> dynamicTags= new ArrayList<>();

    private UserVo user;

    public BlogVo() {
    }

    public BlogVo(Long id, String dynamicTitle, String abstracts, Long dynamicViews, Long likeCount, Date dynamicTime, String openId, List<photoVo> photo, List<DynamicTag> dynamicTags, UserVo user) {
        this.id = id;
        this.dynamicTitle = dynamicTitle;
        this.abstracts = abstracts;
        this.dynamicViews = dynamicViews;
        this.likeCount = likeCount;
        this.dynamicTime = dynamicTime;
        this.openId = openId;
        this.photo = photo;
        this.dynamicTags = dynamicTags;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDynamicTitle() {
        return dynamicTitle;
    }

    public void setDynamicTitle(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Long getDynamicViews() {
        return dynamicViews;
    }

    public void setDynamicViews(Long dynamicViews) {
        this.dynamicViews = dynamicViews;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Date getDynamicTime() {
        return dynamicTime;
    }

    public void setDynamicTime(Date dynamicTime) {
        this.dynamicTime = dynamicTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BlogVo{" +
                "id=" + id +
                ", dynamicTitle='" + dynamicTitle + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", dynamicViews=" + dynamicViews +
                ", likeCount=" + likeCount +
                ", dynamicTime=" + dynamicTime +
                ", openId='" + openId + '\'' +
                ", photo=" + photo +
                ", dynamicTags=" + dynamicTags +
                ", user=" + user +
                '}';
    }
}
