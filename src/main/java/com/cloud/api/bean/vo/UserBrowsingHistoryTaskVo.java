package com.cloud.api.bean.vo;


/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-3:40
 */
public class UserBrowsingHistoryTaskVo {
    public Long id;
    public Long classId;
    private String task_description;
    public Long userId;
    public Integer state;
    public  UserVo user;
    public TaskClassificationVo taskClassificationVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public TaskClassificationVo getTaskClassificationVo() {
        return taskClassificationVo;
    }

    public void setTaskClassificationVo(TaskClassificationVo taskClassificationVo) {
        this.taskClassificationVo = taskClassificationVo;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserBrowsingHistoryTaskVo{" +
                "id=" + id +
                ", classId=" + classId +
                ", task_description='" + task_description + '\'' +
                ", userId=" + userId +
                ", state=" + state +
                ", user=" + user +
                ", taskClassificationVo=" + taskClassificationVo +
                '}';
    }
}
