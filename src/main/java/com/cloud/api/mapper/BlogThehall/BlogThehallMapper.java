package com.cloud.api.mapper.BlogThehall;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.vo.BlogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hds
 * <p>项目名称: 动态大厅 Mapper接口
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-9:20
 */
@Mapper
public interface BlogThehallMapper {
    /**
     * 查询推送红博客List 结合
     * @return
     */
    List<BlogVo> selectPushAllBlog();


    Dynamic selectDynamicDetails(@Param("dynamic_id") Long dynamic_id);


    /**
     * 浏览量增加
     * @param dynamicId
     * @return
     */
    int dynamicViewsAdd1(@Param("dynamicId") Long dynamicId);
    /**
     * @param openId
     * @param dynamicId
     * @return
     */
    int  dynamicAddLike(@Param("openId")String openId,@Param("dynamicId") Long dynamicId);
    /**
     * 用户给动态点赞
     * @param openId 用户Id
     * @param dynamicId 动态Id
     * @return 》0 点赞成功
     */
    int dynamicCancelAddLike(@Param("openId")String openId,@Param("dynamicId") Long dynamicId);

    /**
     * 根据任务Id获取任务点赞数量
     * @param dynamicId 任务Id
     * @return 任务点赞数量
     */
    Long selectLikeCountByDynamicId(@Param("dynamicId")Long dynamicId);

    /**
     * 判断用是否给该任务点赞
     * @param openId
     * @param dynamicId
     * @return
     */
    int selectIFAddLike(@Param("openId")String openId,@Param("dynamicId") Long dynamicId);


}
