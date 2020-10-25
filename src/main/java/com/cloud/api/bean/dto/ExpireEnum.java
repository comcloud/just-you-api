package com.cloud.api.bean.dto;

import java.util.concurrent.TimeUnit;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/25 10:04
 */
public enum ExpireEnum {
    //未读消息的有效期为30天
    UNREAD_MSG(30L, TimeUnit.DAYS)
    ;

    /**
     * 过期时间
     */
    private Long time;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    ExpireEnum(Long time, TimeUnit timeUnit) {
        this.time = time;
        this.timeUnit = timeUnit;
    }

    public Long getTime() {
        return time;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
