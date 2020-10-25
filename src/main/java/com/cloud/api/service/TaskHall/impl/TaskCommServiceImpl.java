package com.cloud.api.service.TaskHall.impl;

import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.bean.vo.TaskCommentsVo;
import com.cloud.api.mapper.TaskHall.TaskCommMapper;
import com.cloud.api.service.TaskHall.TaskCommService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/25-12:37
 */
@Service
public class TaskCommServiceImpl implements TaskCommService {
@Autowired 
private TaskCommMapper taskCommMapper;
    @Override
    public List<TaskCommentsVo> SonAddF(Long comm_id, List<TaskCommentsVo> tcv) {
        List<TaskCommentsVo> SonComm=new ArrayList<>();
        for (TaskCommentsVo item : tcv){
            if (!item.getCommFatherId().equals(0L)){
                if (item.getCommFatherId().equals(comm_id)){
                    SonComm.add(item);
                }
            }
        }
        if (SonComm.size()==0){
            return null;
        }
        for (TaskCommentsVo dynamicCommentsVo : SonComm) {
            dynamicCommentsVo.setSontaskComments(SonAddF(dynamicCommentsVo.getCommId(),tcv));
        }
        return SonComm;
    }

    @Override
    public List<TaskCommentsVo> getAllTaskComm(Long task_id) {
        List<TaskCommentsVo> dynamicCommentsVos = taskCommMapper.selectAll(task_id);
        List<TaskCommentsVo> root=new ArrayList<> ();
        for (TaskCommentsVo dynamicCommentsVo : dynamicCommentsVos) {
            TaskCommentsVo dynamicCommentsVo1 = new TaskCommentsVo();
            BeanUtils.copyProperties(dynamicCommentsVo, dynamicCommentsVo1);
            root.add(dynamicCommentsVo1);
        }
        List<TaskCommentsVo> fieldList=new ArrayList<>();
        for (TaskCommentsVo dynamicCommentsVo : root) {
            if (dynamicCommentsVo.getCommFatherId().equals(0L)){
                fieldList.add(dynamicCommentsVo);
            }
        }
        for (TaskCommentsVo dynamicCommentsVo : fieldList) {
            dynamicCommentsVo.setSontaskComments(SonAddF(dynamicCommentsVo.getCommId(), root));
        }
        return fieldList;
    }
}
