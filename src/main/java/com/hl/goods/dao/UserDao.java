package com.hl.goods.dao;

import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hl2333
 */
public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 返回用户信息
     * @param tel 手机号
     * @return 用户
     */
    User findByTel(String tel);
}
