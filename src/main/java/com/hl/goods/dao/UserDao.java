package com.hl.goods.dao;

import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hl2333
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
