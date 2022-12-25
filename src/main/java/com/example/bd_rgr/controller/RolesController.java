package com.example.bd_rgr.controller;

import com.example.bd_rgr.entity.storeDirection.RoleEntity;
import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.repository.storeDirection.RoleRepo;
import com.example.bd_rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {

    protected final RoleRepo roleRepo;
    @Autowired
    public RolesController(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @GetMapping
    public ResponseEntity<Iterable<RoleEntity>> getAll() {
        return ResponseEntity.ok(roleRepo.findAll());
    }
}
