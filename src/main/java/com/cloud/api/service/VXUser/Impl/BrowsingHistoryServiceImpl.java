package com.cloud.api.service.VXUser.Impl;

import com.cloud.api.bean.vo.UserBrowsingHistoryTaskVo;
import com.cloud.api.bean.vo.UserBrowsingHistoryVo;
import com.cloud.api.bean.vo.UserVo;
import com.cloud.api.mapper.VXUser.BrowsingHistoryMapper;
import com.cloud.api.service.VXUser.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:30
 */
@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Autowired
    private  BrowsingHistoryMapper browsingHistoryMapper;
    @Override
    public Map<String,  List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>>> getUserBrowsingHistoryVoByTask(String browsingHistoryOpenId) {
        List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>> userBrowsingHistoryVos = browsingHistoryMapper.selectUserBrowsingHistoryVoByTask(browsingHistoryOpenId);
        Map<String, List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>>> stringListHashMap = new HashMap<>();
        for (UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo> userBrowsingHistoryVo : userBrowsingHistoryVos) {
            userBrowsingHistoryVo.getT().setUser(browsingHistoryMapper.selectUserVoByuseerId(userBrowsingHistoryVo.getT().getUserId()));
            userBrowsingHistoryVo.getT().setTaskClassificationVo(browsingHistoryMapper.seleectTaskClassificationByclassId(userBrowsingHistoryVo.getT().getClassId()));
            if(stringListHashMap.size()==0){
                ArrayList<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>> list1 = new ArrayList<>();
                list1.add(userBrowsingHistoryVo);
                stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),list1);
            }else{
                String format = new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime());
                boolean b = stringListHashMap.containsKey(format);
                if (b){
                    List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>> userBrowsingHistoryVos1 = stringListHashMap.get(format);
                    userBrowsingHistoryVos1.add(userBrowsingHistoryVo);
                    stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),userBrowsingHistoryVos1);
                }else {
                    ArrayList<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>> list1 = new ArrayList<>();
                    list1.add(userBrowsingHistoryVo);
                    stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),list1);
                }
            }
        }
        return stringListHashMap;
    }

    @Override
    public Map<String,  List<UserBrowsingHistoryVo<UserVo>>> selectUserBrowsingHistoryVoByUser(String browsingHistoryOpenId) {
        List<UserBrowsingHistoryVo<UserVo>> userBrowsingHistoryVos = browsingHistoryMapper.selectUserBrowsingHistoryVoByUser(browsingHistoryOpenId);
        Map<String, List<UserBrowsingHistoryVo<UserVo>>> stringListHashMap = new HashMap<>();

        for (UserBrowsingHistoryVo<UserVo> userBrowsingHistoryVo : userBrowsingHistoryVos) {
            if (stringListHashMap.size()==0){
                List<UserBrowsingHistoryVo<UserVo>> list1 = new ArrayList<>();
                list1.add(userBrowsingHistoryVo);
                stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),list1);
            }else {
                String format = new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime());
                boolean b = stringListHashMap.containsKey(format);
                if (b){
                    List<UserBrowsingHistoryVo<UserVo>> userBrowsingHistoryVos1 = stringListHashMap.get(format);
                    userBrowsingHistoryVos1.add(userBrowsingHistoryVo);
                    stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),userBrowsingHistoryVos1);
                }else {
                    ArrayList<UserBrowsingHistoryVo<UserVo>> list1 = new ArrayList<>();
                    list1.add(userBrowsingHistoryVo);
                    stringListHashMap.put(new SimpleDateFormat("yyyy/MM/dd").format(userBrowsingHistoryVo.getBrowsingHistoryTime()),list1);
                }
            }

        }
        return stringListHashMap;
    }

    @Override
    public Map<String, Map> getUserBrowsingHistory(String browsingHistoryOpenId) {
        Map<String,  Map> stringMapHashMap = new HashMap<>();
        stringMapHashMap.put("BrowsingHistoryVoByTask",getUserBrowsingHistoryVoByTask(browsingHistoryOpenId));
        stringMapHashMap.put("BrowsingHistoryUseer",selectUserBrowsingHistoryVoByUser(browsingHistoryOpenId));
        return stringMapHashMap;
    }

    @Override
    public boolean insertBrowsingHistory(Integer browsingHistoryClass, String browsingHistoryOpenId, Map<String, Object> map) {
        return false;
    }
}
