package com.cloud.api.bean.dto;

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
    OFFICIAL_NOTIFICATION(" official notification");

    private String value;

    public String getValue() {
        return value;
    }

    EventType(String value) {
        this.value = value;
    }
}
