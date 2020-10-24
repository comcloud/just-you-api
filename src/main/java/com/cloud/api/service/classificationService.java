package com.cloud.api.service;

import com.cloud.api.bean.entity.TaskClassification;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/20-18:01
 */
public interface classificationService {
    /**
     * 获取全部顶级分类
     * @return 返回定及评论集合
     */
    List<TaskClassification> getAllfTaskClassification();

    /**
     * 根据父类Id获取全部子类
     * @param class_id 父类Id
     * @return 返回子类集合
     */
    List<TaskClassification> getAllSonByFId(Long class_id);

    /**
     * 添加分类 ，父分类为0 则为主分类 反之这为子分类
     * @return
     */
    boolean insertSonClass(TaskClassification  taskClassification);

    /**
     * 根据start 修改用户状态
     * @return
     */
    boolean updatestate0(Long class_id);
    /**
     * 根据start 修改用户状态
     * @return
     */
    boolean updatestate1(Long class_id);

    /**
     * 编辑分类信息
     * @return
     */
    boolean updateClassification(TaskClassification  taskClassification);

     /**
     * 根据class_id 删除 分类
     * @param class_id 分类ID
     * @return
     */
    boolean deleteClassificationByClassId(Long class_id);

    /**
     * 根据分类ID 彻底删除 分类
     * @param class_id  分类ID
     * @return
     */
    boolean thoroughlyDeleteClassificationByClassId(Long class_id);

    /**
     * 恢复
     * @param class_id
     * @return
     */
    boolean  restoreClassificationByClassId(Long class_id);
    boolean updateSort(String sort,Long class_id);
    List<TaskClassification> getDelAllTaskClassification();
    boolean cateDeleteAll(Long[] ids);
    boolean restoreDeleteAll(Long[] ids);


}
