package com.cloud.api.bean.entity;

public class Admin {
    private int aid;
    private String adminEmail;
    private String adminPassword;

    public Admin() {
    }

    public Admin(int aid, String adminName, String adminPassword) {
        this.aid = aid;
        this.adminEmail = adminName;
        this.adminPassword = adminPassword;
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
