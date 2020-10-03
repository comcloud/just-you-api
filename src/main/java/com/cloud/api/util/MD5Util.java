package com.cloud.api.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/3 9:58
 */
public class MD5Util {
    public static final int time = 5;

    public static final String SALT = "springsecurity";

    /**
     * 密码加密方法
     *
     * @param password
     * @return
     */
    public static String encode(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
        }
        try {
            for (int i = 0; i < time; i++) {
                byte[] bytes = digest.digest((password + SALT).getBytes("UTF-8"));
                password = String.format("%032x", new BigInteger(1, bytes));
            }
            return password;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
        }

    }
}
