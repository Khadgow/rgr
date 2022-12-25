package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "department", schema = "public", catalog = "chain_of_stores")
public class DepartmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private StoreEntity store;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private Collection<SellerEntity> sellers;

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

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public Collection<SellerEntity> getSellers() {
        return sellers;
    }

    public void setSellers(Collection<SellerEntity> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return getName() + ", магазин: " + getStore().getName();
    }

}
