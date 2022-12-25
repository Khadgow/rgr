package com.example.bd_rgr.repository.goodsAvailabilityDirection;

import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsEntityGAD;
import com.example.bd_rgr.entity.storeDirection.GoodsEntity;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepoGAD extends CrudRepository<GoodsEntityGAD, Integer> {
}
