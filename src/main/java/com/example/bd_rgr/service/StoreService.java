package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.StoreDTO;
import com.example.bd_rgr.entity.storeDirection.StoreEntity;
import com.example.bd_rgr.repository.storeDirection.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService extends BasicCRUDService<StoreEntity, StoreRepo, StoreDTO> {
    @Autowired
    StoreService(StoreRepo storeRepo) {
        super(storeRepo);
    }

}
