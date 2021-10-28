package com.hl.goods.dao;

import com.hl.goods.bean.All;
import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hl2333
 */
public interface AllDao extends JpaRepository<All, Integer>, JpaSpecificationExecutor<All>{
}
