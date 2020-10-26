package com.cloud.api.bean.vo;
import	java.util.ArrayList;
import	java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-15:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicCommentsVo {
    /**
     * 评论id
     */
    private Long commId;
    /**
     * 评论者用户id
     */
    private String openId;
    /**
     * 评论内容
     */
    private String commContent;
    /**
     * 评论时间
     */
    private Object commTime;
    /**
     * 任务id
     */
    private Long dynamicId;

    /**
     * 父评论id
     */
    private Long commFatherId;

    private List<DynamicCommentsVo> sonComm=new ArrayList<> ();

    private List<userVo> user= new ArrayList<> ();

}
