package ir.ac.kntu.faribank.bank.client;

import java.time.LocalDateTime;
import java.util.Objects;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Double accountNumber;
    private LocalDateTime date;

    public Contact(String firstName, String lastName, String phoneNumber, Double accountNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
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

    public void setAccountNumber(String accountNumberStr) throws InvalidInputException, NumberFormatException {
        if (accountNumberStr.length() != 10) {
            throw new InvalidInputException("Account Number's digits must be 10.");
        }

        Double accountNumber = Double.parseDouble(accountNumberStr);
        this.accountNumber = accountNumber;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setDate() {
        this.date = LocalDateTime.now();;
    }

    public LocalDateTime getDate() {
        return date;
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

    @Override
    public int compareTo(Contact contact) {
        return contact.getDate().compareTo(this.date);
    }
}
