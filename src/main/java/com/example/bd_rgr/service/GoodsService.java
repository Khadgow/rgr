package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.GoodsDTO;
import com.example.bd_rgr.entity.storeDirection.GoodsEntity;
import com.example.bd_rgr.repository.storeDirection.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BasicCRUDService<GoodsEntity, GoodsRepo, GoodsDTO> {

    @Autowired
    GoodsService(GoodsRepo goodsRepo) {
        super(goodsRepo);
    }
}
