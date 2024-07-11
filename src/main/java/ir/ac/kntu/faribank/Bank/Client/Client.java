package ir.ac.kntu.faribank.Bank.Client;

import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private int ID;
    private String password;

    public Client(String firstName, String lastName, int phoneNumber, int ID, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setID(ID);
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
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
                "\n, ID=" + ID +
                "\n, phoneNumber=\'" + phoneNumber +
                "\n\'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber, ID, password);
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
            if (this.ID == otherCustomer.ID)
                return true;
        }
        return false;
    }
}
