package com.cloud.api.service.impl;
import com.cloud.api.bean.entity.User;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 *
 * @date 2020/10/7-13:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser(Integer id) {
        return userMapper.selectAllUser(id);
    }

    @Override
    public boolean updateUserStateTo0(Long UserId) {
        return userMapper.updateUserStateTo0(UserId)>0;
    }
    @Override
    public boolean updateUserStateTo1(Long UserId) {
        return userMapper.updateUserStateTo1(UserId)>0;
    }

    @Override
    public boolean selectUserStateByUserId(Long UserId) {
        return userMapper.selectUserStateByUserId(UserId)>0;
    }

    @Override
    public boolean deleteUser(Long UserId) {
        return userMapper.deleteUserByUserId(UserId)>0;
    }

    @Override
    public boolean replyUser(Long UserId) {
        return userMapper.replyUserByUserId(UserId)>0;
    }

    @Override
    public boolean PermanentDeleteUser(Long UserId) {
        return userMapper.PermanentDeleteUserByUserId(UserId)>0;
    }

    @Override
    public List<User> searchUserByOpen(String StartingTime, String ByTheTime, String OpenId) {
        String star=null;
        String The=null;
        if (!StartingTime.equals("")){
            star=StartingTime;
        }
        if (!ByTheTime.equals("")){
            The=ByTheTime;
        }
            if (OpenId.equals("")){
                return userMapper.searchUserByTimeQuantum(star,The);
            }else {
                return userMapper.searchUserByOpenId(OpenId);
            }
    }

    @Override
    public List<User> searchDelUserByOpen(String StartingTime, String ByTheTime, String OpenId) {
        String star=null;
        String The=null;
        if (!StartingTime.equals("")){
            star=StartingTime;
        }
        if (!ByTheTime.equals("")){
            The=ByTheTime;
        }
        if (OpenId.equals("")){
            return userMapper.searchUserDelByTimeQuantum(star,The);
        }else {
            return userMapper.searchDelUserByOpenId(OpenId);
        }
    }

    @Override
    public boolean updateUserDeleteAll(Integer[] ids) {
        return userMapper.updateUserDeleteAll(ids)>0;
    }

    @Override
    public boolean updateUserStateTo0All(Integer[] ids) {
        return userMapper.updateUserStateTo1All(ids)>0;
    }

    @Override
    public boolean replyAllUserByUserId(Integer[] ids) {
        return userMapper.replyAllUserByUserId(ids)>0;
    }
}