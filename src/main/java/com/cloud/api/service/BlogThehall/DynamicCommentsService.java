package com.cloud.api.service.BlogThehall;
import com.cloud.api.bean.vo.DynamicCommentsVo;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-10:06
 */
public interface DynamicCommentsService {
    /**
     * @param comm_id 评论id
     * @return 是否有子评论
     */
    boolean ifSon(Long comm_id);

    /**
     * 戈恩局付费嗯嗯类获取子类
     * @param comm_id 评论id
     * @return
     */
    List<DynamicCommentsVo> getSonTaskComm(Long comm_id);

    /**
     * 获取全部的 评论
     * @return
     */
    List<DynamicCommentsVo> getAllTaskComm(Long dynamic_id);
    /**
     * 获取顶级 评论
     * @return
     */
    List<DynamicCommentsVo> get1FComm(Long dynamic_id);

    List<DynamicCommentsVo>  SonAddF(Long comm_id,List<DynamicCommentsVo> tcv);

    boolean giveALike(Long dynamic_id,Long role);

    boolean insertComments( Long dynamic_id,String open_id, Long comm_father_id,String content);


}
