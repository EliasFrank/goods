package com.hl.goods.service;

import com.hl.goods.bean.Comment;
import com.hl.goods.dao.CommentDao;
import com.hl.goods.util.TimeEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public List<Comment> findByNeedId(Integer id) {
        return commentDao.findByNeedId(id);
    }


    public void save(String editorContent, Integer id, Integer userId) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setContent(editorContent);
        comment.setCreateTime(TimeEncode.getTime());
        comment.setNeedId(id);
        commentDao.save(comment);
    }
}
