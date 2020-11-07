package com.cloud.api.util.algorithm;

import com.cloud.api.bean.image.ColorMood;
import com.cloud.api.bean.image.Rgb;

import java.util.Map;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/3 14:53
 */
public class ExtractMoodUtil {


    /**
     * @param rgb 给定的rgb值
     * @return 对应的心情
     */
    public static ColorMood extractMoodFromRgb(Rgb rgb) {
        int[] judge = new int[ColorMood.values().length];
        final ColorMood[] values = ColorMood.values();
        for (int i = 0; i < values.length; i++) {
            int[] valueRgb = values[i].getRgb();
            int count = 0;
            count += (rgb.getRed() - valueRgb[0]) >= 0 ? rgb.getRed() - valueRgb[0] : -(rgb.getRed() - valueRgb[0]);
            count += rgb.getGreen() - valueRgb[1] >= 0 ? rgb.getGreen() - valueRgb[1] : -(rgb.getGreen() - valueRgb[1]);
            count += rgb.getBlue() - valueRgb[2] >= 0 ? rgb.getBlue() - valueRgb[2] : -(rgb.getBlue() - valueRgb[2]);
            judge[i] = count;
        }
        return values[getMin(judge)];
    }

    /**
     * @param arr 数组
     * @return 数组中最小值的下标
     */
    private static int getMin(int[] arr){
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[min]){
                min = i;
            }
        }
        return min;
    }
}
