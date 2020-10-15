package com.cloud.api.bean.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TaskOrder)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:22
 */
public class TaskOrder implements Serializable {
    private static final long serialVersionUID = 359311161103100026L;
    /**
     * 订单号
     */
    private String taskOrderId;
    /**
     * 任务id
     */
    private Long taskId;
    /**
     * 订单状态
     */
    private Integer taskOrderState;
    /**
     * 接任务用户id
     */
    private Long orderUserId;
    /**
     * 等待审核 0 ；审核通过 ：1 准备执行 2 执行 完毕3 审核未通过 4
     */
    private Integer orderState;

    private Date orderTime;


    public String getTaskOrderId() {
        return taskOrderId;
    }

    public void setTaskOrderId(String taskOrderId) {
        this.taskOrderId = taskOrderId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskOrderState() {
        return taskOrderState;
    }

    public void setTaskOrderState(Integer taskOrderState) {
        this.taskOrderState = taskOrderState;
    }

    public Long getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

}