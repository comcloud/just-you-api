package com.cloud.api.bean.vo;

/**
 * @author hds
 * <p>项目名称: 用户简单实体类 vo
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-16:22
 */
public class userVo {
    public Long user_id;
    public String user_name;
    public  String open_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    @Override
    public String toString() {
        return "userVo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", open_id='" + open_id + '\'' +
                '}';
    }
}
