package com.cloud.api.mapper.TaskHall;

import com.cloud.api.bean.vo.TaskClassificationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/29-19:00
 */
@Mapper
public interface TaskReleaseMapper {
    List<TaskClassificationVo> selectTaskClassificationAll();
}
