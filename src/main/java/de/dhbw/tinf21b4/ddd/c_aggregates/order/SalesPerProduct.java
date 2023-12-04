package de.dhbw.tinf21b4.ddd.c_aggregates.order;

import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.math.BigDecimal;

public record SalesPerProduct(ProductNumber productNumber, BigDecimal salesInPeriod) {
}
