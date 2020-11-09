package com.cloud.api.util.http;

import com.baidu.aip.nlp.AipNlp;
import com.cloud.api.service.AuthService;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        final AipNlp aipNlp = AuthService.configNlpClient();
        HashMap<String,Object> options = new HashMap<>();
        final JSONObject jsonObject = aipNlp.sentimentClassify(content, options);
        return jsonObject.toString(2);
    }


}
