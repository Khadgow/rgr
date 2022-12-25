package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.GoodsAvailabilityDTO;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsAvailabilityEntityGAD;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsEntityGAD;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.StoreEntityGAD;
import com.example.bd_rgr.repository.goodsAvailabilityDirection.GoodsAvailabilityRepoGAD;
import com.example.bd_rgr.repository.goodsAvailabilityDirection.GoodsRepoGAD;
import com.example.bd_rgr.repository.goodsAvailabilityDirection.StoreRepoGAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GoodsAvailabilityService extends BasicCRUDService<GoodsAvailabilityEntityGAD, GoodsAvailabilityRepoGAD, GoodsAvailabilityDTO> {

    private StoreRepoGAD storeRepoGAD;
    private GoodsRepoGAD goodsRepoGAD;

    @Autowired
    GoodsAvailabilityService(GoodsAvailabilityRepoGAD goodsAvailabilityRepoGAD, StoreRepoGAD storeRepoGAD, GoodsRepoGAD goodsRepoGAD) {
        super(goodsAvailabilityRepoGAD);
        this.storeRepoGAD = storeRepoGAD;
        this.goodsRepoGAD = goodsRepoGAD;
    }

    @Override
    public GoodsAvailabilityEntityGAD update(GoodsAvailabilityDTO newDto, Integer id) {
        GoodsAvailabilityEntityGAD entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        StoreEntityGAD storeEntityGAD = storeRepoGAD.findById(newDto.getStoreId()).orElse(null);
        if (storeEntityGAD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        GoodsEntityGAD goodsEntityGAD = goodsRepoGAD.findById(newDto.getGoodsId()).orElse(null);
        if (goodsEntityGAD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        var newEntity = repo.save(newDto.setToEntity(entity, storeEntityGAD, goodsEntityGAD));
        return newEntity;
    }
}
