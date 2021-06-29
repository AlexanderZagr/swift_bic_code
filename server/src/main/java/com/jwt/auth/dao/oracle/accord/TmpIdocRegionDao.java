package com.jwt.auth.dao.oracle.accord;


import com.jwt.auth.model.oracle.accord.TmpIdocRegion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpIdocRegionDao")
@Transactional(transactionManager="tmpIdocTransactionManager")
public interface TmpIdocRegionDao extends CrudRepository<TmpIdocRegion, Integer> {
    TmpIdocRegion findByNameRegion(String name);

    @Query("select b from TmpIdocRegion b ")
    List<TmpIdocRegion> getAllRegion();
}
