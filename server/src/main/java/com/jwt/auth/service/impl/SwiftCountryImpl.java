package com.jwt.auth.service.impl;

import com.jwt.auth.dao.oracle.accord.SwiftCountryDao;
import com.jwt.auth.model.oracle.accord.SwiftCountry;
import com.jwt.auth.service.SwiftCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "swiftCountryService")
public class SwiftCountryImpl implements SwiftCountryService {

    @Autowired
    @Qualifier("swiftCountryDao")
    private SwiftCountryDao swiftCountryDao;


    @Override
    public List<SwiftCountry> getSwiftCountry() {
        return swiftCountryDao.getSwiftCountry();
    }
}
