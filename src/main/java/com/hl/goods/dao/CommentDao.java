package com.hl.goods.dao;

import com.hl.goods.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author hl2333
 */
public interface CommentDao  extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    /**
     * findByNeedId
     * @param id
     * @return
     */
    List<Comment> findByNeedId(Integer id);
}
