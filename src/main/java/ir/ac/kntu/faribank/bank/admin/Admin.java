package ir.ac.kntu.faribank.bank.admin;

import ir.ac.kntu.faribank.bank.Person;

public class Admin extends Person {
    public Admin(String firstName, String lastName, String phoneNumber, String password) {
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
