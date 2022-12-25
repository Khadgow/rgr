package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.DepartmentDTO;
import com.example.bd_rgr.dto.SellerDTO;
import com.example.bd_rgr.entity.departmentDirection.DepartmentEntityDD;
import com.example.bd_rgr.entity.departmentDirection.StoreEntityDD;
import com.example.bd_rgr.entity.sellerDirection.DepartmentEntitySD;
import com.example.bd_rgr.entity.sellerDirection.SellerEntitySD;
import com.example.bd_rgr.repository.sellerDirection.DepartmentRepoSD;
import com.example.bd_rgr.repository.sellerDirection.SellerRepoSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SellerService extends BasicCRUDService<SellerEntitySD, SellerRepoSD, SellerDTO> {

    private DepartmentRepoSD departmentRepoSD;

    @Autowired
    SellerService(SellerRepoSD sellerRepo, DepartmentRepoSD departmentRepoSD) {
        super(sellerRepo);
        this.departmentRepoSD = departmentRepoSD;
    }

    @Override
    public SellerEntitySD update(SellerDTO newDto, Integer id) {
        SellerEntitySD entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        DepartmentEntitySD departmentEntitySD = departmentRepoSD.findById(newDto.getDepartmentId()).orElse(null);
        if (departmentEntitySD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        var newEntity = repo.save(newDto.setToEntity(entity, departmentEntitySD));
        return newEntity;
    }
}
