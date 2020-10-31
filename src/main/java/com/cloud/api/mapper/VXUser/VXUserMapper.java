package com.cloud.api.mapper.VXUser;

import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.UserAttention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    int updateUser(Map<String, Object> map, @Param("openId") String openId);

    /**
     * 修改用户信息
     * @param map 用户信息结合
     * @param openId 用户id
     * @return 》0 修改成功
     */
    int updateUserData(Map<String,Object> map,@Param("openId") String openId);
    /**
     *  点击 关注
     * @param MyOpenId 用户的open_id
     * @param HeOpenId 被关注的open_id
     * @return
     */
    int attentionUser(@Param("MyOpenId") String MyOpenId, @Param("HeOpenId") String HeOpenId);

    /**
     * 取消关注
     * @param MyOpenId
     * @param HeOpenId
     * @return
     */
    int cancelttentionUser(@Param("MyOpenId") String MyOpenId, @Param("HeOpenId") String HeOpenId);

    /**
     * 获取关注列表
     * @param open_id 自己的open_id
     * @return 关注用户的信息集合
     */
    List<UserAttention> selectAttentionUser(@Param("open_id") String open_id);

    /**
     *
     * @param open_id 用户 open_id
     * @return
     */
    List<UserAttention> selectFansUser(@Param("open_id") String open_id);


    int selectAttentionCount(@Param("openId") String openId);

    int selectFansCount(@Param("openId") String openId);

    /**
     * open_id 为 MyOpenId 的用户是否关注了OPen_id为 HeOpenId的用户
     * @param MyOpenId this
     * @param HeOpenId 别人的
     * @return
     */
    int SelectISTtentionUser(@Param("MyOpenId") String MyOpenId, @Param("HeOpenId") String HeOpenId);

    /**
     * 获取用户个人资料
     * @param openId 用户的openID
     * @return
     */
    User selectUsrInformation(@Param("openId") String openId);

    /**
     * 获取自己发布的动态
     * @param openId 自己的用户openId
     * @return
     */
    List<BlogVo> selectMyDynamicAll(@Param("openId") String openId);

    /**
     * 我发布的任务
     * @param openId 我的opeenId
     * @param start 0 ：代表已发布 没结束的 1 代表过去的的
     * @return
     */
    List<TaskHallVo>  selectMyTaskAll(@Param("openId") String openId,@Param("start") Integer start);
}
