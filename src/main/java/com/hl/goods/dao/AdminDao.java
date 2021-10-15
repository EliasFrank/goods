package com.hl.goods.dao;

import com.hl.goods.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Long> {
}
