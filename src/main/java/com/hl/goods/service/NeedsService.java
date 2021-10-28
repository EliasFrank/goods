package com.hl.goods.service;

import com.hl.goods.bean.Needs;
import com.hl.goods.dao.NeedsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */
@Service
public class NeedsService {

    @Autowired
    private NeedsDao needsDao;

    public List<Needs> findChecked(int i) {
        return needsDao.findByChecked(i);
    }

    public List<Needs> findAll() {
        return needsDao.findAll();
    }

    public List<Needs> getAllByStatus(Integer check, Integer solved) {
        if (check < 0 && solved < 0) {
            return needsDao.findAll();
        } else if (check < 0) {
            return needsDao.findBySolved(solved);
        } else if (solved < 0) {
            return needsDao.findByChecked(check);
        } else {
            return needsDao.findByCheckedAndSolved(check, solved);
        }
    }

    public Needs findById(Integer id) {
        return needsDao.findById(id).get();
    }

    public void save(Needs need) {
        needsDao.save(need);
    }
}
