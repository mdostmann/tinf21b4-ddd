package de.dhbw.tinf21b4.ddd.c_aggregates.customer;

import java.util.Objects;
import java.util.UUID;

public class CustomerAggregate {
    private UUID id;

    private CustomerNumber customerNumber;

    public CustomerAggregate(CustomerNumber customerNumber) {
        Objects.requireNonNull(customerNumber);
        this.id = UUID.randomUUID();
        this.customerNumber = customerNumber;
    }

    public UUID getId() {
        return id;
    }

    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }
}
