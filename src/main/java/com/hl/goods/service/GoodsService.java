package com.hl.goods.service;

import com.hl.goods.bean.Goods;
import com.hl.goods.bean.User;
import com.hl.goods.dao.GoodsDao;
import com.hl.goods.dao.UserDao;
import com.hl.goods.util.TimeEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    public Goods findById(Integer id) {
        return goodsDao.findById(id).get();
    }

    public void goodCheck(Integer id) {
        Goods goods = goodsDao.findById(id).get();
        goods.setRec(1);
        goodsDao.save(goods);
    }

    public List<Goods> findByName(String username) {
        List<Goods> goods = new ArrayList<>();
        List<User> users = userDao.findByNameLike("%" + username + "%");
        for (User user : users) {
//            System.out.println(user);
            goods.addAll(goodsDao.findByUserId(user.getId()));
        }
        return goods;
    }

    public void save(Goods good, User user) {
        good.setRec(0);
        good.setCreateTime(TimeEncode.getTime());
        good.setUserId(user.getId());
        goodsDao.save(good);
    }
}
