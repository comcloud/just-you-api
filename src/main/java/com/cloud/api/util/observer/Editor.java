package com.cloud.api.util.observer;

import com.cloud.api.bean.dto.EventType;

/**
 * @author HP
 */
public class Editor {
    public EventManager manager;

    public Editor(){
        this.manager = new EventManager(
                EventType.SUPPORT.getValue(),
                EventType.COMMENT.getValue(),
                EventType.OFFICIAL_NOTIFICATION.getValue(),
                EventType.MESSAGE_NOTIFICATION.getValue()
        );
    }

    public <T> void trigger(EventType eventType,T content){
        manager.notify(eventType,content);
    }

}
