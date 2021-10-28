package com.hl.goods.dao;

import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author hl2333
 */
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    /**
     * 返回用户信息
     * @param tel 手机号
     * @return 用户
     */
    User findByTel(String tel);

    /**
     * 查询
     * @param role 用户信息
     * @return 用户
     */
    List<User> findByRole(int role);


    /**
     * @param name name
     * @param role role
     * @return r
     */
    List<User> findByNameLikeAndRole(String name, int role);
}
