package com.example.bd_rgr.dto;


import com.example.bd_rgr.entity.sellerDirection.DepartmentEntitySD;
import com.example.bd_rgr.entity.sellerDirection.SellerEntitySD;

import lombok.Data;

import java.sql.Date;

@Data
public class SellerDTO implements BasicDTO<SellerEntitySD> {

    private String surname;

    private String name;

    private String middleName;

    private String address;

    private Date birthdate;

    private String passportId;

    private Date dateOfIssue;

    private String institution;

    private Integer departmentId;
    @Override
    public SellerEntitySD setToEntity(SellerEntitySD sellerEntity) {
        sellerEntity.setSurname(surname);
        sellerEntity.setName(name);
        sellerEntity.setMiddleName(middleName);
        sellerEntity.setAddress(address);
        sellerEntity.setBirthdate(birthdate);
        sellerEntity.setPassportId(passportId);
        sellerEntity.setDateOfIssue(dateOfIssue);
        sellerEntity.setInstitution(institution);
        return sellerEntity;
    }
    @Override
    public SellerEntitySD toEntity() {
        return setToEntity(new SellerEntitySD());
    }

    public SellerEntitySD setToEntity(SellerEntitySD sellerEntitySD, DepartmentEntitySD departmentEntitySD) {
        var entity = setToEntity(sellerEntitySD);
        entity.setDepartment(departmentEntitySD);
        return entity;
    }
}
