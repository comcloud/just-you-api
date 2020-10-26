package com.cloud.api.test;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestAllMethod {
    @Test
    public void test() throws SQLException {
        double num1=(19/4%3);
        double num2 = (19.0/4.0%3.0);
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
        final Duration between = Duration.between(now,min);
        System.out.println(between.toDays()>0?between.toDays():-between.toDays());
        System.out.println(between.toHours() / 24.0);

    }
}
