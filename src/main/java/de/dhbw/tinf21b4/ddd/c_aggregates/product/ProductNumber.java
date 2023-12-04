package de.dhbw.tinf21b4.ddd.c_aggregates.product;

import org.apache.commons.lang3.Validate;

public record ProductNumber(String number) {

    public ProductNumber {
        Validate.notBlank(number);
    }
}
