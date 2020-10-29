package com.cloud.api;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/26 22:26
 */
public class EmailContent {
    private String sender;

    private String recipient;

    private String subject;

    private String content;


    public String getSender() {
        return sender;
    }

    public EmailContent setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public EmailContent setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailContent setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EmailContent setContent(String content) {
        this.content = content;
        return this;
    }
}
