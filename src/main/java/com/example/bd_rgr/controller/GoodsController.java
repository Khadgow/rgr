package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.GoodsDTO;
import com.example.bd_rgr.entity.storeDirection.GoodsEntity;
import com.example.bd_rgr.repository.storeDirection.GoodsRepo;
import com.example.bd_rgr.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BasicController<GoodsEntity, GoodsRepo, GoodsDTO, GoodsService>{
    @Autowired
    public GoodsController(GoodsService service) {
        super(service);
    }
}
