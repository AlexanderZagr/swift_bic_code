package com.jwt.auth.controller;


import com.jwt.auth.model.ApiResponse;
import com.jwt.auth.model.oracle.accord.TmpIdocRegion;
import com.jwt.auth.service.TmpIdocRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/regions")
public class TmpIdocRegionController {

    @Autowired
    private TmpIdocRegionService tmpIdocRegionService;


    @GetMapping
    public ApiResponse<List<TmpIdocRegion>> listTmpIdocRegion(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Regions fetched successfully.",
                tmpIdocRegionService.findAll());
    }


    @PostMapping
    public ApiResponse<TmpIdocRegion> saveTmpIdocRegion(@RequestBody TmpIdocRegion tmpIdocRegion){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",tmpIdocRegionService.save(tmpIdocRegion));
    }


    @GetMapping("/{id}")
    public ApiResponse<TmpIdocRegion> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(),
                "User fetched successfully.",tmpIdocRegionService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<TmpIdocRegion> update(@RequestBody TmpIdocRegion tmpIdocRegion) {
        return new ApiResponse<>(HttpStatus.OK.value(),
                "User updated successfully.",tmpIdocRegionService.update(tmpIdocRegion));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        tmpIdocRegionService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Region deleted successfully.", null);
    }

}
