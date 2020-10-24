package com.cloud.api.bean.entity;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-15:51
 */
public class DynamicComments {
    /**
     * 评论id
     */
    private Long commId;
    /**
     * 评论者用户id
     */
    private Long userId;
    /**
     * 评论内容
     */
    private String commContent;
    /**
     * 评论时间
     */
    private Object commTime;
    /**
     * 任务id
     */
    private Long DynamicId;
    /**
     * 0：存在 1：删除
     */
    private Integer commDelete;
    /**
     * 父评论id
     */
    private Long commFatherId;

    public DynamicComments() {
    }

    public DynamicComments(Long commId, Long userId, String commContent, Object commTime, Long dynamicId, Integer commDelete, Long commFatherId) {
        this.commId = commId;
        this.userId = userId;
        this.commContent = commContent;
        this.commTime = commTime;
        DynamicId = dynamicId;
        this.commDelete = commDelete;
        this.commFatherId = commFatherId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getDynamicId() {
        return DynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        DynamicId = dynamicId;
    }

    public Integer getCommDelete() {
        return commDelete;
    }

    public void setCommDelete(Integer commDelete) {
        this.commDelete = commDelete;
    }

    public Long getCommFatherId() {
        return commFatherId;
    }

    public void setCommFatherId(Long commFatherId) {
        this.commFatherId = commFatherId;
    }

    @Override
    public String toString() {
        return "DynamicComments{" +
                "commId=" + commId +
                ", userId=" + userId +
                ", commContent='" + commContent + '\'' +
                ", commTime=" + commTime +
                ", DynamicId=" + DynamicId +
                ", commDelete=" + commDelete +
                ", commFatherId=" + commFatherId +
                '}';
    }
}
