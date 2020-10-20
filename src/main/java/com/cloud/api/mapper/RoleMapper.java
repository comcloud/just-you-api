package com.cloud.api.mapper;

import com.cloud.api.bean.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/19 23:38
 */
@Mapper
public interface RoleMapper {
    List<Admin> selectAllAdmin();

    boolean updateAdminStatus(@Param("admin") Admin admin);
}
