package com.example.bd_rgr.entity.sellerDirection;

import com.example.bd_rgr.entity.storeDirection.StoreEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "department", schema = "public", catalog = "chain_of_stores")
public class DepartmentEntitySD {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    private StoreEntitySD store;


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

    public StoreEntitySD getStore() {
        return store;
    }

    public void setStore(StoreEntitySD store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return getName() + ", магазин: " + getStore().getName();
    }

}
