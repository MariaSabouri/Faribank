package ir.ac.kntu.faribank.bank.client;

import java.util.Objects;

import ir.ac.kntu.faribank.bank.Person;

public class Client extends Person {
    private String nationalCodeID;
    private String adminAuthenText;
    private String cardNumber;
    private String accountNumber;

    public Client(String phoneNumber, String password, String firstName, String lastName,  String nationalCodeID) {
        super(firstName, lastName, phoneNumber, password);
        setNationalCodeID(nationalCodeID);
    }

    public void setNationalCodeID(String nationalCodeID) {
        this.nationalCodeID = nationalCodeID;
    }

    public String getNationalCodeID() {
        return nationalCodeID;
    }

    public void setAdminAuthenText(String adminAuthenText) {
        this.adminAuthenText = adminAuthenText;
    }

    public String getAdminAuthenText() {
        return adminAuthenText;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nationalCodeID, adminAuthenText, cardNumber, accountNumber);
    }

    // @Override
    // public boolean equals(Object other) {
    //     if (this == other)
    //         return true;
    //     if (other == null || getClass() != other.getClass())
    //         return false;
    //     if (other instanceof Client otherCustomer) {
    //         if (getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
    //             return true;
    //         if (getPassword().equals(otherCustomer.getPassword()))
    //             return true;
    //     }
    //     return false;
    // }

    @Override
    public String toString() {
        return "Client{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nnationalCodeID: '" + getNationalCodeID() +
                "\'\nadminAuthenText: '" + getAdminAuthenText() +
                "\'\ncardNumber: '" + getCardNumber() +
                "\'\naccountNumber: '" + getAccountNumber() +
                "\'\n}";
    }
}
