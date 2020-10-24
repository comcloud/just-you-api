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
    /**
     * 关注
     */
    private String attention;
    /**
     * 粉丝
     */
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

    private int delete;

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
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

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", attention='" + attention + '\'' +
                ", fans='" + fans + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", open_id='" + open_id + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", registration_time=" + registration_time +
                ", delete=" + delete +
                '}';
    }
}