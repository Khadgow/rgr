package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.DepartmentDTO;
import com.example.bd_rgr.entity.departmentDirection.DepartmentEntityDD;
import com.example.bd_rgr.entity.departmentDirection.StoreEntityDD;
import com.example.bd_rgr.repository.departmentDirection.DepartmentRepoDD;
import com.example.bd_rgr.repository.departmentDirection.StoreRepoDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepartmentService extends BasicCRUDService<DepartmentEntityDD, DepartmentRepoDD, DepartmentDTO> {
    private StoreRepoDD storeRepoDD;
    @Autowired
    DepartmentService(DepartmentRepoDD departmentRepoDD, StoreRepoDD storeRepoDD) {
        super(departmentRepoDD);
        this.storeRepoDD = storeRepoDD;
    }

    @Override
    public DepartmentEntityDD update(DepartmentDTO newDto, Integer id) {
        DepartmentEntityDD entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        StoreEntityDD store = storeRepoDD.findById(newDto.getStoreId()).orElse(null);
        if (store == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        var newEntity = repo.save(newDto.setToEntity(entity, store));
        return newEntity;
    }


}
