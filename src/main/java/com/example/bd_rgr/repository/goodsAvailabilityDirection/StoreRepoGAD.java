package com.example.bd_rgr.repository.goodsAvailabilityDirection;

import com.example.bd_rgr.entity.goodsAvailabilityDirection.StoreEntityGAD;
import com.example.bd_rgr.entity.storeDirection.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepoGAD extends CrudRepository<StoreEntityGAD, Integer> {
}
