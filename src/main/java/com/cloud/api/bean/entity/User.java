package com.cloud.api.bean.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-10-29 10:28:18
 */
public class User implements Serializable {
    private static final long serialVersionUID = -60636443549169271L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 微信用户的open_id
     */
    private String openId;
    /**
     * 电话号码
     */
    private String mobile;

    private String fans;
    /**
     * 0 ： 女 1：男
     */
    private Integer gender;
    /**
     * 地址
     */
    private String address;
    /**
     * 1 :启用 2： 停用
     */
    private Integer state;
    /**
     * 用户注册时间
     */
    private Date registrationTime;
    /**
     * 0：存在 1 ： 缓存 2彻底删除
     */
    private Integer delete;
    /**
     * 头像url地址
     */
    private String userHeadPortrait;
    /**
     * 最近一次登录时间
     */
    private Date lastRegisterTime;
    /**
     * 用户生日
     */
    private LocalDateTime userBirthday;
    /**
     * 学号
     */
    private String studentId;
    /**
     * email
     */
    private String email;
    /**
     * 个性签名
     */
    private String individuality;

    private String open_id;

    private Date registration_time;


    public User() {
    }

    public User(Long userId, String userName, String fans, String mobile, int gender, String open_id, String address, int state, Date registration_time, String userHeadPortrait, Date lastRegisterTime, int delete) {
        this.userId = userId;
        this.userName = userName;
        this.fans = fans;
        this.mobile = mobile;
        this.gender = gender;
        this.open_id = open_id;
        this.address = address;
        this.state = state;
        this.registration_time = registration_time;
        this.userHeadPortrait = userHeadPortrait;
        this.lastRegisterTime = lastRegisterTime;
        this.delete = delete;
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
    public String getFans() {
        return fans;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getDelete() {
        return delete;
    }
    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    public Date getLastRegisterTime() {
        return lastRegisterTime;
    }

    public void setLastRegisterTime(Date lastRegisterTime) {
        this.lastRegisterTime = lastRegisterTime;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fans='" + fans + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", registrationTime=" + registrationTime +
                ", delete=" + delete +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", lastRegisterTime=" + lastRegisterTime +
                ", userBirthday=" + userBirthday +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", individuality='" + individuality + '\'' +
                ", open_id='" + open_id + '\'' +
                ", registration_time=" + registration_time +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User setFans(String fans) {
        this.fans = fans;
        return this;
    }

    public String getOpen_id() {
        return open_id;
    }

    public User setOpen_id(String open_id) {
        this.open_id = open_id;
        return this;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public User setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
        return this;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }


    public LocalDateTime getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(LocalDateTime userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndividuality() {
        return individuality;
    }

    public void setIndividuality(String individuality) {
        this.individuality = individuality;
    }

}