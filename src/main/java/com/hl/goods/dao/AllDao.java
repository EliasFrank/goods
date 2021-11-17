package com.hl.goods.dao;

import com.hl.goods.bean.All;
import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author hl2333
 */
public interface AllDao extends JpaRepository<All, Integer>, JpaSpecificationExecutor<All>{
    /**
     * 1
     * @param name
     * @return
     */
    List<All> findByNameLike(String name);
}
