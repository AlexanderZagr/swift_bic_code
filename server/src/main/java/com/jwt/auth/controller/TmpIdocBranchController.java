package com.jwt.auth.controller;


import com.jwt.auth.model.ApiResponse;
import com.jwt.auth.model.oracle.accord.TmpIdocDepartment;
import com.jwt.auth.service.TmpIdocDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/branches")
public class TmpIdocBranchController {

    @Autowired
    private TmpIdocDepartmentService tmpIdocDepartmentService;


    @GetMapping
    public ApiResponse<List<TmpIdocDepartment>> listTmpIdocBranches(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Branch fetched successfully.",
                tmpIdocDepartmentService.getBranches());
    }


    @PostMapping
    public ApiResponse<TmpIdocDepartment> saveTmpIdocDepartment(@RequestBody TmpIdocDepartment  tmpIdocDepartment){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",tmpIdocDepartmentService.save(tmpIdocDepartment));
    }


    @GetMapping("/{id}")
    public ApiResponse<TmpIdocDepartment> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",tmpIdocDepartmentService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<TmpIdocDepartment> update(@RequestBody TmpIdocDepartment tmpIdocDepartment) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",tmpIdocDepartmentService.update(tmpIdocDepartment));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        tmpIdocDepartmentService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }

}
