package ir.ac.kntu.faribank.bank;

import java.util.Objects;

import ir.ac.kntu.faribank.bank.client.Client;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public Person(String firstName, String lastName, String phoneNumber, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, password);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Client otherCustomer) {
            if (phoneNumber.equals(otherCustomer.getPhoneNumber()))
                return true;
            if (password.equals(otherCustomer.getPassword()))
                return true;
        }
        return false;
    }
}
