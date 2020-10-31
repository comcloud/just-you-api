package com.cloud.api.service.VXUser.Impl;

import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.UserAttention;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.service.VXUser.VXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/27-4:11
 */
@Service
public class VXUserServiceImpl implements VXUserService {
    @Autowired
    private VXUserMapper vXUserMapper;
    @Override
    public boolean insertUser(String openid,String nickName,Integer gender,String avatarUrl,String province ) {
        HashMap<String, Object> map = new HashMap<>();
        if(openid==null || nickName==null||gender==null||avatarUrl == null||province==null){
            throw new NullPointerException("参数为空");
        }else {
            map.put("openid",openid);
            map.put("nickName",nickName);
            map.put("gender",gender);
            map.put("avatarUrl",avatarUrl);
            map.put("province",province);

        }
        return vXUserMapper.insertUser(map)>0;
    }

    @Override
    public boolean LoginUpdateUser(Object obj) {
        return true;
    }
    @Transactional
    @Override
    public boolean attentionUser(String MyOpenId, String HeOpenId) {
        if (vXUserMapper.SelectISTtentionUser(MyOpenId, HeOpenId)>0){
            try {
                throw new SQLException("重复操作");
            } catch (SQLException throwables) {
                return false;
            }
        }
            return vXUserMapper.attentionUser(MyOpenId,HeOpenId)>0;
    }
    @Transactional
    @Override
    public boolean cancelttentionUser(String MyOpenId, String HeOpenId) {
        return vXUserMapper.cancelttentionUser(MyOpenId, HeOpenId)>0;
    }

    @Override
    public List<UserAttention> selectAttentionUser(String open_id) {
        return vXUserMapper.selectAttentionUser(open_id);
    }

    @Override
    public List<UserAttention> selectFansUser(String open_id) {
        return vXUserMapper.selectFansUser(open_id);
    }

    @Override
    public Map<String, Integer> attentionCountAll(String openId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("AttentionCount",vXUserMapper.selectAttentionCount(openId));
        map.put("FansCount",vXUserMapper.selectFansCount(openId));
        return map;
    }

    @Override
    public int updateUserData(User user,String openId) {
        Map<String, Object> map = new HashMap<>();
        if(!user.getUserName().isEmpty()){
            map.put("nickName",user.getUserName());
        }
        map.put("gender",user.getUserName());
        if(!user.getAddress().isEmpty()){
            map.put("address",user.getAddress());
        }if(user.getUserBirthdayTime()!=null){
            map.put("userBirthday",user.getUserBirthdayTime());
        }if(!user.getEmail().isEmpty()){
            map.put("email",user.getEmail());
        }if(!user.getUserName().isEmpty()){
            map.put("nickName",user.getUserName());
        }if (!user.getMobile().isEmpty()){
            map.put("mobile", user.getMobile());
        }if (user.getStudentId().isEmpty()){
            map.put("studentId", user.getMobile());
        }
        return vXUserMapper.updateUserData(map,openId);
    }

    @Override
    public User selectUsrInformation(String openId) {
        return vXUserMapper.selectUsrInformation(openId);
    }

    @Override
    public List<BlogVo> getMyDynamicAll(String openId) {
        return vXUserMapper.selectMyDynamicAll(openId);
    }

    @Override
    public  Map<String,List<TaskHallVo>> getMyTaskAll(String openId) {
        Map<String,List<TaskHallVo>> map = new HashMap<>();
        map.put("is",vXUserMapper.selectMyTaskAll(openId, 0));
        map.put("past",vXUserMapper.selectMyTaskAll(openId, 1));
        return map;
    }

}


