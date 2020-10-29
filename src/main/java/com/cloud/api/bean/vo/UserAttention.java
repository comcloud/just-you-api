package com.cloud.api.bean.vo;


import java.util.Date;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/27-14:17
 */
public class UserAttention {
    private Long id;
    private UserVo user;
    private Date attentionTime;

    public UserAttention() {
    }

    public UserAttention(Long id, UserVo user, Date attentionTime) {
        this.id = id;
        this.user = user;
        this.attentionTime = attentionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public Date getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }

    @Override
    public String toString() {
        return "UserAttention{" +
                "id=" + id +
                ", user=" + user +
                ", attentionTime=" + attentionTime +
                '}';
    }
}
