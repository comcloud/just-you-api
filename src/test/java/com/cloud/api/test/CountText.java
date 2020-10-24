package com.cloud.api.test;
import com.cloud.api.service.CountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/8-19:55
 */
@SpringBootTest
public class CountText {
    @Autowired
    CountService configService;
    @Test
    public void test(){
            String a=null;
        System.out.println(a);
    }
}
