package com.cloud.api.bean.vo;

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
    private Long openId;
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
    private Long DynamicId;
    /**
     * 0：存在 1：删除
     */
    private Integer commDelete;
    /**
     * 父评论id
     */
    private Long commFatherId;

}
