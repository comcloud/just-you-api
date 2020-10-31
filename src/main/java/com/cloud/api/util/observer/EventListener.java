package com.cloud.api.util.observer;

import com.cloud.api.bean.dto.EventType;

/**
 * @author HP
 */
public interface EventListener {
    /**
     * @param eventType 事件类型，这里只有点赞或者评论
     * @param content 事件内容
     */
    <T> void update(EventType eventType, T content);
}
