package com.cloud.api.service.impl;

import com.cloud.api.bean.dto.EventType;
import com.cloud.api.bean.dto.MessageDto;
import com.cloud.api.bean.vo.MessageVo;
import com.cloud.api.service.MessageService;
import com.cloud.api.util.observer.Editor;
import com.cloud.api.util.observer.InformationListener;
import org.springframework.stereotype.Service;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/27 19:15
 */
@Service
public class MessageServiceImpl implements MessageService {

    /**
     * 推送消息
     *
     * @param messageVo 消息对象
     * @return 推送成功与否
     */
    @Override
    public void pushMessage(MessageVo messageVo) {
        Editor editor = new Editor();
        final Integer messageType = messageVo.getMessageType();
        switch (messageType) {
            case 1:
                //此时是点赞
                editor.manager.registerEvent(EventType.SUPPORT, new InformationListener(messageVo.getSender(), messageVo.getRecipient()));
                editor.trigger(EventType.SUPPORT, messageVo);
                break;
            case 2:
                //评论
                editor.manager.registerEvent(EventType.COMMENT, new InformationListener(messageVo.getSender(), messageVo.getRecipient()));
                editor.trigger(EventType.SUPPORT, messageVo);
                break;
            case 3:
                //任务参加通知
                editor.manager.registerEvent(EventType.EMAIL_NOTIFICATION, new InformationListener(messageVo.getSender(), messageVo.getRecipient()));
                editor.trigger(EventType.SUPPORT, messageVo);
                break;
            case 4:
                //关注事件，关注的话只需要将对应的关注者传递就可以
                editor.manager.registerEvent(EventType.FOLLOW, new InformationListener(messageVo.getSender(), messageVo.getRecipient()));
                editor.trigger(EventType.SUPPORT, messageVo);
                break;
            case 5:
                //官方通知,此处功能暂时不写
                editor.manager.registerEvent(EventType.OFFICIAL_NOTIFICATION, new InformationListener(messageVo.getSender(), messageVo.getRecipient()));
                editor.trigger(EventType.SUPPORT, messageVo);
                break;
            default:
                break;
        }
    }
}
