package com.cloud.api.bean.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import	java.util.ArrayList;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-9:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentsVo {
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
     * 父评论id
     */
    private Long commFatherId;
    /*
    子评论集合
     */
    private List<TaskCommentsVo> sontaskComments= new ArrayList<> ();
}
