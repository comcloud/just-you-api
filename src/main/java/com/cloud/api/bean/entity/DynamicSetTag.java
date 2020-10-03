package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (DynamicSetTag)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class DynamicSetTag implements Serializable {
    private static final long serialVersionUID = 563026275765247827L;
    /**
     * 动态id
     */
    private Long dynamicId;
    /**
     * 标签id
     */
    private Long tagId;


    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

}