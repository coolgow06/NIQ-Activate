package com.niq.activate.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Shopper")
public class Shopper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopper_id")
    private Integer id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "shopper")
    private Set<ProductShopperMap> productShopperMap;

    private Shopper() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<ProductShopperMap> getProductShopperMap() {
        return productShopperMap;
    }

    public void setProductShopperMap(Set<ProductShopperMap> productShopperMap) {
        this.productShopperMap = productShopperMap;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", productShopperMap=" + productShopperMap +
                '}';
    }
}
