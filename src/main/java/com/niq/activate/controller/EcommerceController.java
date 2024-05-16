package com.niq.activate.controller;

import com.niq.activate.model.Product;
import com.niq.activate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EcommerceController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/shoppers")
    public List<Product> getProductsByShoppers(@RequestParam Integer shopperId,
                                               @RequestParam(required = false) String category,
                                               @RequestParam(required = false) String brand,
                                               @RequestParam(required = false) Integer limit){
        return productService.getProductByFilters(shopperId, category, brand, limit);
    }
}
