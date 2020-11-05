package com.cloud.api.service.VXUser;

import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.UserAttention;

import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/27-4:10
 */

public interface VXUserService {
    /**
     * 添加用户信息
     *
     * @return
     */
    boolean insertUser(String openid, String nickName, Integer gender, String avatarUrl, String province);

    /**
     * 更新用户信息
     *
     * @return
     */
    boolean LoginUpdateUser(Object obj);

    /**
     * 点击 关注
     *
     * @param MyOpenId 用户的open_id
     * @param HeOpenId 被关注的open_id
     * @return
     */
    boolean attentionUser(String MyOpenId, String HeOpenId);

    /**
     * 取消关注
     *
     * @param MyOpenId
     * @param HeOpenId
     * @return
     */
    boolean cancelttentionUser(String MyOpenId, String HeOpenId);

    /**
     * 获取关注列表
     *
     * @param open_id 自己的open_id
     * @return 关注用户的信息集合
     */
    List<UserAttention> selectAttentionUser(String open_id);

    /**
     * 获取粉丝列表
     *
     * @param open_id 用户 open_id
     * @return
     */
    List<UserAttention> selectFansUser(String open_id);

    Map<String, Integer> attentionCountAll(String openId);

    int updateUserData(User user, String openId);

    User selectUsrInformation(String openId);

    List<BlogVo> getMyDynamicAll(String openId);

    Map<String, List<TaskHallVo>> getMyTaskAll(String openId);

    String getAnalyzePicture(String openId);

    String getAnalyzeText(String openId);
}
