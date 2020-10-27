package com.cloud.api.bean.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-12:00
 */
public class TaskSearchVo {
    private Long searchId;
    private String searchName;
    private Date searchTime;

    public TaskSearchVo(Long searchId, String searchName, Date searchTime) {
        this.searchId = searchId;
        this.searchName = searchName;
        this.searchTime = searchTime;
    }

    public TaskSearchVo() {
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    @Override
    public String toString() {
        return "TaskSearchVo{" +
                "searchId=" + searchId +
                ", searchName='" + searchName + '\'' +
                ", searchTime=" + searchTime +
                '}';
    }
}
