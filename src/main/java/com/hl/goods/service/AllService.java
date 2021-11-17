package com.hl.goods.service;

import com.hl.goods.bean.All;
import com.hl.goods.dao.AllDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */
@Service
public class AllService {

    @Autowired
    private AllDao allDao;

    public List<All> findAll() {
        return allDao.findAll();
    }

    public List<All> findByNameLike(String name) {
        return allDao.findByNameLike("%" + name + "%");
    }
}
