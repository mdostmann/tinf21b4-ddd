package de.dhbw.tinf21b4.ddd.c_aggregates.order;

import de.dhbw.tinf21b4.ddd.c_aggregates.customer.CustomerAggregate;
import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductAggregate;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class OrderAggregate {
    private UUID id;
    private UUID customerId;
    private List<OrderItem> orderItems;

    public OrderAggregate(Builder builder) {
        this.id = UUID.randomUUID();
        this.customerId = builder.customerId;
        this.orderItems = Collections.emptyList();
        addOrderItem(builder.product, builder.quantity, builder.price);
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    /**
     * returns defensive copy
     */
    public List<OrderItemSummary> getOrderItems() {
        return this.orderItems.stream().map(OrderItemSummary::createFrom).toList();
    }

    public void addOrderItem(ProductAggregate productAggregate, int quantity, BigDecimal singlePrice) {
        this.orderItems.add( new OrderItem(this, productAggregate, quantity, singlePrice));
    }

    public void deleteOrderItem(int posNo) {
        if(this.orderItems.size() == 1) {
            throw new IllegalStateException("order needs at least one item");
        }
        //if order does not contain posNo -> Exception
        ///implement deletion logic
    }

    public static class Builder {
        private UUID customerId;

        private ProductAggregate product;

        private int quantity;

        private BigDecimal price;

        public Builder(CustomerAggregate customer) {
            this.customerId = customer.getId();
        }

        public Builder product(ProductAggregate product) {
            this.product = product;
            this.price = product.getPrice();
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder singlePrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderAggregate build() {
            return new OrderAggregate(this);
        }
    }
}
