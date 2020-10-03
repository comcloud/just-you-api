package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (DynamicTag)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class DynamicTag implements Serializable {
    private static final long serialVersionUID = 814309644690482613L;
    /**
     * 标签id
     */
    private Long dynamicTagId;
    /**
     * 标签名
     */
    private String dynamicTagName;


    public Long getDynamicTagId() {
        return dynamicTagId;
    }

    public void setDynamicTagId(Long dynamicTagId) {
        this.dynamicTagId = dynamicTagId;
    }

    public String getDynamicTagName() {
        return dynamicTagName;
    }

    public void setDynamicTagName(String dynamicTagName) {
        this.dynamicTagName = dynamicTagName;
    }

}