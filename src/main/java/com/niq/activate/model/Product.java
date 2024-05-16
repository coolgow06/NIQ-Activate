package com.niq.activate.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;

    private String category;

    private String brand;

    @OneToMany(mappedBy = "product")
    private Set<ProductShopperMap> productShopperMap;

    private Product(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<ProductShopperMap> getProductShopperMap() {
        return productShopperMap;
    }

    public void setProductShopperMap(Set<ProductShopperMap> productShopperMap) {
        this.productShopperMap = productShopperMap;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", productShopperMap=" + productShopperMap +
                '}';
    }
}
