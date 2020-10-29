package com.cloud.api.bean.vo;
import com.cloud.api.bean.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import	java.util.ArrayList;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-9:52
 */
public class TaskCommentsVo {
    /**
     * 评论id
     */
    private Long commId;
    /**
     * 评论者用户id
     */
    private String openId;
    /**
     * 评论内容
     */
    private String commContent;
    /**
     * 评论时间
     */
    private Object commTime;
    /**
     * 父评论id
     */
    private Long commFatherId;
    /*
    子评论集合
     */
    private List<TaskCommentsVo> sontaskComments= new ArrayList<> ();

  private UserVo user;

    public TaskCommentsVo() {
    }

    public TaskCommentsVo(Long commId, String openId, String commContent, Object commTime, Long commFatherId, List<TaskCommentsVo> sontaskComments, UserVo user) {
        this.commId = commId;
        this.openId = openId;
        this.commContent = commContent;
        this.commTime = commTime;
        this.commFatherId = commFatherId;
        this.sontaskComments = sontaskComments;
        this.user = user;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent;
    }

    public Object getCommTime() {
        return commTime;
    }

    public void setCommTime(Object commTime) {
        this.commTime = commTime;
    }

    public Long getCommFatherId() {
        return commFatherId;
    }

    public void setCommFatherId(Long commFatherId) {
        this.commFatherId = commFatherId;
    }

    public List<TaskCommentsVo> getSontaskComments() {
        return sontaskComments;
    }

    public void setSontaskComments(List<TaskCommentsVo> sontaskComments) {
        this.sontaskComments = sontaskComments;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TaskCommentsVo{" +
                "commId=" + commId +
                ", openId='" + openId + '\'' +
                ", commContent='" + commContent + '\'' +
                ", commTime=" + commTime +
                ", commFatherId=" + commFatherId +
                ", sontaskComments=" + sontaskComments +
                ", user=" + user +
                '}';
    }
}
