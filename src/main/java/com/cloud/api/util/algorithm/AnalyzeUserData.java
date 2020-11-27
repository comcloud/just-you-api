package com.cloud.api.util.algorithm;

import cn.hutool.core.io.FileUtil;
import com.cloud.api.bean.entity.Dynamic;
import com.cloud.api.bean.entity.Photo;
import com.cloud.api.bean.entity.User;
import com.cloud.api.bean.image.ColorMood;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.util.SpringUtil;
import com.cloud.api.util.http.ApiUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/22 14:44
 */
@SuppressWarnings("all")
public class AnalyzeUserData {
    private static UserMapper userMapper = (UserMapper) SpringUtil.getBean("userMapper");

    private AnalyzeUserData(){
        throw new IllegalStateException("工具类，不可创建对象");
    }

    @Async
    public static void analyze(){
        final List<User> users = userMapper.selectAllUserInfo();
        final ObjectNode node = JsonNodeFactory.instance.objectNode();
        Map<ColorMood, Integer> data = new LinkedHashMap<>();
        users.forEach(user -> {
            final List<Photo> photos = userMapper.selectAllPhoto(user.getOpenId());
            photos.forEach(photo -> analysisPicture(photo.getPhotoUrl(), data));

            //开始编辑一个新的json串
            final ObjectNode openIdNode = node.putObject(user.getOpenId());
            //用来构建result数组
            final ArrayNode result = openIdNode.putArray("result");
            //用来构建字符串
            final ObjectNode resultNode = JsonNodeFactory.instance.objectNode();
            final long sum = data.entrySet().stream().collect(Collectors.summarizingInt(Map.Entry::getValue)).getSum();
            data.forEach((key, value) -> {
                resultNode.put("color", Arrays.toString(key.getRgb()));
                resultNode.put("mood", key.getValue());
                resultNode.put("number", value);
                resultNode.put("percentage", value * 1.0 / sum + "%");
                result.add(resultNode);
            });
            //以便于下次重新构建字符串
            data.clear();
            openIdNode.put("currentLocation", photos.size());
        });
        final String path = "/home/justyou/upload-file/character/";
        new File(path, "dynamic_picture_mood.json").delete();
        new File(path, "dynamic_text_mood.json").delete();
        FileUtil.writeString(node.toPrettyString(), new File(path, "dynamic_picture_mood.json"), "utf-8");
        FileUtil.writeString(analysisText(users), new File(path, "dynamic_text_mood.json"), "utf-8");
    }

    /**
     * 解析图片然后将数据存入到指定位置
     *
     * @param url  图片地址
     * @param data 存放结果的位置
     */
    private static void analysisPicture(String url, Map<ColorMood, Integer> data) {
        try {
            ColorMood colorMood = ExtractMoodUtil.extractMoodFromRgb(ExtractColorUtil.getMainRgbByUrl(url.trim().replace("\"", "")));
            if (!data.containsKey(colorMood)) {
                data.put(colorMood, 1);
            } else {
                final Integer value = data.get(colorMood);
                data.replace(colorMood,value,value+1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 需要继续添加的内容就是每次从数据库获取内容时候都是先获取上次获取到的位置然后沿着这个位置向下查到最后
     * 分析的结果就是会不断往前推7天然后获取数据
     *
     * @param users 分析的用户列表
     * @return 分析的结果json串
     */
    private static String analysisText(List<User> users) {
        final ObjectNode node = JsonNodeFactory.instance.objectNode();
        final ObjectMapper mapper = new ObjectMapper();
        users.forEach(user -> {
            //一个用户open id的对象
            final ObjectNode openIdNode = node.putObject(user.getOpenId());
            //这个是存储结果的数组，其中放的是一个用户的每个时间段的结果
            final ArrayNode contentNode = openIdNode.putArray("result");
            /**需要不断的获取动态内容*/
            //这个当前时间是相对于上一次的时间
            LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
            for (int index = 1; index <= 8; index++) {
                final LocalDateTime previousTime = currentTime.minus(7, ChronoUnit.DAYS);
                //存储这个时期状况
                final ObjectNode arrayData = JsonNodeFactory.instance.objectNode();
                String negativeString = "negative";
                String neutral = "neutral";
                String positive = "positive";
                arrayData.put(negativeString, 0);
                arrayData.put(neutral, 0);
                arrayData.put(positive, 0);
                arrayData.put("period", previousTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "~" + currentTime.format(DateTimeFormatter.ofPattern("yyy-MM-dd")));
                List<Dynamic> dynamics = userMapper.selectDynamicFromTime(user.getOpenId(), currentTime.toString(), previousTime.toString());
                //存储计算之后的消极与积极之和
                AtomicInteger moodNumber = new AtomicInteger();
                AtomicInteger neutralNumber = new AtomicInteger();
                dynamics.forEach(dynamic -> {
                    final String dynamicContent = (String) dynamic.getDynamicContent();
                    try {
                        final JsonNode tree = mapper.readTree(ApiUtil.getEmotionalTendency(dynamicContent)).findPath("items");
                        if (tree.isArray()) {
                            //遍历百度返给的数据，包括分析结果是否积极
                            for (JsonNode obj : tree) {
                                final int sentiment = Integer.parseInt(obj.findPath("sentiment").toString());
                                switch (sentiment) {
                                    case 0:
                                        arrayData.put(negativeString, Integer.parseInt(arrayData.findPath(negativeString).toString()) + 1);
                                        moodNumber.addAndGet(-1);
                                        break;
                                    case 1:
                                        arrayData.put(neutral, Integer.parseInt(arrayData.findPath(neutral).toString()) + 1);
                                        neutralNumber.getAndIncrement();
                                        break;
                                    case 2:
                                        arrayData.put(positive, Integer.parseInt(arrayData.findPath(positive).toString()) + 1);
                                        moodNumber.addAndGet(1);
                                        break;
                                    default:
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                //这个时候要把mood值占总共的比例算出来替换mood

                arrayData.put("mood", dynamics.isEmpty() ? 0 : moodNumber.get() * 1.0 / (dynamics.size() - neutralNumber.get()));
                currentTime = previousTime;
                contentNode.add(arrayData);
            }
        });
        return node.toPrettyString();
    }

    /**
     * @param node  要判断的数组节点
     * @param color 要判断的颜色值
     */
    private boolean containsValue(ArrayNode node, String color) {
        AtomicBoolean flag = new AtomicBoolean(false);
        node.forEach(n -> {
            final boolean result = n.findPath("color").toString().equals(color);
            if (result) {
                flag.set(true);
            }
        });
        return flag.get();
    }
}
