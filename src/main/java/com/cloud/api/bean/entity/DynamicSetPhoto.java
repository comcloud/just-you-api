package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (DynamicSetPhoto)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:20
 */
public class DynamicSetPhoto implements Serializable {
    private static final long serialVersionUID = 932021348405877028L;

    private Long photoId;

    private Long dynamicId;


    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

}