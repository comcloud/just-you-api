package com.cloud.api.test;

import com.cloud.api.util.algorithm.ExtractColorUtil;
import com.cloud.api.util.http.ApiUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TestAllMethod {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


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
        assert node != null;
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

    @Test
    public void testGetRgb() {
        System.out.println(ExtractColorUtil.getImagePixel(Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath() + "/upload-image/1.jpg"));
    }

    @Test
    public void testGetMainRgb() throws Exception {
        System.out.println(ExtractColorUtil.getMainRgbByFilePath(Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath() + "/upload-image/1.jpg"));
        System.out.println(ExtractColorUtil.getMainRgbByUrl("https://s1.ax1x.com/2020/11/03/BsuvNj.png"));
    }

    /**
     * 需要保存的数据
     * - 图片处理结果
     * - 文字处理结果
     * 需要返回的数据
     * - 总结果
     */
//    @Test
//    public void testGetMood() throws Exception {
//        String str = "https://i.loli.net/2020/11/03/IVBJbCPYoq5mdzr.jpg\n" +
//                "https://i.loli.net/2020/11/03/1mNHXTlQwr4ZieY.jpg\n" +
//                "https://i.loli.net/2020/11/03/5Oq9YL2NSxrDbRt.png\n" +
//                "https://i.loli.net/2020/11/03/Nztg4fAEebcPWXO.jpg\n" +
//                "https://i.loli.net/2020/11/03/GUQ5zdDn72ZvVL4.jpg\n" +
//                "https://i.loli.net/2020/11/03/CjhPg7ErJYHtGkU.jpg\n" +
//                "https://i.loli.net/2020/11/03/P7mJokyWlLRtH3K.jpg\n" +
//                "https://i.loli.net/2020/11/03/fnixZM7Estrd546.png\n" +
//                "https://i.loli.net/2020/11/03/8UM6OzfHDZaglET.png\n" +
//                "https://i.loli.net/2020/11/03/5rXVNSUiLYH4Pd6.png\n" +
//                "https://i.loli.net/2020/11/03/SZsMajmfvuFp6ex.png\n" +
//                "https://i.loli.net/2020/11/03/RmSlGOILkBp9C16.png";
//        final String[] split = str.split("\n");
//        List<String> list = new ArrayList<>(Arrays.asList(split));
////        list.add("https://s1.ax1x.com/2020/11/03/ByOkzq.png");
////        list.add("https://s1.ax1x.com/2020/11/03/ByOlWR.png");
////        list.add("https://i.loli.net/2020/11/03/IVBJbCPYoq5mdzr.jpg");
////        list.add("https://i.loli.net/2020/11/03/1mNHXTlQwr4ZieY.jpg");
////        list.add("https://i.loli.net/2020/11/03/5Oq9YL2NSxrDbRt.png");
////        list.add("https://i.loli.net/2020/11/03/Nztg4fAEebcPWXO.jpg");
////        list.add("https://i.loli.net/2020/11/03/GUQ5zdDn72ZvVL4.jpg");
////        list.add("https://i.loli.net/2020/11/03/CjhPg7ErJYHtGkU.jpg");
////        list.add("https://i.loli.net/2020/11/03/P7mJokyWlLRtH3K.jpg");
////        list.add("https://i.loli.net/2020/11/03/fnixZM7Estrd546.png");
//        Map<ColorMood,Integer> data = new LinkedHashMap<>();
//        list.forEach(url -> {
//            try {
//                ColorMood colorMood = ExtractMoodUtil.extractMoodFromRgb(ExtractColorUtil.getMainRgbByUrl(url));
//                if(!data.containsKey(colorMood)){
//                    data.put(colorMood,1);
//                }else{
//                    data.put(colorMood,data.get(colorMood)+1);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        final Stream<Map.Entry<ColorMood, Integer>> stream = data.entrySet().stream();
//        stream.max(Comparator.comparing(Map.Entry::getValue)).ifPresent(value -> System.out.println(value.getKey().getValue()));
////        data.forEach((k,v) -> System.out.println(k + "," + v));
//
//    }
    @Test
    public void testDelFile() {
        System.out.println(Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath());
        new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath(), "test.json").deleteOnExit();
    }

    @Test
    public void testGetEmotionalTendency() throws Exception {
//        final String emotionalTendency = ApiUtil.getEmotionalTendency("最喜欢你了");
//        System.out.println(emotionalTendency);
    }

    @Test
    public void genStr() {
        String s = "INSERT INTO justyou.dynamic (dynamic_title, dynamic_content, dynamic_status, dynamic_views, dynamic_comment, dynamic_deleted, dynamic_time, dynamic_update_time, Abstract, like_count, open_id, push) VALUES ('789', '傻叉', 0, 1, 0, 0, '2020-9-23 13:58:07', '2020-10-23 13:58:07', '夏天的第一杯奶茶', 1136, 'vx001', 1);";
        for (int i = 0; i < 30; i++) {
            System.out.println(s.replace("23", Integer.parseInt("30") - i + ""));
        }
    }

    @Test
    public void computeTime() {
        final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        for (int i = 1; i <= 8; i++) {
            final LocalDateTime minus = now.minus(7 * i, ChronoUnit.DAYS);
            System.out.println(minus.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

    }

    @Test
    public void testArray() {
        final ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("positive", 10);
        System.out.println(node.toPrettyString());
        node.put("positive", node.findPath("positive").asInt() + 1);
        System.out.println(node.toPrettyString());
        System.out.println(node.findPath("asd").asInt());
    }

    @Test
    public void testDouble() throws SchedulerException {

    }
}
