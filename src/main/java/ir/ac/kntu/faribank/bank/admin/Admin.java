package ir.ac.kntu.faribank.bank.admin;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public class Admin extends Person {
    public Admin(String firstName, String lastName, String phoneNumber, String password) throws InvalidInputException, NotFoundException {
        super(firstName, lastName, phoneNumber, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\n}";
    }
}
