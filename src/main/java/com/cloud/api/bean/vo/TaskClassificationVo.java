package com.cloud.api.bean.vo;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-9:12
 */
public class TaskClassificationVo {
    /**
     * 类别id
     */
    private Long id;
    /**
     * 描述
     */
    private String describe;
    /**
     * 配图
     */
    private String picture;
    /**
     * 名称
     */
    private String name;
    /*
    使用量
     */
    private  Integer classCount;

    public TaskClassificationVo() {
    }

    public Integer getClassCount() {
        return classCount;
    }

    public void setClassCount(Integer classCount) {
        this.classCount = classCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TaskClassificationVo{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
