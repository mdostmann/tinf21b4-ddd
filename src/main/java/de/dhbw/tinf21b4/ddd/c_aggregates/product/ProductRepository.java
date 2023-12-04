package de.dhbw.tinf21b4.ddd.c_aggregates.product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductAggregate> findAll();

    Optional<ProductAggregate> findByNumber(ProductNumber productNumber);

    ProductAggregate save(ProductAggregate productAggregate);
}
