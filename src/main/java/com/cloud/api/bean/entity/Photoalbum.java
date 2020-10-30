package com.cloud.api.bean.entity;
import	java.util.HashMap;
import	java.util.ArrayList;

import com.cloud.api.bean.vo.photoVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Photoalbum)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class Photoalbum implements Serializable {
    private static final long serialVersionUID = 524797946615715013L;
    /**
     * 相册id
     */
    private Long photoalbumId;
    /**
     * 相册名
     */
    private String photoalbumName;
    /**
     * 访问权限 0： 全部
     * 1： 仅自己
     * 2： 粉丝
     * 3： 我关注的‘
     * 4： 粉丝以及我关注的
     * 等等
     */
    private Integer photoalbumPermissions;
    /**
     * 描述
     */
    private String photoalbumDescribe;
    /**
     * 创建时间
     */
    private Date photoalbumTime;
    /**
     * 0:存在 ：1：删除
     */
    private Integer photoalbumDelete;

    private String openId;
    /*
  首图
   */
    private String photoAlbumStemPan;



    private Map<String,List<photoVo>> photoVos=new HashMap<> ();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPhotoalbumId() {
        return photoalbumId;
    }

    public void setPhotoalbumId(Long photoalbumId) {
        this.photoalbumId = photoalbumId;
    }

    public String getPhotoalbumName() {
        return photoalbumName;
    }

    public void setPhotoalbumName(String photoalbumName) {
        this.photoalbumName = photoalbumName;
    }

    public Integer getPhotoalbumPermissions() {
        return photoalbumPermissions;
    }

    public void setPhotoalbumPermissions(Integer photoalbumPermissions) {
        this.photoalbumPermissions = photoalbumPermissions;
    }

    public String getPhotoalbumDescribe() {
        return photoalbumDescribe;
    }

    public void setPhotoalbumDescribe(String photoalbumDescribe) {
        this.photoalbumDescribe = photoalbumDescribe;
    }

    public Date getPhotoalbumTime() {
        return photoalbumTime;
    }

    public void setPhotoalbumTime(Date photoalbumTime) {
        this.photoalbumTime = photoalbumTime;
    }

    public Integer getPhotoalbumDelete() {
        return photoalbumDelete;
    }

    public void setPhotoalbumDelete(Integer photoalbumDelete) {
        this.photoalbumDelete = photoalbumDelete;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhotoAlbumStemPan() {
        return photoAlbumStemPan;
    }

    public void setPhotoAlbumStemPan(String photoAlbumStemPan) {
        this.photoAlbumStemPan = photoAlbumStemPan;
    }

    public Map<String, List<photoVo>> getPhotoVos() {
        return photoVos;
    }

    public void setPhotoVos(Map<String, List<photoVo>> photoVos) {
        this.photoVos = photoVos;
    }
}