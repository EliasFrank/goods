package com.hl.goods.service;

import com.hl.goods.bean.Goods;
import com.hl.goods.bean.User;
import com.hl.goods.dao.UserDao;
import com.hl.goods.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findByTel(String s) {
        return userDao.findByTel(s);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    public List<User> findByRole(int i) {
        return userDao.findByRole(i);
    }

    public List<User> findByNameLikeAndRole(String s, int i) {
        return userDao.findByNameLikeAndRole("%" + s + "%", i);
    }

    public List<User> findByGoods(List<Goods> goods) {
        List<User> users = new ArrayList<>();
        for (Goods good : goods) {
            users.add(userDao.findById(good.getUserId()).get());
        }
        return users;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
