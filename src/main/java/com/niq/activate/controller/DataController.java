package com.niq.activate.controller;

import com.niq.activate.dto.PersonalizedProductDto;
import com.niq.activate.dto.ProductDto;
import com.niq.activate.service.ProductService;
import com.niq.activate.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    ShopperService shopperService;

    @Autowired
    ProductService productService;

    @GetMapping("/shopper/personalized-product-list/{shopperId}")
    public PersonalizedProductDto getPersonalizedProductList(@PathVariable Integer shopperId){
        return shopperService.getPersonalizedProducts(shopperId);
    }

    @GetMapping("/product-metadate/{productId}")
    public ProductDto getProductMetadata(@PathVariable Integer productId){
        return productService.getProduct(productId);
    }

}
