package com.cloud.api.test;

import cn.hutool.core.codec.Base64Decoder;
import com.cloud.api.util.algorithm.ExtractColorUtil;
import com.cloud.api.util.algorithm.ExtractImageUtil;
import com.cloud.api.util.http.ApiUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.stream.Stream;

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
        System.out.println(ExtractColorUtil.
                getImagePixel(Objects.requireNonNull(this.getClass().getClassLoader().getResource("static")).getPath() + "/upload-image/1.jpg"));
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
    public void testJarFile() throws SchedulerException, IOException {
        JarFile jarFile = new JarFile("D:\\java1016\\just-you-api\\target\\api-0.0.1-SNAPSHOT.jar");
        final Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            System.out.println(entries.nextElement());
        }
    }

    @Test
    public void testOrgJson() throws JSONException {
        String str = "{\n" +
                "  \"vx006\": {\n" +
                "    \"result\": [\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-10-31~2020-11-07\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-10-24~2020-10-31\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-10-17~2020-10-24\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-10-10~2020-10-17\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-10-03~2020-10-10\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-09-26~2020-10-03\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-09-19~2020-09-26\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"mood\": 0,\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0,\n" +
                "        \"period\": \"2020-09-12~2020-09-19\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
        final JSONObject jsonObject = new JSONObject(str);
//        jsonObject.remove("vx006");
        System.out.println(jsonObject);
    }

    @Test
    public void testBaseToFile() {
//        String base64 = "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";
//        ExtractImageUtil.decoderBase64ToFile(base64,"C:\\Users\\HP\\Desktop\\1.jpg");
        final Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            str = scanner.nextLine();
            str = str.replace("吗", "").replace("?", "!");
            System.out.println(str);
            return;
        }
    }

    @Test
    public void testURL() throws UnsupportedEncodingException {
        System.out.println(this.getClass().getClassLoader().getResource("static").getPath());

        final String decode = URLDecoder.decode("%b7%c7%d5%fd%d1%a1%ca%b1%bc%e4%a3%a1", "utf-8");
        System.out.println(decode);
    }

    @Test
    public void testJar() throws IOException {
        final JarInputStream jarInputStream = new JarInputStream(new FileInputStream(new File("D:\\java1016\\just-you-api\\target\\api-0.0.1-SNAPSHOT.jar")));
        final JarEntry nextJarEntry = jarInputStream.getNextJarEntry();

    }
}