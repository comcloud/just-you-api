package com.cloud.api.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestAllMethod {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void test() throws SQLException {
        double num1 = (19 / 4 % 3);
        double num2 = (19.0 / 4.0 % 3.0);
        System.out.println(num1);
        System.out.println(num2);
    }

    @Test
    public void testJsonNode() throws JsonProcessingException {
        String json = "{\n" +
                "  \"username\": \"xiniu\",\n" +
                "  \"state\": \"6\",\n" +
                "  \"sort\": \"1\",\n" +
                "  \"projectData\": \"tes\",\n" +
                "  \"charge\": \"0\",\n" +
                "  \"releaseTime\": \"2020-10-09\",\n" +
                "  \"needNumber\": \"15\",\n" +
                "  \"recruitingNumber\": \"20\",\n" +
                "  \"comment\": \"1\",\n" +
                "  \"desc\": \"tset\"\n" +
                "}";
        final JsonNode node = new ObjectMapper().readTree(json);
        final Iterator<String> stringIterator = node.fieldNames();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());


        }
    }

    @Test
    public void testBuffer() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.forEach(l -> {
            System.out.print(l);
            System.out.print(",");
        });
    }

    @Test
    public void testDuration() throws InterruptedException {
        final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        final LocalDateTime min = LocalDateTime.parse("2020-10-12T12:13:24.156025400");
        final Duration between = Duration.between(now, min);
        System.out.println(between.toDays() > 0 ? between.toDays() : -between.toDays());
        System.out.println(between.toHours() / 24.0);

    }
//
//    @Test
//    public void testEmail() {
//        MailUtil.send("2230817302@qq.com", "测试", "邮件来自Hutool测试", false);
//    }

    @Test
    public void testMethod() {
        int n = 10;
        System.out.println(getNum(n));
    }

    private int getNum(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNum(n - 1) + getNum(n - 2);
        }
    }
}
