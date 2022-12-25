package com.example.bd_rgr.repository.storeDirection;

import com.example.bd_rgr.entity.storeDirection.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);
}
