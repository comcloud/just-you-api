package com.cloud.api.service.TaskHall.impl;
import com.cloud.api.bean.vo.TaskHallVo;
import com.cloud.api.bean.vo.task_classificationVo;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import com.cloud.api.service.TaskHall.TaskHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-13:26
 */
@Service
public class TaskHallServiceImpl implements TaskHallService {
    private List<TaskHallVo> lists=new ArrayList<>();
    @Autowired
    TaskHallMapper TaskHallMapper;
    @Override
    public List<TaskHallVo> getTask_HallList() {
        lists.addAll(TaskHallMapper.SelectTask_HallList());
        Collections.shuffle(lists);
        return  lists;
    }

    @Override
    public List<TaskHallVo> getTaskListByClass(Long class_id) {
        List<TaskHallVo> list = TaskHallMapper.SelectTaskListByClass(class_id);
        Collections.shuffle(list);
        return list;
    }

    @Override
    public void classTaskList() {
        lists.clear();
    }

    @Override
    public List<task_classificationVo> getAllClassName() {
        List<task_classificationVo> task_classificationVos = TaskHallMapper.selectClassNameList();
//       Collections.sort(task_classificationVos,new Comparator<> () {
//           @Override
//           public int compare(task_classificationVo o1, task_classificationVo o2) {
//
//               return (int) (o1.getClass_id()-o2.getClass_id());
//           }
//       });
        //按照class_id 排序
        Collections.sort(task_classificationVos,(o1,o2)-> (int) (o1.getClass_id()-o2.getClass_id()));
        return task_classificationVos;
    }
}
