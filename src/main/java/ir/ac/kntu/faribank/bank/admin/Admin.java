package ir.ac.kntu.faribank.bank.admin;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public class Admin extends Person {
    private String password;

    public Admin(String firstName, String lastName, String phoneNumber, String password) throws InvalidInputException, NotFoundException {
        super(firstName, lastName, phoneNumber);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + password +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\n}";
    }
}
