package com.niq.activate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product_Shopper_Map")
public class ProductShopperMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_shopper_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;

    private Double relevancyScore;

    private ProductShopperMap() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    @Override
    public String toString() {
        return "ProductShopperMap{" +
                "id=" + id +
                ", product=" + product +
                ", shopper=" + shopper +
                ", relevancyScore=" + relevancyScore +
                '}';
    }
}
