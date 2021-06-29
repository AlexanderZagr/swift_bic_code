package com.jwt.auth.service.impl;

import com.jwt.auth.dao.oracle.accord.TmpIdocCombineWorkerDao;
import com.jwt.auth.model.oracle.accord.TmpIdocCombineWorker;
import com.jwt.auth.service.TmpIdocCombineWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tmpIdocCombineWorkerService")
public class TmpIdocCombineWorkerImpl implements TmpIdocCombineWorkerService {

    @Autowired
    @Qualifier("tmpIdocCombineWorkerDao")
    private TmpIdocCombineWorkerDao tmpIdocCombineWorkerDao;


    @Override
    public List<TmpIdocCombineWorker> getActiveWorkerWithRegion() {
        return tmpIdocCombineWorkerDao.getTmpIdocCombineWokerWithRegion();
    }
}
