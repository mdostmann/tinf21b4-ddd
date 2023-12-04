package de.dhbw.tinf21b4.ddd.c_aggregates.product.query;

import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.util.Objects;

public record FindProductByNumberQuery(ProductNumber productNumber) {

    public FindProductByNumberQuery {
        Objects.requireNonNull(productNumber);
    }
}
