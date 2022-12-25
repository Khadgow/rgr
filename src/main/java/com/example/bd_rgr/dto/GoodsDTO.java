package com.example.bd_rgr.dto;

import com.example.bd_rgr.entity.storeDirection.GoodsEntity;
import lombok.Data;

@Data
public class GoodsDTO implements BasicDTO<GoodsEntity> {
    private String name;

    private Double price;

    private String unit;

    @Override
    public GoodsEntity setToEntity(GoodsEntity goodsEntity) {
        goodsEntity.setName(name);
        goodsEntity.setPrice(price);
        goodsEntity.setUnit(unit);
        return goodsEntity;
    }

    @Override
    public GoodsEntity toEntity() {
        return setToEntity(new GoodsEntity());
    }
}
