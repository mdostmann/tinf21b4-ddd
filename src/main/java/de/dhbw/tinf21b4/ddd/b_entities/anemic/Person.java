package de.dhbw.tinf21b4.ddd.b_entities.anemic;

import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.Validate;

//"anemic" Person class
public class Person {
    private UUID id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zipCode;

    public Person(UUID id, String firstName, String lastName, String street, String city, String zipCode) {
        Objects.requireNonNull(id);
        Validate.notBlank(firstName);
        Validate.notBlank(lastName);
        Validate.notBlank(street);
        Validate.notBlank(city);
        Validate.notBlank(zipCode);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    //getters and setters....
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        Validate.notBlank(firstName);
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Person setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Person setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Person setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
