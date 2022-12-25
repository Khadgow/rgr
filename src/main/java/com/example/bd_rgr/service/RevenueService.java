package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.RevenueDTO;
import com.example.bd_rgr.dto.SellerDTO;
import com.example.bd_rgr.entity.revenueDirection.GoodsEntityRD;
import com.example.bd_rgr.entity.revenueDirection.RevenueEntityRD;
import com.example.bd_rgr.entity.revenueDirection.SellerEntityRD;
import com.example.bd_rgr.entity.sellerDirection.DepartmentEntitySD;
import com.example.bd_rgr.entity.sellerDirection.SellerEntitySD;
import com.example.bd_rgr.repository.revenueDirection.GoodsRepoRD;
import com.example.bd_rgr.repository.revenueDirection.RevenueRepoRD;
import com.example.bd_rgr.repository.revenueDirection.SellerRepoRD;
import com.example.bd_rgr.repository.sellerDirection.DepartmentRepoSD;
import com.example.bd_rgr.repository.sellerDirection.SellerRepoSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RevenueService extends BasicCRUDService<RevenueEntityRD, RevenueRepoRD, RevenueDTO> {

    private SellerRepoRD sellerRepoRD;
    private GoodsRepoRD goodsRepoRD;

    @Autowired
    RevenueService(RevenueRepoRD revenueRepoRD, SellerRepoRD sellerRepoRD, GoodsRepoRD goodsRepoRD) {
        super(revenueRepoRD);
        this.sellerRepoRD = sellerRepoRD;
        this.goodsRepoRD = goodsRepoRD;
    }

    @Override
    public RevenueEntityRD update(RevenueDTO newDto, Integer id) {
        RevenueEntityRD entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        SellerEntityRD sellerEntityRD = sellerRepoRD.findById(newDto.getSellerId()).orElse(null);
        if (sellerEntityRD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        GoodsEntityRD goodsEntityRD = goodsRepoRD.findById(newDto.getGoodsId()).orElse(null);
        if (goodsEntityRD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        var newEntity = repo.save(newDto.setToEntity(entity, sellerEntityRD, goodsEntityRD));
        return newEntity;
    }
}
