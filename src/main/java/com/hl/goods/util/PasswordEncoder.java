package com.hl.goods.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author hl2333
 */
@Component
public class PasswordEncoder {
    private static String slat = "fewfawfweaf";
    public static String encode(String text) {
        String md5str = DigestUtils.md5Hex(text + slat);
        return md5str;
    }

    public static boolean matches(String s, String origin) {
        return s.equalsIgnoreCase(encode(origin));
    }
}
