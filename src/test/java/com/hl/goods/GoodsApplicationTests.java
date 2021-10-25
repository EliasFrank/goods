package com.hl.goods;

import com.hl.goods.bean.User;
import com.hl.goods.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        List<User> all = userDao.findAll();
        all.forEach(System.out::println);
    }

}
