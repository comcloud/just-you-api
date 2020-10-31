package com.cloud.api.bean.vo;

import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:43
 */
public class UserBrowsingHistoryVo<T> {
    /*
    历史记录ID
     */
    private Long browsingHistoryId;
    /*
  浏览时间
   */
    private Date browsingHistoryTime;
    /*
    浏览
     */
    private T t;

    public Long getBrowsingHistoryId() {
        return browsingHistoryId;
    }

    public void setBrowsingHistoryId(Long browsingHistoryId) {
        this.browsingHistoryId = browsingHistoryId;
    }

    public Date getBrowsingHistoryTime() {
        return browsingHistoryTime;
    }

    public void setBrowsingHistoryTime(Date browsingHistoryTime) {
        this.browsingHistoryTime = browsingHistoryTime;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
