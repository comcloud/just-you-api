package com.cloud.api.test;
import com.cloud.api.bean.vo.task_classificationVo;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/18-11:34
 */
@SpringBootTest
public class TaskHall {
    @Autowired
    TaskHallMapper t;
    @Test
    public void text(){

        List<task_classificationVo> task_classificationVos = t.selectClassNameList();
        System.out.println(task_classificationVos);
    }
        }
