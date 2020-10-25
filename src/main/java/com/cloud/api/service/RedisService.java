package com.cloud.api.service;

import com.cloud.api.bean.dto.ExpireEnum;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/25 10:05
 */
public interface RedisService {
    boolean delete(String key);

    void addToListLeft(String listKey, ExpireEnum expireEnum, Object... values);

    void addToListRight(String listKey, ExpireEnum expireEnum, Object... values);

    List<Object> rangeList(String listKey, long start, long end);
}
