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
     * 获取全部的 评论
     * @return
     */
    List<DynamicCommentsVo> getAllTaskComm(Long dynamic_id);
    /**
     * 获取顶级 评论
     * @return
     */

    List<DynamicCommentsVo>  SonAddF(Long comm_id,List<DynamicCommentsVo> tcv);

    boolean giveALike(Long dynamic_id,String openId);

    boolean selectIFAddLike(Long dynamic_id,String openId);

    boolean insertComments( Long dynamic_id,String open_id, Long comm_father_id,String content);

    boolean deleteComm(Long commId);

}
