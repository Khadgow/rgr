package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "store", schema = "public", catalog = "chain_of_stores")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference
    private Collection<DepartmentEntity> departments;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference
    private Collection<GoodsAvailabilityEntity> goodsAvailabilities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public Collection<GoodsAvailabilityEntity> getGoodsAvailabilities() {
        return goodsAvailabilities;
    }

    public void setGoodsAvailabilities(Collection<GoodsAvailabilityEntity> goodsAvailabilities) {
        this.goodsAvailabilities = goodsAvailabilities;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
