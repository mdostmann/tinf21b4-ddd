package de.dhbw.tinf21b4.ddd.c_aggregates.order;

import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.math.BigDecimal;

/**
 * "read model"
 */
public final class OrderItemSummary {

    private final ProductNumber productNumber;

    private final String productName;

    private final int quantity;

    private final BigDecimal singlePrice;

    private final BigDecimal totalPrice;

    public OrderItemSummary(ProductNumber productNumber, String productName, int quantity, BigDecimal singlePrice, BigDecimal totalPrice) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.quantity = quantity;
        this.singlePrice = singlePrice;
        this.totalPrice = totalPrice;
    }

    public ProductNumber getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public static OrderItemSummary createFrom(OrderItem item) {
        return new OrderItemSummary(item.getProductNumber(), item.getProductName(), item.getQuantity(), item.getSinglePrice(), item.calculateTotalPrice());
    }
}
