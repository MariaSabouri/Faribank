package ir.ac.kntu.faribank.bank.client;

import java.time.LocalDateTime;
import java.util.Objects;

import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public class Contact extends Person implements Comparable<Contact> {
    private String accountNumber;
    private LocalDateTime date;

    public Contact(String firstName, String lastName, String phoneNumber, String accountNumber) throws NumberFormatException, InvalidInputException, NotFoundException {
        super(firstName, lastName, phoneNumber);
        setAccountNumber(accountNumber);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) throws InvalidInputException, NotFoundException {
        if (!FariBank.getInstance().getClients().contains(new Client(phoneNumber, "K@2k", "-", "-", "-"))) {
            throw new NotFoundException("This Phone number has not a FariBank account yet.");
        } else if (HomeController.getClient().getPhoneNumber().equals(phoneNumber)) {
            throw new InvalidInputException("You can't add your account info.");
        } 

        super.setPhoneNumber(phoneNumber);
    }

    public void setAccountNumber(String accountNumber) throws InvalidInputException, NotFoundException {
        if (accountNumber.length() != 10) {
            throw new InvalidInputException("Account Number's digits must be 10.");
        }

        for (Client client : FariBank.getInstance().getClients()) {
            if (client.getAccountNumber().equals(accountNumber)) {
                this.accountNumber = accountNumber;
                return;
            }
        }
        
        throw new NotFoundException("Account Number does not exist in FariBank.");
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
        return Objects.hash(super.hashCode(), accountNumber, date);
    }

    @Override
    public String toString() {
        return "Contact{" +
        "\nfirstName: " + getFirstName() +
        "\nlastName: " + getLastName() +
        "\nphoneNumber: '" + getPhoneNumber() +
        "\'\naccountNumber: " + getAccountNumber() +
        "\n\ndate: " + getDate() +
        "\'\n}";
    }

    @Override
    public int compareTo(Contact contact) {
        return contact.getDate().compareTo(this.date);
    }
}
