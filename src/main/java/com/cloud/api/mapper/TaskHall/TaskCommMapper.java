package com.cloud.api.mapper.TaskHall;

import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.bean.vo.TaskCommentsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/25-12:24
 */
@Mapper
public interface TaskCommMapper {
    List<TaskCommentsVo> selectAll(Long task_id);
}
