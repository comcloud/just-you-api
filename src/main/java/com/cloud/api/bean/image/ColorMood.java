package com.cloud.api.bean.image;

/**
 * 最近心情状态
 * 性格测试
 * 定义颜色和心情的枚举类
 *
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/3 13:14
 */
public enum ColorMood {
    /**
     * 红色
     */
    RED("健康、热情、希望", new int[]{255, 0, 0},"红色"),
    /**
     * 橙色
     */
    ORANGE("华美、温和、欢喜", new int[]{255, 165, 0},"橙色"),
    /**
     * 黄色
     */
    YELLOW("温和、快活、希望", new int[]{255, 255, 0},"黄色"),
    /**
     * 紫色
     */
    PURPLE("华丽、优雅、神秘", new int[]{255, 0, 255},"紫色"),
    /**
     * 白色
     */
    WHITE("纯洁、清爽、洁净", new int[]{255, 255, 255},"白色"),
    /**
     * 金色
     */
    GOLD("光荣、华贵、辉煌", new int[]{255, 215, 0},"金色"),
    /**
     * 绿色
     */
    GREEN("青春、和平、朝气", new int[]{0, 255, 0},"绿色"),
    /**
     * 青色
     */
    CYAN("希望、坚强、庄重", new int[]{0, 255, 255},"青色"),
    /**
     * 蓝色
     */
    BLUE("清新、永恒、理智、深远", new int[]{0, 0, 255},"蓝色"),
    /**
     * 褐色
     */
    BROWN("严肃、浑厚、温暖", new int[]{165, 42, 42},"褐色"),
    /**
     * 灰色
     */
    GREY("平静、稳重、朴素", new int[]{128, 128, 128},"灰色"),
    /**
     * 黑色
     */
    BLACK("静寂、严肃、刚健", new int[]{0, 0, 0},"黑色");


    /**
     * 心情状态
     */
    private String value;

    /**
     * 颜色对应的rgb值
     */
    private int[] rgb;

    /**
     * 颜色
     */
    private String color;

    ColorMood(String value, int[] rgb,String color) {
        this.value = value;
        this.rgb = rgb;
        this.color = color;
    }

    public int[] getRgb() {
        return rgb;
    }

    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }
}
