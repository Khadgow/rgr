package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.SellerDTO;
import com.example.bd_rgr.entity.sellerDirection.SellerEntitySD;
import com.example.bd_rgr.repository.sellerDirection.SellerRepoSD;
import com.example.bd_rgr.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController extends BasicController<SellerEntitySD, SellerRepoSD, SellerDTO, SellerService>{
    @Autowired
    public SellerController(SellerService service) {
        super(service);
    }
}

