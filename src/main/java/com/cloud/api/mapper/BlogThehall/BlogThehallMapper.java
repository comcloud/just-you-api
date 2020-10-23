package com.cloud.api.mapper.BlogThehall;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.vo.BlogVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author hds
 * <p>项目名称: 动态大厅 Mapper接口
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-9:20
 */
@Mapper
public interface BlogThehallMapper {
    /**
     * 查询推送红博客List 结合
     * @return
     */
    List<BlogVo> selectPushAllBlog();

    /**
     * 根据博客Id 推送 文章
     * @return 推送文章数量
     */
    int updatePushBy1();

    /**
     * 取消文章推送
     * @return 取消的个数
     */
    int updatePushBy0();

    List<Dynamic> selectDynamicDetails(Long dynamic_id);


}
