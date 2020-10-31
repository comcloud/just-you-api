package com.cloud.api.bean.vo;

import java.util.Date;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/30-16:34
 */
public class PhotoalbumVo {
    /**
     * 相册id
     */
    private Long photoalbumId;
    /**
     * 相册名
     */
    private String photoalbumName;
    /**
     * 描述
     */
    private String photoalbumDescribe;
    /**
     * 创建时间
     */
    private Date photoalbumTime;
    /*
    首图
     */
    private String photoAlbumStemPan;

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

    public String getPhotoAlbumStemPan() {
        return photoAlbumStemPan;
    }

    public void setPhotoAlbumStemPan(String photoAlbumStemPan) {
        this.photoAlbumStemPan = photoAlbumStemPan;
    }
}
