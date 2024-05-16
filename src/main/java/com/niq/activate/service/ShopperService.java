package com.niq.activate.service;

import com.niq.activate.dto.PersonalizedProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ShopperService {
    PersonalizedProductDto getPersonalizedProducts(Integer shopperId);
}
