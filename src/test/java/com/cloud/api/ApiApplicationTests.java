package com.cloud.api;

import com.cloud.api.bean.vo.BlogVo;
import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.mapper.BlogThehall.DynamicCommMapper;
import com.cloud.api.service.BlogThehall.DynamicCommentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {
@Autowired
    DynamicCommMapper dynamicCom;
@Autowired
        DynamicCommMapper a;
@Autowired
DynamicCommentsService taskCommentsService;
@Autowired
    BlogThehallMapper aa;

@Test

<<<<<<< HEAD
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("1","2");
        System.out.println(redisTemplate.opsForValue().get("1"));

=======
    void contextLoads() {
        System.out.println( );
>>>>>>> feature/comm
        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

//        System.out.println("输出所有数据:");

        // 传递参数 n
//        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

//        System.out.println("输出所有偶数:");
//        eval(list, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

//        System.out.println("输出大于 3 的所有数字:");
//        eval(list, n -> n > 3);
//        List<TaskCommentsVo> taskCommentsVos = dynamicCom.select1FComm(1L);
//        System.out.println(taskCommentsVos);

//        List<TaskCommentsVo> taskCommentsVos1 = dynamicCom.selectSonyByFid(1L);
//        System.out.println(dynamicCom.seelectFcomm_id(3L));
//        System.out.println("==================================================");
//        System.out.println(taskCommentsService.getAllTaskComm(1L));
//        System.out.println("==================================================");
//
//        System.out.println(a.selectAll(1L));

    List<BlogVo> blogVos = aa.selectPushAllBlog();
    System.out.println(blogVos);

}

}
