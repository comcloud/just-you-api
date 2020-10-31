package com.cloud.api.service;

import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/30 8:45
 */
public interface PublishService {

    void saveReleaseInfo(String info);

    Map<Integer, String> getAllTag();

}
