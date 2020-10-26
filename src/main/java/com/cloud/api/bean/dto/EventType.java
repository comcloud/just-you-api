package com.cloud.api.bean.dto;

/**
 * @author HP
 */

public enum EventType {
    /**
     * 点赞
     */
    SUPPORT("support"),
    /**
     * 评论
     */
    COMMENT("comment"),
    /**
     * 官方通知
     */
    OFFICIAL_NOTIFICATION(" official notification"),

    /**
     * 消息通知
     */
    MESSAGE_NOTIFICATION("message notification"),

    /**
     * 邮箱通知
     */
    EMAIL_NOTIFICATION("email notification");


    private String value;

    public String getValue() {
        return value;
    }

    EventType(String value) {
        this.value = value;
    }
}
