package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (Photo)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class Photo implements Serializable {
    private static final long serialVersionUID = -52177409046315107L;
    /**
     * 照片id
     */
    private Long photoId;
    /**
     * 相片路径
     */
    private String photoUrl;
    /**
     * 0:存在 1：回收战2：删除
     */
    private Integer photoDelete;
    /**
     * 所属相册id
     */
    private Long photoaalbumId;


    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getPhotoDelete() {
        return photoDelete;
    }

    public void setPhotoDelete(Integer photoDelete) {
        this.photoDelete = photoDelete;
    }

    public Long getPhotoaalbumId() {
        return photoaalbumId;
    }

    public void setPhotoaalbumId(Long photoaalbumId) {
        this.photoaalbumId = photoaalbumId;
    }


}