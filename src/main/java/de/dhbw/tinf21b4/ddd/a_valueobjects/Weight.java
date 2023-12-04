package de.dhbw.tinf21b4.ddd.a_valueobjects;

import static de.dhbw.tinf21b4.ddd.a_valueobjects.Unit.KILOGRAMS;
import static de.dhbw.tinf21b4.ddd.a_valueobjects.Unit.POUNDS;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

//classic implementation
public final class Weight  { //<-- final to inhibit inheritance
    private final BigDecimal value; // <-- final to inhibit changes after initialisation
    private final Unit unit;

    public Weight(final BigDecimal value, final Unit unit) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "Unit cannot be null");
    }

    public BigDecimal getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    //modification and conversion
    public Weight add(Weight weightToAdd) {
        return new Weight(this.value.add(weightToAdd.to(this.unit).value), this.unit);
    }

    public Weight subtract(Weight weightToSubtract) {
        return new Weight(this.value.subtract(weightToSubtract.to(this.unit).value), this.unit);
    }

    // Convert to a different unit
    public Weight to(Unit newUnit) {
        if (unit == newUnit) {
            return this;
        }

        switch (newUnit) {
            case KILOGRAMS:
                return new Weight(convertPoundsToKilograms(value), Unit.KILOGRAMS);
            case POUNDS:
                return new Weight(convertKilogramsToPounds(value), Unit.POUNDS);
            default:
                throw new IllegalArgumentException("Unknown unit");
        }
    }

    // Business logic for conversion
    private static BigDecimal convertPoundsToKilograms(BigDecimal pounds) {
        BigDecimal conversionRate = BigDecimal.valueOf(0.45359237);
        return pounds.multiply(conversionRate);
    }

    private static BigDecimal convertKilogramsToPounds(BigDecimal kilograms) {
        BigDecimal conversionRate = BigDecimal.valueOf(2.20462262);
        return kilograms.multiply(conversionRate);
    }

    // convenience
    // Factory method for kilograms
    public static Weight kilograms(BigDecimal value) {
        return new Weight(value, Unit.KILOGRAMS);
    }

    // Factory method for pounds
    public static Weight pounds(BigDecimal value) {
        return new Weight(value, Unit.POUNDS);
    }

    // usage
    public static void main(String[] args) {

        var weight = new Weight(new BigDecimal("10.0"), KILOGRAMS);
        System.out.println(weight); // Weight{value=10, unit=KILOGRAMS}

        var newWeight = weight.add(pounds(new BigDecimal("22.0462262")));
        System.out.println(newWeight); // Weight{value=20, unit=KILOGRAMS}
        System.out.println(newWeight.to(POUNDS)); // Weight{value=44, unit=POUNDS}

        new Weight(new BigDecimal("1.0"), KILOGRAMS)
                .add(kilograms(new BigDecimal("20.0")))
                .to(POUNDS)
                .subtract(pounds(BigDecimal.ONE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return value.equals(weight.value) && unit == weight.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "value=" + value.round(new MathContext(2, RoundingMode.HALF_EVEN)) +
                ", unit=" + unit +
                '}';
    }
}

