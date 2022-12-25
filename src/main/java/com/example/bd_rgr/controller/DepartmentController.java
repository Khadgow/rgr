package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.DepartmentDTO;
import com.example.bd_rgr.entity.departmentDirection.DepartmentEntityDD;
import com.example.bd_rgr.repository.departmentDirection.DepartmentRepoDD;
import com.example.bd_rgr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController extends BasicController<DepartmentEntityDD, DepartmentRepoDD, DepartmentDTO, DepartmentService>{
    @Autowired
    public DepartmentController(DepartmentService service) {
        super(service);
    }
}

