package com.cloud.api.mapper.VXUser;

import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:31
 */
@Mapper
public interface BrowsingHistoryMapper {
    /**
     * 记录用户浏览记录
     * @param browsingHistoryClass 0：用户 1：代表任务
     * @param browsingHistoryOpenId 浏览的用户openId
     * @param map
     * @return
     */
    int insertBrowsingHistory(@Param("browsingHistoryClass") Integer browsingHistoryClass,
                             @Param("browsingHistoryOpenId") String browsingHistoryOpenId,
                             Map<String,Object> map);
    List<UserBrowsingHistoryVo<UserVo>> selectUserBrowsingHistoryVoByUser(@Param("browsingHistoryOpenId") String browsingHistoryOpenId);
    List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>> selectUserBrowsingHistoryVoByTask(@Param("browsingHistoryOpenId") String browsingHistoryOpenId);


    UserVo selectUserVoByuseerId(@Param("userId") Long userId);

    TaskClassificationVo seleectTaskClassificationByclassId(@Param("classId") Long classId);
}
