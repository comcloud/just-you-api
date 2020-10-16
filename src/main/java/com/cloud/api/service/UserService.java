package com.cloud.api.service;
import com.cloud.api.bean.entity.User;
import java.util.Date;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/7-13:25
 */
public interface UserService {
    List<User> getAllUser(Integer id);
    boolean updateUserStateTo0(Long UserId);
    boolean updateUserStateTo1(Long UserId);
    boolean selectUserStateByUserId(Long UserId);
    boolean  deleteUser(Long UserId);
    boolean replyUser(Long UserId);
    boolean PermanentDeleteUser(Long UserId);
    List<User> searchUserByOpen(String StartingTime  ,String ByTheTime,String OpenId);
    List<User> searchDelUserByOpen(String StartingTime  ,String ByTheTime,String OpenId);
    boolean updateUserStateTo0All(Integer[] ids);
    boolean replyAllUserByUserId(Integer[] ids);
    boolean updateUserDeleteAll(Integer[] ids);
}
