package com.cloud.api.bean.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (ChatRecord)实体类
 *
 * @author makejava
 * @since 2020-10-25 17:22:54
 */
public class ChatRecord implements Serializable {
    private static final long serialVersionUID = 663875303149050726L;
    /**
     * 短信Id
     */
    private Long chatRecordId;
    /**
     * 内容
     */
    private String chatRecordContent;
    /**
     * 发送者ID
     */
    private String sendOpenId;
    /**
     * 接收者ID
     */
    private String receiveOpenId;
    /**
     * 发送时间
     */
    private Date sendTime;


    public Long getChatRecordId() {
        return chatRecordId;
    }

    public void setChatRecordId(Long chatRecordId) {
        this.chatRecordId = chatRecordId;
    }

    public String getChatRecordContent() {
        return chatRecordContent;
    }

    public void setChatRecordContent(String chatRecordContent) {
        this.chatRecordContent = chatRecordContent;
    }

    public String getSendOpenId() {
        return sendOpenId;
    }

    public void setSendOpenId(String sendOpenId) {
        this.sendOpenId = sendOpenId;
    }

    public String getReceiveOpenId() {
        return receiveOpenId;
    }

    public void setReceiveOpenId(String receiveOpenId) {
        this.receiveOpenId = receiveOpenId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

}