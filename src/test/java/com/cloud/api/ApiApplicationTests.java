package com.cloud.api;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import com.cloud.api.service.VXUser.BrowsingHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {
    @Autowired
    BrowsingHistoryService builder;
    @Autowired
    TaskHallMapper taskHallMapper;
    @Test
    void contextLoads() {
        System.out.println(taskHallMapper.selectTaskDetails(2L));

    }


}
