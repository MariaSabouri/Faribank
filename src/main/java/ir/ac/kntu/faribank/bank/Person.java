package ir.ac.kntu.faribank.bank;

import java.util.Objects;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber) throws InvalidInputException, NotFoundException {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public void setFirstName(String firstName) throws InvalidInputException {
        if (firstName.isEmpty()) {
            throw new InvalidInputException("First name is empty.");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) throws InvalidInputException {
        if (lastName.isEmpty()) {
            throw new InvalidInputException("Last name is empty.");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidInputException, NotFoundException {
        if (phoneNumber.length() != 11) {
            throw new InvalidInputException("Phone Number'length must be 11 digits.");
        } else if (!phoneNumber.matches("[0-9]{11}")) {
            throw new InvalidInputException("Phone Number should only contain digits (0-9).");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Person otherCustomer) {
            if (phoneNumber.equals(otherCustomer.getPhoneNumber()))
                return true;
        }
        return false;
    }
}
