package com.cloud.api.test;

import com.cloud.api.bean.vo.TaskCommentsVo;
import com.cloud.api.mapper.BlogThehall.TaskCommentsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/24-12:03
 */
@SpringBootTest
public class Comm {
    @Autowired
   TaskCommentsMapper TaskCommentsMapper;
    @Test
    public void text(){
        System.out.println(TaskCommentsMapper.select1FComm(2L));
    }
}
