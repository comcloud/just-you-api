package com.cloud.api.util.observer;

import cn.hutool.extra.mail.MailUtil;
import com.cloud.api.bean.dto.EventType;

/**
 * @author HP
 */
public class InformationListener implements EventListener {

    private String operationUserId;
    private String beOperatedUserId;


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
    public <T> void update(EventType eventType, T content) {

        if (EventType.SUPPORT.getValue().equals(eventType.getValue())) {
            //点赞操作
            System.out.println("点赞");
            System.out.println("用户" + operationUserId + ",对用户" + beOperatedUserId + "发生了" + eventType + "事件,内容是" + content);
        } else if (EventType.COMMENT.getValue().equals(eventType.getValue())) {
            //评论操作
            System.out.println("评论");
            System.out.println("用户" + operationUserId + ",对用户" + beOperatedUserId + "发生了" + eventType + "事件,内容是" + content);

        }else if(EventType.OFFICIAL_NOTIFICATION.getValue().equals(eventType.getValue())){
            //官方通知
            System.out.println("官方通知");
            System.out.println("用户" + operationUserId + ",对用户" + beOperatedUserId + "发生了" + eventType + "事件,内容是" + content);
        }else if(EventType.EMAIL_NOTIFICATION.getValue().equals(eventType.getValue())){
            MailUtil.send("2230817302@qq.com","test","邮件测试",false);
        }

    }
}
