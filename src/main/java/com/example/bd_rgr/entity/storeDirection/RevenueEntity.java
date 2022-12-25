package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "revenue", schema = "public", catalog = "chain_of_stores")
public class RevenueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "quantity_sold", nullable = true, precision = 0)
    private Double quantitySold;

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;

    @Basic
    @Column(name = "date", nullable = true)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private GoodsEntity goods;
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private SellerEntity seller;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Double quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public SellerEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerEntity seller) {
        this.seller = seller;
    }

}
