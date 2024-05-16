package com.niq.activate.service;

import com.niq.activate.dto.ProductDto;
import com.niq.activate.exceptions.BusinessException;
import com.niq.activate.jpa.ProductRepository;
import com.niq.activate.model.Product;
import com.niq.activate.model.ProductShopperMap;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{
    @Autowired
    ProductRepository productRepository;

    public ProductDto getProduct(Integer id) {
        return productRepository.findById(id).map(this::convertToDto).orElseThrow(() ->new BusinessException("Product not found"));
    }

    public List<Product> getProductByFilters(Integer shopperId, String category, String brand, Integer limit) {
        limit = validateInput(shopperId, limit);
        Specification<Product> productSpecification = getSpecification(shopperId, category, brand, limit);
        Pageable pageLimit = PageRequest.of(0,limit);
        return productRepository.findAll(productSpecification, pageLimit).stream().toList();
    }

    private Specification<Product> getSpecification(Integer shopperId, String category, String brand, Integer limit){
        return(root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(shopperId != null){
                Join<Product, ProductShopperMap> shopperJoin = root.join("product");
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(shopperJoin.get("shopper_id"), shopperId)));
            }
            if(category != null){
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(criteriaBuilder.trim(root.get("category")), category.trim())));
            }
            if(brand != null){
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(criteriaBuilder.trim(root.get("brand")), brand.trim())));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Integer validateInput(Integer shopperId, Integer limit){
        if(shopperId == null)
            throw new BusinessException("ShopperId is Mandatory");
        if(limit == null || limit < 10)
            limit = 10;
        if (limit > 100)
            throw new BusinessException("Limit should be less than 100");
        return limit;
    }

    private ProductDto convertToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getId());
        dto.setBrand(product.getBrand());
        dto.setCategory(product.getCategory());
        return dto;
    }
}
