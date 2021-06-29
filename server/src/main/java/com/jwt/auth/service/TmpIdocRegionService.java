package com.jwt.auth.service;

import com.jwt.auth.model.oracle.accord.TmpIdocRegion;

import java.util.List;

public interface TmpIdocRegionService {

    TmpIdocRegion save(TmpIdocRegion tmpIdocRegion);
    List<TmpIdocRegion> findAll();
    void delete(int id);
    TmpIdocRegion findOne(String name);
    TmpIdocRegion findById(int id);
    TmpIdocRegion update(TmpIdocRegion tmpIdocRegion);


}
