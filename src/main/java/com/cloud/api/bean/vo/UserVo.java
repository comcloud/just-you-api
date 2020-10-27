package com.cloud.api.bean.vo;
/**
 * @author hds
 * <p>项目名称: 用户简单实体类 vo
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-16:22
 */
public class UserVo {
    public Long userId;
    public String userName;
    public  String openId;
    private String userHeadPortrait;

    public UserVo() {
    }

    public UserVo(Long userId, String userName, String openId, String userHeadPortrait) {
        this.userId = userId;
        this.userName = userName;
        this.openId = openId;
        this.userHeadPortrait = userHeadPortrait;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", openId='" + openId + '\'' +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                '}';
    }
}
