package com.cloud.api.mapper;

import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.User;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/28 21:16
 */
@Mapper
public interface MessageMapper {
    User selectUserFromOpenid(@Param("openid") String openid);

    Task selectTaskFromId(@Param("taskId") Integer taskId);

    Dynamic selectDynamicFromId(@Param("dynamicId") Integer dynamicId);
}
