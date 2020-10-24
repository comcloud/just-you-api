package com.cloud.api.service.BlogThehall.Impl;
import com.cloud.api.bean.vo.TaskCommentsVo;
import com.cloud.api.mapper.BlogThehall.DynamicCommMapper;
import com.cloud.api.service.BlogThehall.TaskCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-10:54
 */
@Service
public class TaskCommentsServiceImpl implements TaskCommentsService {
    @Autowired
    private DynamicCommMapper taskCommentsMapper;
    @Override
    public boolean ifSon(Long comm_id) {
        return taskCommentsMapper.selectSonCount(comm_id)>0;
    }

    @Override
    public List<TaskCommentsVo> getSonTaskComm(Long comm_id) {
        return taskCommentsMapper.selectSonyByFid(comm_id);
    }


    @Override
    public List<TaskCommentsVo> getAllTaskComm(Long dynamic_id) {
        List<TaskCommentsVo> fComm = get1FComm(dynamic_id);
       SonAddF(fComm);
        return fComm;
    }

    @Override
    public List<TaskCommentsVo> get1FComm(Long dynamic_id) {
        return taskCommentsMapper.select1FComm(dynamic_id);
    }
    @Override
    public void SonAddF(List<TaskCommentsVo> tcv) {
        for (TaskCommentsVo item : tcv){
            if (!ifSon(item.getCommId())){
                SonAddF(taskCommentsMapper.selectSonyByFid(item.getCommId()));
            }else {
                List<TaskCommentsVo> taskCommentsVos = taskCommentsMapper.selectSonyByFid(item.getCommId());
                item.setSontaskComments(taskCommentsVos);
            }
        }
    }
}
