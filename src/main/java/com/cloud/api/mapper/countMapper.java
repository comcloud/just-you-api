package com.cloud.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/8-19:40
 */
@Mapper
public interface countMapper {
    /**
     *
     * @param id 0: 查询现在存在的 1：查询全部 包括已过时的
     * @return countMapper
     */
    int SelecttaskCount(int id);

    /**
     * 查看用户数量
     * @return 用户数量
     */
    int  selectUserCount();

    /**
     *
     * @return 动态数量
     */
    int selectDynamiccount();

    /**
     *
     * @return 已完成的订单数量
     */
    int sekectTaskOrder3();

    /**
     *  查询截止到 data前的用户个数
     * @param date 时间
     * @return
     */
    int selectCountUserTime(Date date);

}
