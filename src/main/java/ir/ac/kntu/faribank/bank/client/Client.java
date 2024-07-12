package ir.ac.kntu.faribank.bank.client;

import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String nationalCodeID;
    private String phoneNumber;
    private String password;

    public Client(String firstName, String lastName, String phoneNumber, String nationalCodeID, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setID(nationalCodeID);
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

    public void setID(String nationalCodeID) {
        this.nationalCodeID = nationalCodeID;
    }

    public String getID() {
        return nationalCodeID;
    }

    public void setPassword(String password) {
        // if (password.matches(".")) {
        this.password = password;
        // } else {
        // System.out.println("The password is weak.");
        // }
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "\nBankAssistant=" + super.toString() +
                "\nfirstName=\'" + firstName +
                "\n\', lastName=\'" + lastName +
                "\n\', phoneNumber=" + phoneNumber +
                "\n, ID=" + nationalCodeID +
                "\n, phoneNumber=\'" + phoneNumber +
                "\n\'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber, nationalCodeID, password);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Client otherCustomer) {
            if (this.phoneNumber == otherCustomer.phoneNumber)
                return true;
            if (this.nationalCodeID == otherCustomer.nationalCodeID)
                return true;
        }
        return false;
    }
}
