package com.cloud.api.observer;

import com.cloud.api.bean.dto.EventType;

public interface EventListener {
    /**
     * @param eventType 事件类型，这里只有点赞或者评论
     * @param content 事件内容
     */
    void update(EventType eventType, String content);
}
