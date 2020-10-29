package com.cloud.api.bean.vo;
import	java.util.ArrayList;
import	java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-15:51
 */
public class DynamicCommentsVo {
    /**
     * 评论id
     */
    private Long commId;
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
    private Long dynamicId;

    /**
     * 父评论id
     */
    private Long commFatherId;

    private UserVo user;

    private List<DynamicCommentsVo> sonComm=new ArrayList<> ();


    public DynamicCommentsVo() {
    }

    public DynamicCommentsVo(Long commId, String commContent, Object commTime, Long dynamicId, Long commFatherId, UserVo user, List<DynamicCommentsVo> sonComm) {
        this.commId = commId;
        this.commContent = commContent;
        this.commTime = commTime;
        this.dynamicId = dynamicId;
        this.commFatherId = commFatherId;
        this.user = user;
        this.sonComm = sonComm;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
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
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getCommFatherId() {
        return commFatherId;
    }

    public void setCommFatherId(Long commFatherId) {
        this.commFatherId = commFatherId;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public List<DynamicCommentsVo> getSonComm() {
        return sonComm;
    }

    public void setSonComm(List<DynamicCommentsVo> sonComm) {
        this.sonComm = sonComm;
    }
}