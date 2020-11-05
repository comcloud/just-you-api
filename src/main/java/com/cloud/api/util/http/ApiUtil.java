package com.cloud.api.util.http;

import com.cloud.api.service.AuthService;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/5 10:15
 */
public class ApiUtil {
    private static final String EMOTIONAL_TENDENCY = "https://aip.baidubce.com/rpc/2.0/nlp/v1/sentiment_classify_custom";

    /**
     * 获取给定的情感倾向
     *
     * @param content 判断内容
     * @return 判断结果
     */
    public static String getEmotionalTendency(String content) throws Exception {
        String params = "text=" + content + "&charset=UTF-8";
        final String auth = AuthService.getAuth();
        return HttpUtil.post(EMOTIONAL_TENDENCY, auth, "application/json", params,"utf-8");
    }
}
