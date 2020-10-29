package com.cloud.api.service;

import com.cloud.api.bean.dto.MessageDto;
import com.cloud.api.bean.vo.MessageVo;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/27 19:15
 */
public interface MessageService {
    void pushMessage(MessageVo messageVo);
}
