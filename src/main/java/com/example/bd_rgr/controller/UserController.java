package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.UserCreateDTO;
import com.example.bd_rgr.dto.UserEditDTO;
import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{

    protected final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserCreateDTO dto) {
        var newStore = service.create(dto);
        return ResponseEntity.ok(newStore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable("id") Integer id) {
        var store = service.getById(id);
        return ResponseEntity.ok(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateById(@RequestBody UserEditDTO dto, @PathVariable("id") Integer id) {
        var newStore = service.update(dto, id);
        return ResponseEntity.ok(newStore);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteSellerById(@PathVariable("id") Integer id) {
        var storeId = service.delete(id);
        return ResponseEntity.ok(storeId);
    }
}