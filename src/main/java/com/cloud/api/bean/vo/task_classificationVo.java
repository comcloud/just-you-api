package com.cloud.api.bean.vo;
/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-18:55
 */
public class task_classificationVo {
    private Long class_id;
    private String name;

    public task_classificationVo() {
    }

    public task_classificationVo(Long class_id, String name) {
        this.class_id = class_id;
        this.name = name;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "task_classificationVo{" +
                "class_id=" + class_id +
                ", name='" + name + '\'' +
                '}';
    }
}
