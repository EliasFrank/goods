package com.hl.goods.dao;

import com.hl.goods.bean.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods, Long> {
}
