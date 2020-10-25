package com.cloud.api.mapper.BlogThehall;
import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.bean.vo.TaskCommentsVo;
import com.cloud.api.bean.vo.taskHallVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-10:55
 */
@Mapper
public interface DynamicCommMapper {
    /**
     * 查看子评论个数
     * @return 子评论个数
     */
    int selectSonCount(Long comm_father_id);

    /**
     * 获取父评论ID
     * @return
     */
    String seelectFcomm_id(Long comm_id);

    /**
     *
     * @param comm_father_id
     * @return
     */
    List<DynamicCommentsVo> selectSonyByFid(Long comm_father_id);

    /**
     *
     * @param dynamic_id
     * @return
     */
    List<DynamicCommentsVo> select1FComm(Long dynamic_id);


    List<DynamicCommentsVo> selectAll(Long dynamic_id);



}
