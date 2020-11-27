package com.cloud.api.util.observer;

import cn.hutool.extra.mail.MailUtil;
import com.cloud.api.bean.dto.EventType;
import com.cloud.api.bean.dto.MessageDto;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.vo.MessageVo;
import com.cloud.api.mapper.MessageMapper;
import com.cloud.api.util.ResultGenerator;
import com.cloud.api.util.SpringUtil;
import com.cloud.api.util.websocket.MessageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author HP
 */
public class InformationListener implements EventListener {

    /**
     * 操作者open id
     */
    private String operationUserId;

    /**
     * 被操作者Open id
     */
    private String beOperatedUserId;


    private MessageMapper messageMapper = (MessageMapper) SpringUtil.getBean("messageMapper");


    public InformationListener(String operationUserId, String beOperatedUserId) {
        this.operationUserId = operationUserId;
        this.beOperatedUserId = beOperatedUserId;
    }

    /**
     * 此处就采取保存
     *
     * @param eventType 事件类型，这里只有点赞或者评论
     * @param content   事件内容
     */
    @Override
    @SuppressWarnings("all")
    public <T> void update(EventType eventType, T content) {
        final MessageDto messageDto = new MessageDto();
        final MessageVo messageVo = (MessageVo) content;
        messageDto.setEventTime(LocalDateTime.parse(LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        messageDto.setOpenid(operationUserId);
        //需要操作三个位置数据task,动态，user
        User user = messageMapper.selectUserFromOpenid(operationUserId);
        messageDto.setBase64(user.getUserHeadPortrait());
        messageDto.setNickName(user.getUserName());
        messageDto.setEventType(messageVo.getType());
        Object obj = messageVo.getType() == 1 ? messageMapper.selectTaskFromId(messageVo.getId()) : messageMapper.selectDynamicFromId(messageVo.getId());

        switch (eventType) {
            case SUPPORT:
                //只有动态可以点赞
                messageDto.setDynamic((Dynamic) obj);
                break;
            case COMMENT:
                if (messageVo.getType() == 1) {
                    messageDto.setTask((Task) obj);
                } else if (messageVo.getType() == 2) {
                    messageDto.setDynamic(((Dynamic) obj));
                }
                break;
            case EMAIL_NOTIFICATION:
                String info = "你的任务有人报名参与，快去看看吧";
                MailUtil.send(user.getEmail(), "任务参与通知", info, false);
                break;
            case FOLLOW:
                //关注
                break;
            default:
                break;
        }
        try {
            final ObjectMapper mapper = new ObjectMapper();
            MessageUtil.sendMessage(mapper.writeValueAsString(ResultGenerator.genSuccessResultInsertData(mapper.writeValueAsString(messageDto))),this.beOperatedUserId,this.operationUserId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
