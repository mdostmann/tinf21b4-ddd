package de.dhbw.tinf21b4.ddd.b_entities.rich;

import org.apache.commons.lang3.Validate;

public final class Address {
    private final String street;
    private final String city;
    private final String zipCode;

    public Address(String street, String city, String zipCode) {
        Validate.notBlank(street);
        Validate.notBlank(city);
        Validate.notBlank(zipCode);

        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        if (!street.equals(address.street)) {
            return false;
        }
        if (!city.equals(address.city)) {
            return false;
        }
        return zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }
}
