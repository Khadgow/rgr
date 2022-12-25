package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.RevenueDTO;
import com.example.bd_rgr.entity.revenueDirection.RevenueEntityRD;
import com.example.bd_rgr.repository.revenueDirection.RevenueRepoRD;
import com.example.bd_rgr.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revenues")
public class RevenueController extends BasicController<RevenueEntityRD, RevenueRepoRD, RevenueDTO, RevenueService>{
    @Autowired
    public RevenueController(RevenueService service) {
        super(service);
    }
}
