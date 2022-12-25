package com.example.bd_rgr.repository.storeDirection;

import com.example.bd_rgr.entity.storeDirection.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String name);
    Optional<UserEntity> findByEmail(String email);
}
