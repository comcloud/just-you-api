package com.cloud.api.util;

import java.io.Serializable;

/**
 */
//继承了可序列化接口
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //结果代码 200 表示操作成功 500 表示操作失败
    private int resultCode;
    //失败结果返回字符串
    private String message;
    //接收数据
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
