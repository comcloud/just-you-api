package com.cloud.api.test;
import com.cloud.api.bean.entity.TaskClassification;
import com.cloud.api.mapper.classificationMapper;
import com.cloud.api.service.classificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/20-16:04
 */
@SpringBootTest
public class classification {
    @Autowired
    private classificationMapper c;
    @Autowired
    classificationService cc;
@Test
    public void test(){
    System.out.println("-------------------------------------------");
    System.out.println(cc.deleteClassificationByClassId(5L));
    System.out.println("-------------------------------------------");

}
}
