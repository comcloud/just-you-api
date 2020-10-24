package com.cloud.api.service.BlogThehall;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.vo.BlogVo;
import java.util.List;
public interface BlogThehallService {
    /**
     * 查询推送红博客List 结合
     * @return
     */
    List<BlogVo> getPushAllBlog();

    /**
     * 根据博客Id 推送 文章
     * @return 推送文章数量
     */
    boolean setPushBy1();

    /**
     * 取消文章推送
     * @return 取消的个数
     */
    boolean setPushBy0();

    /**
     * 根究 动态ID返回 动态详情
     * @param dynamic_id
     * @return
     */
    List<Dynamic> getDynamicDetails(Long dynamic_id);
}
