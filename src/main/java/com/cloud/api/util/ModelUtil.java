package com.cloud.api.util;

import cn.hutool.core.lang.Pair;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:30
 */
public class ModelUtil<T,R> {
    private T objectValue;
    private R normalValue;

    public T getObjectValue() {
        return objectValue;
    }

    public ModelUtil<T, R> setObjectValue(T objectValue) {
        this.objectValue = objectValue;
        return this;
    }

    public R getNormalValue() {
        return normalValue;
    }

    public ModelUtil<T, R> setNormalValue(R normalValue) {
        this.normalValue = normalValue;
        return this;
    }
}
