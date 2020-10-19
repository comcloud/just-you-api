package com.cloud.api.bean.dto;

import java.time.LocalDateTime;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/19 11:30
 */
public class OrderSearchObject {
    private Double firstMoney;
    private Double lastMoney;
    private Integer status;
    private LocalDateTime releaseTime;

    public Double getFirstMoney() {
        return firstMoney;
    }

    public OrderSearchObject setFirstMoney(Double firstMoney) {
        this.firstMoney = firstMoney;
        return this;
    }

    public Double getLastMoney() {
        return lastMoney;
    }

    public OrderSearchObject setLastMoney(Double lastMoney) {
        this.lastMoney = lastMoney;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public OrderSearchObject setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public OrderSearchObject setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }
}
