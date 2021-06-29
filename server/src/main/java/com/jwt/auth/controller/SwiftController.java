package com.jwt.auth.controller;


import com.jwt.auth.model.ApiResponse;
import com.jwt.auth.model.mySql.User;
import com.jwt.auth.model.oracle.ibank.Swift;
import com.jwt.auth.model.oracle.accord.SwiftFi;
import com.jwt.auth.service.SwiftBicService;
import com.jwt.auth.service.SwiftCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/swift")
public class SwiftController {

    @Autowired
    private SwiftCountryService swiftCountryService;

    @Autowired
    private SwiftBicService swiftBicService;


    @GetMapping("/swiftCountry")
    public ApiResponse<List<SwiftFi>> listSwiftCountry(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Swift fetched successfully.",
                swiftCountryService.getSwiftCountry());
    }

    @GetMapping("/swiftBic")
    public ApiResponse<List<SwiftFi>> listSwiftBic(//пример с кодом для тестирования
                                                  //  @RequestParam(required = false, defaultValue = "ZBCGMEPGXXX") String bic){
         @RequestParam String bic){
        return new ApiResponse<>(HttpStatus.OK.value(), "Swift fetched successfully.",
                swiftBicService.getSwiftBic(bic));
    }


    @PostMapping("/addSwift")
    public ApiResponse<Swift> saveSwiftPost(@RequestBody Swift swift){
        return new ApiResponse<>(HttpStatus.OK.value(), "Swift saved successfully.",
                swiftBicService.save(swift));
    }





}
