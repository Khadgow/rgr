package com.example.bd_rgr.repository.goodsAvailabilityDirection;

import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsAvailabilityEntityGAD;
import com.example.bd_rgr.entity.storeDirection.GoodsAvailabilityEntity;
import org.springframework.data.repository.CrudRepository;

public interface GoodsAvailabilityRepoGAD extends CrudRepository<GoodsAvailabilityEntityGAD, Integer> {
}
