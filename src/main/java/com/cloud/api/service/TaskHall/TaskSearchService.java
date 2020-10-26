package com.cloud.api.service.TaskHall;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.vo.TaskSearchVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-11:34
 */
public interface TaskSearchService {
    Set<String> getRecentlySearch(String open_id);
    List<TaskSearchVo> setLinkTaskSearchVos(String content);
    List<Tag> selectHotTag();
    List<TaskSearchVo> getLinkTaskByTagId(Long tag_id);
    @Transactional
    boolean insertSearch(String content,String open_id);
}
