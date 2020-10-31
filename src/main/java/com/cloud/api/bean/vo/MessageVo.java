package com.cloud.api.bean.vo;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/27 19:40
 */
public class MessageVo {
    /**
     * 消息类型,存储着整个消息因为什么而触发的
     */
    private Integer messageType;

    /**
     * 触发者open id
     */
    private String sender;

    /**
     * 被触发者open id
     */
    private String recipient;

    /**
     * 触发的id，这个可以为null，如果为Null的话说明这个时候触发的是关注事件或者官方通知
     */
    private Integer id;

    /**
     * 类型，如果是1是任务，如果是2是动态
     */
    private Integer type;

    public MessageVo() {
    }

    public MessageVo(Integer messageType, String sender, String recipient, Integer id, Integer type) {
        this.messageType = messageType;
        this.sender = sender;
        this.recipient = recipient;
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "messageType=" + messageType +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", id=" + id +
                ", type=" + type +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public MessageVo setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public MessageVo setMessageType(Integer messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public MessageVo setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public MessageVo setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public MessageVo setId(Integer id) {
        this.id = id;
        return this;
    }

}
