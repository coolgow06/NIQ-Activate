package com.niq.activate.service.impl;

import com.niq.activate.dto.PersonalizedProductDto;
import com.niq.activate.dto.ProductRelevancyDto;
import com.niq.activate.exceptions.BusinessException;
import com.niq.activate.jpa.ShopperRepository;
import com.niq.activate.model.ProductShopperMap;
import com.niq.activate.model.Shopper;
import com.niq.activate.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ShopperServiceImpl implements ShopperService {

    @Autowired
    ShopperRepository shopperRepository;

    @Override
    public PersonalizedProductDto getPersonalizedProducts(Integer shopperId) {
        Optional<Shopper> shopperOpt = shopperRepository.findById(shopperId);
        if(shopperOpt.isEmpty()){
            throw new BusinessException("Shopper not present in Database");
        }
        return convertToPersonalizedProductDto(shopperOpt.get().getProductShopperMap(), shopperId);
    }

    private PersonalizedProductDto convertToPersonalizedProductDto(Set<ProductShopperMap> productShopperMap, Integer shopperId){
        PersonalizedProductDto dto = new PersonalizedProductDto();
        dto.setShopperId(shopperId);
        Set<ProductRelevancyDto> prdRelevancyDto = productShopperMap.stream().map(this::convertToProductRelevancyDto).collect(Collectors.toSet());
        dto.setShelf(prdRelevancyDto);
        return dto;
    }

    private ProductRelevancyDto convertToProductRelevancyDto(ProductShopperMap map){
        ProductRelevancyDto dto = new ProductRelevancyDto();
        dto.setProductId(map.getProduct().getId());
        dto.setRelevancyScore(map.getRelevancyScore());
        return dto;
    }
}
