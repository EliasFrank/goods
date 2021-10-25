package com.hl.goods.service;

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
}
