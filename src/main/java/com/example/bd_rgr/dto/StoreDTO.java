package com.example.bd_rgr.dto;

import com.example.bd_rgr.entity.storeDirection.StoreEntity;
import lombok.Data;

@Data
public class StoreDTO implements BasicDTO<StoreEntity> {
    private String name;
    private String address;
    @Override
    public StoreEntity setToEntity(StoreEntity storeEntity) {
        storeEntity.setName(name);
        storeEntity.setAddress(address);
        return storeEntity;
    }
    @Override
    public StoreEntity toEntity() {
        return setToEntity(new StoreEntity());
    }

}
