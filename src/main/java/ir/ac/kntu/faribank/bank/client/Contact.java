package ir.ac.kntu.faribank.bank.client;

import java.time.LocalDateTime;
import java.util.Objects;

import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String accountNumber;
    private LocalDateTime date;

    public Contact(String firstName, String lastName, String phoneNumber, String accountNumber) throws NumberFormatException, InvalidInputException, NotFoundException {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAccountNumber(accountNumber);
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

    public void setPhoneNumber(String phoneNumber) throws InvalidInputException, NotFoundException {
        if (phoneNumber.length() != 11) {
            throw new InvalidInputException("Phone Number'length must be 11 digits.");
        } else if (!phoneNumber.matches("[0-9]{11}")) {
            throw new InvalidInputException("Phone Number should only contain digits (0-9).");
        } else if (!FariBank.getInstance().getClients().contains(new Client(phoneNumber, "", "", "", ""))) {
            throw new NotFoundException("This Phone number has not a FariBank account yet.");
        } else if (HomeController.getClient().getPhoneNumber().equals(phoneNumber)) {
            throw new InvalidInputException("You can't add your account info.");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) throws InvalidInputException {
        if (accountNumber.length() != 10) {
            throw new InvalidInputException("Account Number's digits must be 10.");
        }

        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
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
        if (other instanceof Contact otherCustomer) {
            if (phoneNumber.equals(otherCustomer.getPhoneNumber()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Contact{" +
        "\nfirstName: " + firstName +
        "\nlastName: " + lastName +
        "\nphoneNumber: '" + phoneNumber +
        "\'\naccountNumber: " + accountNumber +
        "\n\ndate: " + date +
        "\'\n}";
    }

    @Override
    public int compareTo(Contact contact) {
        return contact.getDate().compareTo(this.date);
    }
}
