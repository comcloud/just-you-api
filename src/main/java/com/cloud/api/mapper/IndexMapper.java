package com.cloud.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HP
 */
@Mapper
public interface IndexMapper {
    boolean selectAdmin(@Param("email") String email, @Param("password") String password);
}
