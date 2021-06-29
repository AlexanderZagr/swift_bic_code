package com.jwt.auth.dao.oracle.accord;


import com.jwt.auth.model.oracle.accord.SwiftCountry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("swiftCountryDao")
@Transactional(transactionManager="tmpIdocTransactionManager")
public interface SwiftCountryDao extends CrudRepository<SwiftCountry, Integer> {

    @Query("select b from SwiftCountry b order by name")    //This is using a named query method
    List<SwiftCountry> getSwiftCountry();
}
