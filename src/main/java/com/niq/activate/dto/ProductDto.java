package com.niq.activate.dto;

public class ProductDto {
    private Integer productId;
    private String category;
    private String brand;

    public ProductDto() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
