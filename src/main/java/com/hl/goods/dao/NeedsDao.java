package com.hl.goods.dao;

import com.hl.goods.bean.Needs;
import com.hl.goods.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author hl2333
 */
public interface NeedsDao extends JpaRepository<Needs, Integer>, JpaSpecificationExecutor<NeedsDao> {
    /**
     * 1
     * @param i i
     * @return r
     */
    List<Needs> findByChecked(int i);

    /**
     * a
     * @param i i
     * @return re
     */
    List<Needs> findBySolved(int i);

    /**
     * a
     * @param i
     * @param j
     * @return
     */
    List<Needs> findByCheckedAndSolved(int i, int j);
}
