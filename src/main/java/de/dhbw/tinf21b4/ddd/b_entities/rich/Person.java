package de.dhbw.tinf21b4.ddd.b_entities.rich;

import java.util.Objects;
import java.util.UUID;

//"rich" Person class
public class Person {

    private UUID id;
    private Name name;
    private Address address;

    public Person(UUID id, Name name, Address address) {
        Objects.requireNonNull(id);
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void changeName(Name newName) {
        this.name = newName;
    }

    public Address getAddress() {
        return address;
    }

    public void moveTo(Address newAddress) {
        this.address = newAddress;
    }
}
