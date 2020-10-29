package com.cloud.api.bean.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-10-03 18:12:22
 */
public class User implements Serializable {
    private static final long serialVersionUID = 575879234856926430L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;

    private String fans;
    /**
     *电话号码
     */
    private String mobile;
    /**
     * 性别  0 女 1 男
     */
    private int gender;

    /**
     * open id
     */
    private  String open_id;
    /**
     * 地址
     */
    private String address;

    /**
     * 状态 1启用 0停用
     */
    private int state;

    /**
     * 注册时间
     */
    private Date registration_time;
    /*
    头像url地址
     */
    private String userHeadPortrait;
    /*
    最近一次登录时间
     */
    private Date  lastRegisterTime;
    /*
    是否删除
     */
    private int delete;
    /*
    出生年月日
     */
    private Date UserBirthdayTime;
    /*
    学号
     */
    private String studentId;
    /*
    email
     */
    private String email;
    /*
    个性签名
     */
    private String individuality;

    public User() {
    }

    public User(Long userId, String userName, String fans, String mobile, int gender, String open_id, String address, int state, Date registration_time, String userHeadPortrait, Date lastRegisterTime, int delete, Date userBirthdayTime, String studentId, String email, String individuality) {
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
        UserBirthdayTime = userBirthdayTime;
        this.studentId = studentId;
        this.email = email;
        individuality = individuality;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
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

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Date getUserBirthdayTime() {
        return UserBirthdayTime;
    }

    public void setUserBirthdayTime(Date userBirthdayTime) {
        UserBirthdayTime = userBirthdayTime;
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

    public String getindividuality() {
        return individuality;
    }

    public void setindividuality(String individuality) {
        individuality = individuality;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fans='" + fans + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", open_id='" + open_id + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", registration_time=" + registration_time +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", lastRegisterTime=" + lastRegisterTime +
                ", delete=" + delete +
                ", UserBirthdayTime=" + UserBirthdayTime +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", individuality='" + individuality + '\'' +
                '}';
    }
}