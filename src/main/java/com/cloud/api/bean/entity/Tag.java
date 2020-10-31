package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:21
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = -57813272363611135L;
    /**
     * 标id
     */
    private Integer tagId;
    /**
     * 标签名
     */
    private String tagName;
    /**
     * 比起欧倩使用量
     */
    private Long tagCount;

    public Tag() {
    }

    public Tag(Integer tagId, String tagName, Long tagCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagCount = tagCount;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getTagCount() {
        return tagCount;
    }

    public void setTagCount(Long tagCount) {
        this.tagCount = tagCount;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", tagCount=" + tagCount +
                '}';
    }
}