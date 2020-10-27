package com.cloud.api.service.BlogThehall.Impl;
import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.mapper.BlogThehall.DynamicCommMapper;
import com.cloud.api.service.BlogThehall.DynamicCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-10:54
 */
@Service
public class DynamicCommentsServiceImpl implements DynamicCommentsService {
    @Autowired
    private DynamicCommMapper dynamicCommMapper;
    @Override
    public boolean ifSon(Long comm_id) {
        return dynamicCommMapper.selectSonCount(comm_id)>0;
    }

    @Override
    public List<DynamicCommentsVo> getSonTaskComm(Long comm_id) {
        return dynamicCommMapper.selectSonyByFid(comm_id);
    }


    @Override
    public List<DynamicCommentsVo> getAllTaskComm(Long dynamic_id) {
        List<DynamicCommentsVo> dynamicCommentsVos = dynamicCommMapper.selectAll(dynamic_id);
        List<DynamicCommentsVo> root=new ArrayList<> ();
        for (DynamicCommentsVo dynamicCommentsVo : dynamicCommentsVos) {
            DynamicCommentsVo dynamicCommentsVo1 = new DynamicCommentsVo();
            BeanUtils.copyProperties(dynamicCommentsVo, dynamicCommentsVo1);
            root.add(dynamicCommentsVo1);
        }
        List<DynamicCommentsVo> fieldList=new ArrayList<>();
        for (DynamicCommentsVo dynamicCommentsVo : root) {
            if (dynamicCommentsVo.getCommFatherId().equals(0L)){
                fieldList.add(dynamicCommentsVo);
            }
        }
        for (DynamicCommentsVo dynamicCommentsVo : fieldList) {
            dynamicCommentsVo.setSonComm(SonAddF(dynamicCommentsVo.getCommId(), root));
        }
        return fieldList;
    }

    @Override
    public List<DynamicCommentsVo> get1FComm(Long dynamic_id) {
        return dynamicCommMapper.selectAll(dynamic_id);
    }
    @Override
    public List<DynamicCommentsVo> SonAddF(Long comm_id,List<DynamicCommentsVo> tcv) {
        List<DynamicCommentsVo> SonComm=new ArrayList<>();
        for (DynamicCommentsVo item : tcv){
            if (!item.getCommFatherId().equals(0L)){
                if (item.getCommFatherId().equals(comm_id)){
                    SonComm.add(item);
                }
            }
        }
        if (SonComm.size()==0){
            return null;
        }
        for (DynamicCommentsVo dynamicCommentsVo : SonComm) {
            dynamicCommentsVo.setSonComm(SonAddF(dynamicCommentsVo.getCommId(),tcv));
        }
        return SonComm;
    }

    @Override
    public boolean giveALike(Long dynamic_id, String role) {
        return dynamicCommMapper.giveALike(dynamic_id,role)>0;
    }

    @Override
    public boolean insertComments(Long dynamic_id, String open_id, Long comm_father_id,String content) {
        Map<String, Object> map = new HashMap<>();
        if (dynamic_id == null||open_id==null||comm_father_id==null) {
            throw new NullPointerException("参数不能为空");
        }else {
            map.put("dynamicId",dynamic_id);
            map.put("openId",open_id);
            map.put("dynacommFatherIdmicId",comm_father_id);
            map.put("content", content);
            return dynamicCommMapper.insertComments(map)>0;
        }
    }
}
