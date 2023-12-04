package de.dhbw.tinf21b4.ddd.c_aggregates.product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductAggregate {
    private UUID id;

    private ProductNumber productNumber;

    private String name;

    private BigDecimal price;

    public ProductAggregate(ProductNumber productNumber, String name, BigDecimal price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public ProductNumber getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
