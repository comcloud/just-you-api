package com.cloud.api.bean.dto;

/**
 * @author HP
 */

public enum EventType {
    /**
     * 任务点赞
     */
    SUPPORT("support"),
    /**
     * 任务评论
     */
    COMMENT("comment"),
    /**
     * 官方通知
     */
    OFFICIAL_NOTIFICATION(" official notification"),

    /**
     * 关注
     */
    FOLLOW("follow"),
    /**
     * 消息通知
     */
    MESSAGE_NOTIFICATION("message notification"),

    /**
     * 如果发布的任务有人参与，则这时候会有邮箱通知
     */
    EMAIL_NOTIFICATION("email notification"),

    /**
     * 消息推送
     */
    INFORMATION_NOTIFICATION("information notification");


    private String value;

    public String getValue() {
        return value;
    }

    EventType(String value) {
        this.value = value;
    }
}
