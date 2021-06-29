package com.jwt.auth.service;

import com.jwt.auth.model.SwiftBicDto;
import com.jwt.auth.model.oracle.ibank.Swift;

import java.util.List;

public interface SwiftBicService {

    List<SwiftBicDto> getSwiftBic(String bic);
    Swift findByBic(String bic);
    String save(Swift swift);

}
