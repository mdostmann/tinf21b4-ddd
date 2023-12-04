package de.dhbw.tinf21b4.ddd.c_aggregates.product;

import java.math.BigDecimal;

/**
 * pretty useless factory for demonstration purposes only
 */
public class ProductFactory {

    public static ProductAggregate createProduct(ProductNumber number, String name, BigDecimal price) {
        return new ProductAggregate(number, name, price);
    }
}
