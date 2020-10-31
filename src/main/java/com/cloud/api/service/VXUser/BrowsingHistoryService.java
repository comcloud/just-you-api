package com.cloud.api.service.VXUser;
import com.cloud.api.bean.vo.UserBrowsingHistoryTaskVo;
import com.cloud.api.bean.vo.UserBrowsingHistoryVo;
import com.cloud.api.bean.vo.UserVo;
import java.util.List;
import java.util.Map;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/31-2:30
 */
public interface BrowsingHistoryService {
    Map<String,  List<UserBrowsingHistoryVo<UserBrowsingHistoryTaskVo>>> getUserBrowsingHistoryVoByTask(String browsingHistoryOpenId);
    Map<String,  List<UserBrowsingHistoryVo<UserVo>>> selectUserBrowsingHistoryVoByUser( String browsingHistoryOpenId);
    Map<String, Map> getUserBrowsingHistory(String browsingHistoryOpenId);
    boolean insertBrowsingHistory(Integer browsingHistoryClass, String browsingHistoryOpenId, Map<String,Object> map);

}
