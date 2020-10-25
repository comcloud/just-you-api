package com.cloud.api.service.TaskHall;

import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.bean.vo.TaskCommentsVo;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/25-12:35
 */
public interface TaskCommService {

    List<TaskCommentsVo> SonAddF(Long comm_id, List<TaskCommentsVo> tcv);

    List<TaskCommentsVo> getAllTaskComm(Long task_id);


}
