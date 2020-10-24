package com.cloud.api.bean.entity;
import	java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    /**
     * 子类别
     */
    private List<TaskClassification> son=new ArrayList<> ();
    /**
     * 父类Id
     */
    private Long f_class_id;
    /**
     * 分类状态，0 启用 1 通用 默认启用
     */
    private Integer class_state;
    /**
     * 排序 1,2,3....
     */
    private Integer  classSort;

    private Date Creation_time;
    private Long class_count;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public List<TaskClassification> getSon() {
        return son;
    }

    public void setSon(List<TaskClassification> son) {
        this.son = son;
    }

    public Long getF_class_id() {
        return f_class_id;
    }

    public void setF_class_id(Long f_class_id) {
        this.f_class_id = f_class_id;
    }

    public Integer getClass_state() {
        return class_state;
    }

    public void setClass_state(Integer class_state) {
        this.class_state = class_state;
    }

    public Integer getClassSort() {
        return classSort;
    }

    public void setClassSort(Integer classSort) {
        this.classSort = classSort;
    }

    public Date getCreation_time() {
        return Creation_time;
    }

    public void setCreation_time(Date creation_time) {
        Creation_time = creation_time;
    }

    public Long getClass_count() {
        return class_count;
    }

    public void setClass_count(Long class_count) {
        this.class_count = class_count;
    }

    public TaskClassification(Long id, String describe, String picture, String name, List<TaskClassification> son, Long f_class_id, Integer class_state, Integer classSort, Date creation_time, Long class_count) {
        this.id = id;
        this.describe = describe;
        this.picture = picture;
        this.name = name;
        this.son = son;
        this.f_class_id = f_class_id;
        this.class_state = class_state;
        this.classSort = classSort;
        Creation_time = creation_time;
        this.class_count = class_count;
    }

    public TaskClassification() {
    }

    @Override
    public String toString() {
        return "TaskClassification{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", son=" + son +
                ", f_class_id=" + f_class_id +
                ", class_state=" + class_state +
                ", classSort=" + classSort +
                ", Creation_time=" + Creation_time +
                ", class_count=" + class_count +
                '}';
    }
}
