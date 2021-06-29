package com.jwt.auth.dao.oracle.accord;


import com.jwt.auth.model.oracle.accord.TmpIdocCombineWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpIdocCombineWorkerDao")
@Transactional(transactionManager="tmpIdocTransactionManager")
public interface TmpIdocCombineWorkerDao extends CrudRepository<TmpIdocCombineWorker, String> {

    @Query("select a" +
           // " from TmpIdocCombineWorker a where a.codeIspro=37 ")
            " from TmpIdocCombineWorker a,TmpIdocDepartment b,TmpIdocPosition c " +
            " where a.codeIspro=b.codeIspro and a.codeDolIspro=c.codePosition " +
            " and a.wrDtuvl is null and a.branchCode=2 " +
            " order by b.orderCode,c.orderCode ")

    List<TmpIdocCombineWorker> getTmpIdocCombineWokerWithRegion();
}
