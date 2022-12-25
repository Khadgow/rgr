package com.example.bd_rgr.dto;

import com.example.bd_rgr.entity.departmentDirection.DepartmentEntityDD;
import com.example.bd_rgr.entity.departmentDirection.StoreEntityDD;
import lombok.Data;

@Data
public class DepartmentDTO implements BasicDTO<DepartmentEntityDD> {
    private String name;
    private Integer storeId;
    @Override
    public DepartmentEntityDD toEntity() {
        DepartmentEntityDD departmentEntity = new DepartmentEntityDD();
        departmentEntity.setName(name);
        return departmentEntity;
    }
    @Override
    public DepartmentEntityDD setToEntity(DepartmentEntityDD departmentEntity) {
        departmentEntity.setName(name);
        return departmentEntity;
    }
    public DepartmentEntityDD setToEntity(DepartmentEntityDD departmentEntity, StoreEntityDD storeEntityDD) {
        departmentEntity.setName(name);
        departmentEntity.setStore(storeEntityDD);
        return departmentEntity;
    }
}
