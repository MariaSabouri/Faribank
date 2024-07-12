package ir.ac.kntu.faribank.bank.client;

import java.util.Objects;

import ir.ac.kntu.faribank.bank.Person;

public class Client extends Person {
    private String nationalCodeID;
    private String aminAuthenText;

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

    public void setAminAuthenText(String aminAuthenText) {
        this.aminAuthenText = aminAuthenText;
    }

    public String getAminAuthenText() {
        return aminAuthenText;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nnationalCodeID: '" + getNationalCodeID() +
                "\'\naminAuthenText: '" + getAminAuthenText() +
                "\'\n'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nationalCodeID, aminAuthenText);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Client otherCustomer) {
            if (getPhoneNumber() == otherCustomer.getPhoneNumber())
                return true;
            if (this.getPassword() == otherCustomer.getPassword())
                return true;
        }
        return false;
    }
}
