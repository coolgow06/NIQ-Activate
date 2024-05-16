package com.niq.activate.jpa;

import com.niq.activate.model.Shopper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepository extends CrudRepository<Shopper, Integer> {
}
