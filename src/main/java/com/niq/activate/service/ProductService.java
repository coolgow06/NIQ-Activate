package com.niq.activate.service;

import com.niq.activate.dto.ProductDto;
import com.niq.activate.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto getProduct(Integer id);
    List<Product> getProductByFilters(Integer shopperId, String category, String brand, Integer limit);
}
