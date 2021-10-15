package com.hl.goods.DaoTest;

import com.hl.goods.GoodsApplicationTests;
import com.hl.goods.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AllDaoTest extends GoodsApplicationTests {
    @Autowired
    AdminDao adminDao;

    @Autowired
    AllDao allDao;

    @Autowired
    DepositoryDao depositoryDao;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    NeedsDao needsDao;

    @Autowired
    UserDao userDao;

    @Test
    public void test() {
        adminDao.findAll().forEach(System.out::println);
        allDao.findAll().forEach(System.out::println);
        depositoryDao.findAll().forEach(System.out::println);
        goodsDao.findAll().forEach(System.out::println);
        needsDao.findAll().forEach(System.out::println);
        userDao.findAll().forEach(System.out::println);
    }
}
