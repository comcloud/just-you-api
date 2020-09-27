package com.cloud.api.util.observer;

import com.cloud.api.bean.dto.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();


    /**
     * 先把监听者初始化一下，存放一些监控操作以及对应得空集合，以后执行对应得操作得时候再存储内容到集合中
     * @param operations 监控得操作
     */
    public EventManager(String... operations){
        for (String operation : operations) {
            listeners.put(operation,new ArrayList<>());
        }
    }

    public void registerEvent(EventType eventType, EventListener listener){
        listeners.get(eventType.getValue()).add(listener);
    }

    public void removeEvent(String eventType,EventListener listener){
        listeners.get(eventType).remove(listener);
    }

    public void notify(EventType eventType,String content){
        List<EventListener> eventListeners = listeners.get(eventType.getValue());
        eventListeners.forEach(eventListener -> eventListener.update(eventType,content));

    }
}
