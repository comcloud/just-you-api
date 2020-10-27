package com.cloud.api.mapper.VXUser;

import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.vo.UserAttention;
import com.cloud.api.bean.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/27-4:10
 */
@Mapper
public interface VXUserMapper {
    /**
     * 添加用户信息
     *
     * @return
     */
    int insertUser(Map<String, Object> map);

    /**
     * 更新用户信息
     *
     * @return
     */
    int updateUser(Map<String, Object> map, String openId);

    /**
     *  点击 关注
     * @param MyOpenId 用户的open_id
     * @param HeOpenId 被关注的open_id
     * @return
     */
    int attentionUser(String MyOpenId, String HeOpenId);

    /**
     * 取消关注
     * @param MyOpenId
     * @param HeOpenId
     * @return
     */
    int cancelttentionUser(String MyOpenId, String HeOpenId);

    /**
     * 获取关注列表
     * @param open_id 自己的open_id
     * @return 关注用户的信息集合
     */
    List<UserAttention> selectAttentionUser(String open_id);

    /**
     *
     * @param open_id 用户 open_id
     * @return
     */
    List<UserAttention> selectFansUser(String open_id);

}
