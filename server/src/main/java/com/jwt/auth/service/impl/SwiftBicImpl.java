package com.jwt.auth.service.impl;

import com.jwt.auth.controller.AuthenticationController;
import com.jwt.auth.dao.oracle.accord.SwiftBicAccordDao;
import com.jwt.auth.dao.oracle.ibank.SwiftBicAddLogDao;
import com.jwt.auth.dao.oracle.ibank.SwiftBicIbankDao;
import com.jwt.auth.model.SwiftBicDto;
import com.jwt.auth.model.oracle.ibank.Swift;
import com.jwt.auth.model.oracle.ibank.SwiftAddLog;
import com.jwt.auth.service.SwiftBicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "swiftBicService")
public class SwiftBicImpl implements SwiftBicService {
    final Logger logger = LoggerFactory.getLogger(SwiftBicImpl.class);

    @Autowired
    @Qualifier("swiftBicAccordDao")
    private SwiftBicAccordDao swiftBicAccordDao;

    @Autowired
    @Qualifier("swiftBicIbankDao")
    private SwiftBicIbankDao swiftBicIbankDao;


    @Autowired
    @Qualifier("swiftBicAddLogDao")
    private SwiftBicAddLogDao swiftBicAddLogDao;



    @Override
    public List<SwiftBicDto> getSwiftBic(String bic) {
        return swiftBicAccordDao.getSwiftCode(bic);
    }

    @Override
    public Swift findByBic(String bic) {
        return swiftBicIbankDao.findByBic(bic);
    }

    @Override
    public String save(Swift swift) {
        String result="";
        Swift checkSwift=findByBic(swift.getBic());

        String resultCheckBic="";
        try{
            resultCheckBic= checkSwift.getBic();
        } catch (Exception e){
            resultCheckBic="";
        }
        logger.debug("*************************");
        logger.debug("Проверили есть ли такой код в клиент-банке "+swift.getBic());

        if (resultCheckBic!="") {
            result="Такий код BIC - "+swift.getBic()+" ВЖЕ Є У КЛІЄНТ_БАНКУ = "+swift.getName();
          } else {
            SwiftAddLog swiftAddLog = new SwiftAddLog();
            swiftAddLog.setDataAdd(new Date());
            swiftAddLog.setUserAdd("");
            swiftAddLog.setBic(swift.getBic());
            swiftAddLog.setName(swift.getName());
            swiftAddLog.setAddress(swift.getAddress());
            swiftAddLog.setCity(swift.getCity());
            swiftAddLog.setCountryCode(swift.getCountryCode());
            try {
                swiftBicIbankDao.save(swift);
                result="В кліент-банк додано код BIC - "+swift.getBic();
            } catch (Exception e){
                result="Помилка додавання коду "+e;
            }
            try {
                swiftBicAddLogDao.save(swiftAddLog);
                } catch (Exception e){
                logger.debug("Ошибка добавления в лог таблицу = "+swift.getBic());
            }

        }
        logger.debug(result+" = "+swift.getBic());
        return result;
    }

}
