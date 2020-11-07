package com.cloud.api.mapper.BlogThehall;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.vo.DynamicCommentsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-10:55
 */
@Mapper
public interface DynamicCommMapper {
    /**
     * 获取全部评论
     * @param dynamic_id
     * @return
     */
    List<DynamicCommentsVo> selectAll(@Param("dynamic_id") Long dynamic_id);

    /**
     * 点赞
     * @param openId
     * @param dynamic_id
     * @return
     */
    int giveALike(@Param("openId") String openId, @Param("dynamicId")Long dynamicId);

    /**
     * 添加评论
     * @param map
     * @return
     */
    int insertComments(Map<String,Object> map);

    /**
     * 查看当前用户是否给该动态点赞
     * @param openId
     * @param dynamicId
     * @return
     */
    int isGiveALike(@Param("openId") String openId, @Param("dynamicId") Long dynamicId);

    /**
     * 取消点赞
     * @param openId
     * @param dynamicId
     * @return
     */
    int cancelGiveALike(@Param("openId") String openId, @Param("dynamicId") Long dynamicId);

    int deleteComm(@Param("commId") Long commId);
}
