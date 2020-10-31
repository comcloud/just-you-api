package com.cloud.api.mapper;
import com.cloud.api.bean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称: ]
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/7-12:53
 */
@Mapper
public interface UserMapper {
    /**
     * 获取全部没删除的用户用户
     * @param id
     * @return User 集合
     */
    List<User> selectAllUser(@Param("id") Integer id);

    /**
     * 根据 USer id 修改 修改用户状态
     * @return 1成功
     */
    int updateUserStateTo0(@Param("UserId") Long UserId);

    /**
     * 根据 USer id 修改 修改用户状态
     * @param UserId
     * @return
     */
    int updateUserStateTo1(@Param("UserId") Long UserId);

    int updateUserDeleteAll(@Param("ids") Integer[] ids);

    int updateUserStateTo1All(@Param("ids") Integer[] ids);

    /**
     *  根据用户ID 查询用户状态
     * @param UserId
     * @return
     */
    int selectUserStateByUserId(@Param("UserId") Long UserId);

    /**
     * 根据用户id 删除用户
     * @param UserId
     * @return
     */
    int  deleteUserByUserId(@Param("UserId") Long UserId);

    /**
     * 根据UserID 永久删除用户
     * @param UserId 用户ID
     * @return 》0删除成功
     */
    int  PermanentDeleteUserByUserId(@Param("UserId") Long UserId);

    /**
     * 根据用户id恢复已经删除的用户
     * @param UserId 用户ID
     * @return >0 则代表操作成功
     */
    int replyUserByUserId(@Param("UserId") Long UserId);

    /**
     * 根据用户ID 批量恢复删除用户
     * @param ids USerID 数组
     * @return 删除用户的数量
     */
    int replyAllUserByUserId(@Param("ids") Integer[] ids);

    /**
     * 根据Open_id 准确的查找用户信息
     * @param OpenId
     * @return
     */
    List<User> searchUserByOpenId(@Param("OPenId") String OpenId);

    /**
     * @param StartingTime 起始时间
     * @param ByTheTime 截止时间
     * @return
     */
    List<User> searchUserByTimeQuantum(@Param("StartingTime") String StartingTime,@Param("ByTheTime") String ByTheTime);
    /**
     * 根据Open_id 准确的查找用户信息
     * @param OpenId
     * @return
     */
    List<User> searchDelUserByOpenId(@Param("OpenId") String OpenId);

    /**
     * @param StartingTime 起始时间
     * @param ByTheTime 截止时间
     * @return
     */
    List<User> searchUserDelByTimeQuantum(@Param("StartingTime") String StartingTime,@Param("ByTheTime") String ByTheTime);
}
