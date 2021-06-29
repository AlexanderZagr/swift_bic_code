package com.jwt.auth.service.impl;

import com.jwt.auth.dao.oracle.accord.TmpIdocRegionDao;
import com.jwt.auth.model.oracle.accord.TmpIdocRegion;
import com.jwt.auth.service.TmpIdocRegionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "tmpIdocRegionService")
public class TmpIdocRegionImpl implements TmpIdocRegionService {

    @Autowired
    @Qualifier("tmpIdocRegionDao")
    private TmpIdocRegionDao tmpIdocRegionDao;

    @Override
    public TmpIdocRegion save(TmpIdocRegion tmpIdocRegion) {
        return  tmpIdocRegionDao.save(tmpIdocRegion);
    }

    @Override
    public List<TmpIdocRegion> findAll() {
        List<TmpIdocRegion> list = new ArrayList<>();
        tmpIdocRegionDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public void delete(int id) {
        tmpIdocRegionDao.deleteById(id);
    }

    @Override
    public TmpIdocRegion findOne(String name) {
        return tmpIdocRegionDao.findByNameRegion(name);
    }

    @Override
    public TmpIdocRegion findById(int id) {
        Optional<TmpIdocRegion> optionalTmpIdocRegion = tmpIdocRegionDao.findById(id);
        return optionalTmpIdocRegion.isPresent() ? optionalTmpIdocRegion.get() : null;
    }

    @Override
    public TmpIdocRegion update(TmpIdocRegion tmpIdocRegion) {
        TmpIdocRegion tmpIdocRegion_new = findById(tmpIdocRegion.getId());
        if(tmpIdocRegion_new != null) {
            BeanUtils.copyProperties(tmpIdocRegion, tmpIdocRegion_new);
            tmpIdocRegionDao.save(tmpIdocRegion_new);
        }
        return tmpIdocRegion_new;
    }
}
