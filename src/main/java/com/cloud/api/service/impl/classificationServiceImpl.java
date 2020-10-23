package com.cloud.api.service.impl;

import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.mapper.classificationMapper;
import com.cloud.api.service.classificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/20-18:08
 */
@Service
public class classificationServiceImpl implements classificationService {
    @Autowired
    private classificationMapper classificationMapper;
    private  List<TaskClassification> son=new ArrayList<>();
    @Override
    public List<TaskClassification> getAllfTaskClassification() {
        //查询说有父节点 只有两成结构
        List<TaskClassification> taskClassifications = classificationMapper.selectAllfTaskClassification();
        for (TaskClassification taskClassification : taskClassifications) {
            Long class_id = taskClassification.getId();
            List<TaskClassification> allSonByFId = getAllSonByFId(class_id);
            taskClassification.getSon().addAll(allSonByFId);
            allSonByFId=new ArrayList<> ();
        }
        return taskClassifications;
    }

    @Override
    public List<TaskClassification> getAllSonByFId(Long class_id) {
        List<TaskClassification> taskClassifications = classificationMapper.selectAllSonByFId(class_id);
        return taskClassifications;
    }

    @Override
    public boolean insertSonClass(TaskClassification  taskClassification) {
        return false;
    }

    @Override
    public boolean updatestate0(Long class_id) {
        return classificationMapper.updatestate0(class_id)>0;
    }

    @Override
    public boolean updatestate1(Long class_id) {
        return classificationMapper.updatestate1(class_id)>0;
    }

    @Override
    public boolean updateClassification(TaskClassification  taskClassification) {

        return false;
    }

    @Override
    public boolean deleteClassificationByClassId(Long class_id) {
        return classificationMapper.deleteClassificationByClassId(class_id)>0;
    }

    @Override
    public boolean thoroughlyDeleteClassificationByClassId(Long class_id) {
        return classificationMapper.thoroughlyDeleteClassificationByClassId(class_id)>0;
    }

    @Override
    public boolean restoreClassificationByClassId(Long class_id) {
        return classificationMapper.restoreClassificationByClassId(class_id)>0;
    }

    @Override
    public boolean updateSort(String sort,Long class_id) {
        if(sort.matches("\\d+")){
            return classificationMapper.updateSort(Integer.parseInt(sort),class_id)>0;
        }else {
            return false;
        }
    }

    @Override
    public List<TaskClassification> getDelAllTaskClassification() {
        return classificationMapper.selectDelAllTaskClassification();
    }

    @Override
    public boolean cateDeleteAll(Long[] ids) {
        return classificationMapper.cateDeleteAll(ids)>0;
    }

    @Override
    public boolean restoreDeleteAll(Long[] ids) {
        return classificationMapper.restoreDeleteAll(ids)>0;
    }
}
