package de.dhbw.tinf21b4.ddd.c_aggregates.product.command;

import de.dhbw.tinf21b4.ddd.c_aggregates.product.ProductNumber;
import java.math.BigDecimal;
import java.util.Objects;
import org.apache.commons.lang3.Validate;

public record CreateProductCommand(ProductNumber number, String name, BigDecimal price) {

    public CreateProductCommand {
        Objects.requireNonNull(number);
        Validate.notBlank(name);
    }
}
