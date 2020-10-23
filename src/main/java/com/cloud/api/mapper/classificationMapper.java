package com.cloud.api.mapper;

import com.cloud.api.bean.entity.TaskClassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 成都犀牛
 * <p>项目名称: 对分类操作的Mapper接口
 * <p>文件名称:
 * <p>描述: 关与分类的操作
 * @date 2020/10/19-19:08
 */
@Mapper
public interface classificationMapper {
    /**
     * 获取全部顶级分类
     * @return 返回定及评论集合
     */
    List<TaskClassification> selectAllfTaskClassification();

    /**
     * 根据父类Id获取全部子类
     * @param class_id 父类Id
     * @return 返回子类集合
     */
    List<TaskClassification> selectAllSonByFId(Long class_id);

    /**
     * 添加分类 ，父分类为0 则为主分类 反之这为子分类
     * @return
     */
    int insertSonClass( Map<String,Object> map);

    /**
     * 根据start 修改用户状态
     * @return
     */
    int updatestate0(Long class_id);
    /**
     * 根据start 修改用户状态
     * @return
     */
    int updatestate1(Long class_id);

    /**
     * 编辑分类信息
     * @return
     */
    int updateClassification(Map<String,Object> map);

    /**
     * 根据class_id 删除 分类
     * @param class_id 分类ID
     * @return
     */
    int deleteClassificationByClassId(Long class_id);

    /**
     * 根据分类ID 彻底删除 分类
     * @param class_id  分类ID
     * @return
     */
    int thoroughlyDeleteClassificationByClassId(Long class_id);

    /**
     * 恢复删除用户
     * @param class_id
     * @return
     */
    int  restoreClassificationByClassId(Long class_id);

    /**
     * 修改排序序号
     * @param sort 排序序号
     * @param class_id 分类id
     * @return
     */
    int updateSort(Integer sort,Long class_id);

    List<TaskClassification> selectDelAllTaskClassification();

    int cateDeleteAll(Long[] ids);

    int restoreDeleteAll(Long[] ids);
}
