package com.jwt.auth.controller;


import com.jwt.auth.model.ApiResponse;
import com.jwt.auth.model.oracle.accord.TmpIdocCombineWorker;
import com.jwt.auth.service.TmpIdocCombineWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tmpIdocCombineWorker")
public class TmpIdocCombineWorkerController {

    @Autowired
    private TmpIdocCombineWorkerService tmpIdocCombineWorkerService;


    @GetMapping
    public ApiResponse<List<TmpIdocCombineWorker>> listTmpIdocCombineWorker(){
        return new ApiResponse<>(HttpStatus.OK.value(), "TmpIdocWorker fetched successfully.",
                tmpIdocCombineWorkerService.getActiveWorkerWithRegion());
    }


}
