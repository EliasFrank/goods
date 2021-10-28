package com.hl.goods.dao;

import com.hl.goods.bean.Depository;
import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hl2333
 */
public interface DepositoryDao extends JpaRepository<Depository, Long>, JpaSpecificationExecutor<Depository> {
}
