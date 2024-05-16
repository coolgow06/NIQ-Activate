package com.niq.activate.dto;

import java.util.Set;

public class PersonalizedProductDto {
    private Integer shopperId;

    private Set<ProductRelevancyDto> shelf;

    public PersonalizedProductDto() {}

    public Integer getShopperId() {
        return shopperId;
    }

    public void setShopperId(Integer shopperId) {
        this.shopperId = shopperId;
    }

    public Set<ProductRelevancyDto> getShelf() {
        return shelf;
    }

    public void setShelf(Set<ProductRelevancyDto> shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "PersonalizedProductDto{" +
                "shopperId=" + shopperId +
                ", shelf=" + shelf +
                '}';
    }
}
