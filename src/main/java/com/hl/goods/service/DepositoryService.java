package com.hl.goods.service;

import com.hl.goods.bean.Depository;
import com.hl.goods.dao.DepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hl2333
 */
@Service
public class DepositoryService {
    @Autowired
    private DepositoryDao depositoryDao;

    public Depository findById(int i) {
        return depositoryDao.findById(i).get();
    }

    public void save(Depository depository) {
        depositoryDao.save(depository);
    }

    public List<Depository> findAll() {
        return depositoryDao.findAll();
    }
}
