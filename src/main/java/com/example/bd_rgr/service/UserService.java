package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.UserCreateDTO;
import com.example.bd_rgr.dto.UserEditDTO;
import com.example.bd_rgr.entity.storeDirection.RoleEntity;
import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.repository.storeDirection.RoleRepo;
import com.example.bd_rgr.repository.storeDirection.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }
    public UserEntity create(UserCreateDTO dto) {
        var user = new UserEntity();
        if (userRepo.findByEmail(dto.getEmail()).orElse(null) != null || userRepo.findByUsername(dto.getUsername()).orElse(null) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        Collection<RoleEntity> roles = new ArrayList<>();
        dto.getRoles().forEach(x -> roles.add(roleRepo.findById(x).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"))));
        user.setRoles(roles);
        return userRepo.save(user);
    }

    public Iterable<UserEntity> getAll() {
        return userRepo.findAll();
    }

    public UserEntity getById(Integer id) {
        UserEntity entity = userRepo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        return entity;
    }

    public Integer delete(Integer id) {
        userRepo.deleteById(id);
        return id;
    }

    public UserEntity update(UserEditDTO newDto, Integer id) {
        UserEntity entity = userRepo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        if (userRepo.findByEmail(newDto.getEmail()).orElse(null) != null || userRepo.findByUsername(newDto.getUsername()).orElse(null) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        Collection<RoleEntity> roles = new ArrayList<>();
        newDto.getRoles().forEach(x -> roles.add(roleRepo.findById(x).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"))));
        entity.setUsername(newDto.getUsername());
        entity.setEmail(newDto.getEmail());
        entity.setRoles(roles);
        var newEntity = userRepo.save(entity);
        return newEntity;
    }
}
