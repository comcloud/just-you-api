package com.cloud.api.bean.dto;

import java.time.LocalDateTime;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/7 14:16
 */
public class SearchObject {
    /**
     * 开始时间
     * */
    private LocalDateTime start;

    /**
     * 结束时间
     */
    private LocalDateTime end;

    /**
     * 任务收费与否
     */
    private Integer charge;

    /**
     * 任务状态
     */
    private Integer projectState;

    /**
     * 任务id
     */
    private Integer projectId;

    public LocalDateTime getStart() {
        return start;
    }

    public SearchObject setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public SearchObject setEnd(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public Integer getCharge() {
        return charge;
    }

    public SearchObject setCharge(Integer charge) {
        this.charge = charge;
        return this;
    }

    public Integer getProjectState() {
        return projectState;
    }

    public SearchObject setProjectState(Integer projectState) {
        this.projectState = projectState;
        return this;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public SearchObject setProjectId(Integer projectId) {
        this.projectId = projectId;
        return this;
    }
}
