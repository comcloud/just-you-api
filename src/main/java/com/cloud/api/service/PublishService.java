package com.cloud.api.service;

import com.cloud.api.bean.entity.Tag;

import java.util.List;
import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/30 8:45
 */
public interface PublishService {

    void saveReleaseInfo(String info);

    List<Tag> getAllTag();

    String getKey(String jsCode);
}
