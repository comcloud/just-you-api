package com.cloud.api.util.algorithm;


import cn.hutool.core.codec.Base64Decoder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/9 16:29
 */
public class ExtractImageUtil {

    /**
     * Utility classes should not have public constructors
     */
    private ExtractImageUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param base64     base64值
     * @param targetPath 图片路径
     */
    public static void decoderBase64ToFile(String base64, String targetPath) {
        decoderBase64ToFile(base64, new File(targetPath));
    }

    /**
     * @param base64     base64值
     * @param targetFile 包装图片的file
     */
    public static void decoderBase64ToFile(String base64, File targetFile) {
        final byte[] decode = Base64Decoder.decode(base64);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile))) {
            for (int i = 0; i < decode.length; i++) {
                if (decode[i] < 0) {
                    decode[i] += 256;
                }
            }
            outputStream.write(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
