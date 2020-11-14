package com.cloud.api.mapper.TaskHall;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.TaskSearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-11:33
 */
@Mapper
public interface TaskSearchMapper {
    /**
     * 查询用户最近搜索记录
     * @return
     */
    List<TaskSearchVo> SelectRecentlySearch(@Param("open_id") String open_id);

    /**
     * 搜索栏对任务进搜索
     * @param content 搜索内容
     * @return 结果
     */
    List<TaskHallVo> SelectLinkTaskSearchVos(@Param("content") String content);

    /**
     *获取热门标签
     * @return
     */
    List<Tag> selectHotTag();

    List<TaskSearchVo> SelectLinkTaskByTagId(@Param("tag_id") Long tag_id);

    int insertSearch(Map<String,Object> map);
}

