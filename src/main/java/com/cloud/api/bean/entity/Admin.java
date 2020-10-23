package com.cloud.api.bean.entity;

import java.time.LocalDateTime;

/**
 * @author HP
 */
public class Admin {
    private int aid;
    private String adminEmail;
    private String adminPassword;
    private String adminName;
    private String adminTel;
    private LocalDateTime joinTime;
    private boolean status;
    private int role;

    public Admin() {
    }

    public Admin(int aid, String adminEmail, String adminPassword, String adminName, String adminTel, LocalDateTime joinTime, boolean status, int role) {
        this.aid = aid;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.adminTel = adminTel;
        this.joinTime = joinTime;
        this.status = status;
        this.role = role;
    }

    public String getAdminName() {
        return adminName;
    }

    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public Admin setAdminTel(String adminTel) {
        this.adminTel = adminTel;
        return this;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public Admin setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Admin setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public int getRole() {
        return role;
    }

    public Admin setRole(int role) {
        this.role = role;
        return this;
    }

    public int getAid() {
        return aid;
    }

    public Admin setAid(int aid) {
        this.aid = aid;
        return this;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public Admin setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }
}
