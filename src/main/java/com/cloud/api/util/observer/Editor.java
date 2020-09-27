package com.cloud.api.util.observer;

import com.cloud.api.bean.dto.EventType;

public class Editor {
    private String content;
    public EventManager manager;

    public Editor(){
        this.manager = new EventManager(EventType.SUPPORT.getValue(),EventType.COMMENT.getValue(),EventType.OFFICIAL_NOTIFICATION.getValue());
    }

    public void trigger(EventType eventType,String content){
        this.content = content;
        manager.notify(eventType,content);
    }

}
