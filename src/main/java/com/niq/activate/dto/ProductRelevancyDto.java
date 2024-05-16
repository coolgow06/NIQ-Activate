package com.niq.activate.dto;

public class ProductRelevancyDto {
    private Integer productId;
    private Double relevancyScore;

    public ProductRelevancyDto() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    @Override
    public String toString() {
        return "ProductRelevancyDto{" +
                "productId=" + productId +
                ", relevancyScore=" + relevancyScore +
                '}';
    }
}
