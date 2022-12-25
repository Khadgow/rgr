package com.example.bd_rgr.dto;

import com.example.bd_rgr.entity.revenueDirection.GoodsEntityRD;
import com.example.bd_rgr.entity.revenueDirection.RevenueEntityRD;
import com.example.bd_rgr.entity.revenueDirection.SellerEntityRD;
import com.example.bd_rgr.entity.storeDirection.RevenueEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class RevenueDTO implements BasicDTO<RevenueEntityRD> {

    private Double quantitySold;

    private Double price;

    private Date date;

    private Integer sellerId;
    private Integer goodsId;

    @Override
    public RevenueEntityRD setToEntity(RevenueEntityRD revenueEntity) {
        revenueEntity.setQuantitySold(quantitySold);
        revenueEntity.setPrice(price);
        revenueEntity.setDate(date);
        return revenueEntity;
    }

    @Override
    public RevenueEntityRD toEntity() {
        return setToEntity(new RevenueEntityRD());
    }
    public RevenueEntityRD setToEntity(RevenueEntityRD revenueEntity, SellerEntityRD sellerEntityRD, GoodsEntityRD goodsEntityRD) {
        var newRevenueEntity = setToEntity(revenueEntity);
        newRevenueEntity.setSeller(sellerEntityRD);
        newRevenueEntity.setGoods(goodsEntityRD);
        return revenueEntity;
    }
}
