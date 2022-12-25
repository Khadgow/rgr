package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "goods", schema = "public", catalog = "chain_of_stores")
public class GoodsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;

    @Basic
    @Column(name = "unit", nullable = true, length = 255)
    private String unit;

    @OneToMany(mappedBy = "goods")
    @JsonBackReference
    private Collection<GoodsAvailabilityEntity> goodsAvailabilities;
    @OneToMany(mappedBy = "goods")
    @JsonBackReference
    private Collection<RevenueEntity> revenues;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Collection<GoodsAvailabilityEntity> getGoodsAvailabilities() {
        return goodsAvailabilities;
    }

    public void setGoodsAvailabilities(Collection<GoodsAvailabilityEntity> goodsAvailabilities) {
        this.goodsAvailabilities = goodsAvailabilities;
    }

    public Collection<RevenueEntity> getRevenues() {
        return revenues;
    }

    public void setRevenues(Collection<RevenueEntity> revenues) {
        this.revenues = revenues;
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice() + "/" + getUnit();
    }

}
