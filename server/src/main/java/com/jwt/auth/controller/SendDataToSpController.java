package com.jwt.auth.controller;

import com.jwt.auth.model.ApiResponse;
import com.jwt.auth.model.AuthToken;
import com.jwt.auth.model.LoginUser;
import com.jwt.auth.service.impl.SpMethodServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sp")
public class SendDataToSpController {

    @Autowired
    private SpMethodServiceImpl spMethodService;

    private static final String sFileData = "test\\AS_reqdata.xml";
    private static final String sFileInfo = "test\\AS_reqinfo.xml";

    final Logger logger = LoggerFactory.getLogger(SendDataToSpController.class);

    //Метод для тестирования отправки запроса на СП
    //Для тестирования есть два файла - AS_reqdata.xml и AS_reqinfo.xml
    //отправляем эти хмл в виде пост запроса на СП
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sendData", method = RequestMethod.GET,produces = { MediaType.APPLICATION_XML_VALUE  })
    public String sendDataGet() throws AuthenticationException {
        logger.debug("*************************");
        //получили хмл из файлов для тестирования
        String reqinfo=spMethodService.fileTestDataXml(sFileInfo);
        String reqdata=spMethodService.fileTestDataXml(sFileData);
        String postDataXml="AS_reqinfo="+reqinfo+"&AS_reqdata="+reqdata;
        //отправляем тестовый запрос на СП
        String response=spMethodService.InitSpConnect(postDataXml);
        //получаем ответ от СП в формате XML
        return response;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sendData", method = RequestMethod.POST,produces = { MediaType.APPLICATION_XML_VALUE })
    public String sendDataPost(@RequestBody String postDataXml) throws AuthenticationException {
        logger.debug("*************************");
        logger.debug("Отправляем запрос на СП "+postDataXml);
        //отправляем запрос на СП post "AS_reqinfo="+reqinfo+"&AS_reqdata="+reqdata"
        String response=spMethodService.InitSpConnect(postDataXml);
        logger.debug("Получаем ответ от СП "+response);
        return response;
    }
}
