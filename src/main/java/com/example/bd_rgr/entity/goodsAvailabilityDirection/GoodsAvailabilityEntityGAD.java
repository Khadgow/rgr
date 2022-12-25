package com.example.bd_rgr.entity.goodsAvailabilityDirection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "goods_availability", schema = "public", catalog = "chain_of_stores")
public class GoodsAvailabilityEntityGAD {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "quantity", nullable = true, precision = 0)
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private StoreEntityGAD store;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private GoodsEntityGAD goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public StoreEntityGAD getStore() {
        return store;
    }

    public void setStore(StoreEntityGAD store) {
        this.store = store;
    }

    public GoodsEntityGAD getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntityGAD goods) {
        this.goods = goods;
    }
}
