package com.example.bd_rgr.entity.departmentDirection;

import com.example.bd_rgr.entity.storeDirection.GoodsAvailabilityEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "store", schema = "public", catalog = "chain_of_stores")
public class StoreEntityDD {
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
    @JsonBackReference
    private Collection<DepartmentEntityDD> departments;

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

    public Collection<DepartmentEntityDD> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<DepartmentEntityDD> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
