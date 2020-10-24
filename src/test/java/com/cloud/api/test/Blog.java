package com.cloud.api.test;

import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-15:16
 */
@SpringBootTest
public class Blog {
    @Autowired
    BlogThehallMapper blogThehallService;
@Test
    public void text(){
    System.out.println(blogThehallService.selectDynamicDetails(1L));
}
}
