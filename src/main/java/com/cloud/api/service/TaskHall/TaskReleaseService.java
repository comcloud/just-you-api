package com.cloud.api.service.TaskHall;

import com.cloud.api.bean.vo.TaskClassificationVo;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/29-19:15
 */

public interface TaskReleaseService {
    List<TaskClassificationVo> getTaskClassificationAll();
}
