package com.cloud.api.test;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class TestAllMethod {
    @Test
    public void test() throws SQLException {
        List<Entity> test = Db.use().findAll("test");
        for (Entity entity : test) {
            String tid = entity.getStr("tid");
            String username = entity.getStr("username");
            String password = entity.getStr("password");


        }
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
    public void testBuffer(){
        final StringBuffer buffer = new StringBuffer();
        System.out.println(buffer.toString());
    }
    @Test
    public void testDuration() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        Thread.sleep(3000);
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(now,end);
        long days = duration.toDays(); //相差的天数
        long hours = duration.toHours();//相差的小时数
        long minutes = duration.toMinutes();//相差的分钟数
        long millis = duration.toMillis();//相差毫秒数
        long nanos = duration.toNanos();//相差的纳秒数
        System.out.println(now);
        System.out.println(end);

        System.out.println("发送短信耗时【 "+days+"天："+hours+" 小时："+minutes+" 分钟："+millis+" 毫秒："+nanos+" 纳秒】");
    }
}
