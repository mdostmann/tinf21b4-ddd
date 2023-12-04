package de.dhbw.tinf21b4.ddd.b_entities.rich;

import org.apache.commons.lang3.Validate;

public final class Name {

    private final String firstName;

    private final String lastName;

    public Name(final String firstName, final String lastName) {
        Validate.notBlank(firstName);
        Validate.notBlank(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name name = (Name) o;

        if (!firstName.equals(name.firstName)) {
            return false;
        }
        return lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
