package com.cloud.api.bean.vo;
import	java.util.ArrayList;
import com.cloud.api.bean.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 云顶犀
 * <p>项目名称: 任务大厅查询显示实体类
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-16:04
 */
public class TaskHallVo {
    public Long id;
    //任务分类 一对一
    public TaskClassificationVo taskClassification;
    //标题
    //招募人数
    public Long recruiting_number;

    private String task_description;

    public String task_title ;
    //发布日期
    public Date release_time;
    //浏览量
    public Integer traffic;
    //用户
    public UserVo user;

    private List<Tag> tags=new ArrayList<> ();


    public TaskHallVo() {
    }

    public TaskHallVo(Long id, TaskClassificationVo taskClassification, Long recruiting_number, String task_description, String task_title, Date release_time, Integer traffic, UserVo user, List<Tag> tags) {
        this.id = id;
        this.taskClassification = taskClassification;
        this.recruiting_number = recruiting_number;
        this.task_description = task_description;
        this.task_title = task_title;
        this.release_time = release_time;
        this.traffic = traffic;
        this.user = user;
        this.tags = tags;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskClassificationVo getTaskClassification() {
        return taskClassification;
    }

    public void setTaskClassification(TaskClassificationVo taskClassification) {
        this.taskClassification = taskClassification;
    }

    public Long getRecruiting_number() {
        return recruiting_number;
    }

    public void setRecruiting_number(Long recruiting_number) {
        this.recruiting_number = recruiting_number;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "taskHallVo{" +
                "id=" + id +
                ", taskClassification=" + taskClassification +
                ", recruiting_number=" + recruiting_number +
                ", task_description='" + task_description + '\'' +
                ", task_title='" + task_title + '\'' +
                ", release_time=" + release_time +
                ", traffic=" + traffic +
                ", user=" + user +
                ", tags=" + tags +
                '}';
    }
}
