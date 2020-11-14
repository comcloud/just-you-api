package com.cloud.api.util.http;

import com.baidu.aip.nlp.AipNlp;
import com.cloud.api.service.AuthService;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/5 10:15
 */
public class ApiUtil {

    private ApiUtil(){
        throw new IllegalStateException("Utility class!");
    }

    /**
     * 获取给定的情感倾向
     *
     * @param content 判断内容
     * @return 判断结果
     */
    public static String getEmotionalTendency(String content) {
        final AipNlp aipNlp = AuthService.configNlpClient();
        HashMap<String,Object> options = new HashMap<>();
        final JSONObject jsonObject = aipNlp.sentimentClassify(content, options);
        return jsonObject.toString(2);
    }


}
