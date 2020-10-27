package com.cloud.api.service.VXUser.Impl;

import com.cloud.api.bean.vo.UserAttention;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.service.VXUser.VXUserService;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}


