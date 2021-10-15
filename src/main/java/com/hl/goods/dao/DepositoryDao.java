package com.hl.goods.dao;

import com.hl.goods.bean.Depository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoryDao extends JpaRepository<Depository, Long> {
}
