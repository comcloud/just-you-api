package com.cloud.api.bean.entity;

import java.io.Serializable;

/**
 * (TaskClassification)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:22
 */
public class TaskClassification implements Serializable {
    private static final long serialVersionUID = -74290559353125516L;
    /**
     * 类别id
     */
    private Long class_id;
    /**
     * 描述
     */
    private String describe;

    @Override
    public String toString() {
        return "TaskClassification{" +
                "id=" + class_id +
                ", describe='" + describe + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 配图
     */
    private String picture;
    /**
     * 名称
     */
    private String name;


    public Long getId() {
        return class_id;
    }

    public void setId(Long id) {
        this.class_id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}