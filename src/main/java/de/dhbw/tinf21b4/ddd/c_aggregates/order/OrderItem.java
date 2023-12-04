package de.dhbw.tinf21b4.ddd.c_aggregates.order;

import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductAggregate;
import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private UUID id;
    private UUID orderId;
    private UUID productId;

    private ProductNumber productNumber;

    private String productName;

    private int quantity;

    private BigDecimal singlePrice;

    public OrderItem(OrderAggregate order, ProductAggregate product, int quantity, BigDecimal singlePrice) {
        this.id = UUID.randomUUID();
        this.orderId = order.getId();
        this.productId = product.getId();
        this.productNumber = product.getProductNumber();
        this.productName = product.getName();
        this.quantity = quantity;
        this.singlePrice = singlePrice;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getProductId() {
        return productId;
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

    public BigDecimal calculateTotalPrice() {
        return this.singlePrice.multiply(BigDecimal.valueOf(quantity));
    }
}
