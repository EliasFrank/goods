package com.hl.goods.UtilTest;

import com.hl.goods.GoodsApplicationTests;
import com.hl.goods.util.PasswordEncoder;
import org.junit.jupiter.api.Test;

public class UtilTest extends GoodsApplicationTests {
    @Test
    void test1() {
        System.out.println(PasswordEncoder.encode("123"));
    }

    @Test
    void test2() {
        System.out.println(PasswordEncoder.matches("11d6f48fb8427d29fe38c5090b1e7b6d", "123"));
    }
}
