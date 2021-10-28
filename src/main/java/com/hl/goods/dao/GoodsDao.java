package com.hl.goods.dao;

import com.hl.goods.bean.Goods;
import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hl2333
 */
public interface GoodsDao extends JpaRepository<Goods, Integer>, JpaSpecificationExecutor<Goods> {
}
