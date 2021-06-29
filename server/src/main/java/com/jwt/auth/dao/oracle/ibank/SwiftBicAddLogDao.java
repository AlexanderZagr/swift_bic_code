package com.jwt.auth.dao.oracle.ibank;


import com.jwt.auth.model.oracle.ibank.Swift;
import com.jwt.auth.model.oracle.ibank.SwiftAddLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("swiftBicAddLogDao")
@Transactional(transactionManager="ibankTransactionManager")
public interface SwiftBicAddLogDao extends CrudRepository<SwiftAddLog, String> {

    Swift findByBic(String bic);

    @Query("select b from SwiftAddLog b where b.bic LIKE CONCAT('%',:bic,'%') ")    //This is using a named query method
    Swift getSwiftCode(@Param("bic") String bic);
}
