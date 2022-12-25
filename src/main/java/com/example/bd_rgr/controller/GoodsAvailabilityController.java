package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.GoodsAvailabilityDTO;
import com.example.bd_rgr.entity.goodsAvailabilityDirection.GoodsAvailabilityEntityGAD;
import com.example.bd_rgr.repository.goodsAvailabilityDirection.GoodsAvailabilityRepoGAD;
import com.example.bd_rgr.service.GoodsAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsAvailability")
public class GoodsAvailabilityController extends BasicController<GoodsAvailabilityEntityGAD, GoodsAvailabilityRepoGAD, GoodsAvailabilityDTO, GoodsAvailabilityService> {
    @Autowired
    public GoodsAvailabilityController(GoodsAvailabilityService service) {
        super(service);
    }
}
