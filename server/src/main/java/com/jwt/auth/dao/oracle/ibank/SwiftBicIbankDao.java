package com.jwt.auth.dao.oracle.ibank;


import com.jwt.auth.model.oracle.ibank.Swift;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("swiftBicIbankDao")
@Transactional(transactionManager="ibankTransactionManager")
public interface SwiftBicIbankDao extends CrudRepository<Swift, String> {
    @Transactional(transactionManager="ibankTransactionManager")
    Swift findByBic(String bic);

     @Query("select b from Swift b where b.bic LIKE CONCAT('%',:bic,'%') ")    //This is using a named query method
     Swift getSwiftCode(@Param("bic") String bic);
}
