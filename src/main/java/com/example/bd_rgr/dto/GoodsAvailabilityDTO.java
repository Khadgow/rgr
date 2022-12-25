package com.example.bd_rgr.dto;

import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsAvailabilityEntityGAD;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsEntityGAD;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.StoreEntityGAD;
import lombok.Data;

@Data
public class GoodsAvailabilityDTO implements BasicDTO<GoodsAvailabilityEntityGAD> {
    private Double quantity;
    private Integer storeId;
    private Integer goodsId;


    @Override
    public GoodsAvailabilityEntityGAD setToEntity(GoodsAvailabilityEntityGAD goodsAvailabilityEntity) {
        goodsAvailabilityEntity.setQuantity(quantity);
        return goodsAvailabilityEntity;
    }

    @Override
    public GoodsAvailabilityEntityGAD toEntity() {
        return setToEntity(new GoodsAvailabilityEntityGAD());
    }

    public GoodsAvailabilityEntityGAD setToEntity(GoodsAvailabilityEntityGAD goodsAvailabilityEntity, StoreEntityGAD storeEntityGAD, GoodsEntityGAD goodsEntityGAD) {
        var entity = setToEntity(goodsAvailabilityEntity);
        entity.setStore(storeEntityGAD);
        entity.setGoods(goodsEntityGAD);
        return goodsAvailabilityEntity;
    }
}
