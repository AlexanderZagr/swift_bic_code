package com.jwt.auth.dao.oracle.accord;


import com.jwt.auth.model.SwiftBicDto;
import com.jwt.auth.model.oracle.accord.SwiftFi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("swiftBicAccordDao")
@Transactional(transactionManager="tmpIdocTransactionManager")
public interface SwiftBicAccordDao extends JpaRepository<SwiftFi, String> {

     @Query("select new com.jwt.auth.model.SwiftBicDto(b.bic,b.institutionName,b.address,b.city) from SwiftFi b where b.bic LIKE CONCAT('%',:bic,'%') ")    //This is using a named query method
    List<SwiftBicDto> getSwiftCode(@Param("bic") String bic);
}
