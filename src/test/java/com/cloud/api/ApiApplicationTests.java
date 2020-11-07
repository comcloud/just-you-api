package com.cloud.api;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.VXUser.BrowsingHistoryService;
import com.cloud.api.util.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {
    @Test
    void contextLoads() {
        final UserMapper mapper = (UserMapper) SpringUtil.getBean("userMapper");
        final List<Dynamic> dynamics = mapper.selectDynamicFromOpenId("vx001");
        dynamics.forEach(dynamic -> {
            final LocalDateTime time = dynamic.getDynamicTime();
            final String now = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM:dd HH:mm:ss"));
            System.out.println("now = " + now);
            System.out.println(time.toString());
        });

    }


}
