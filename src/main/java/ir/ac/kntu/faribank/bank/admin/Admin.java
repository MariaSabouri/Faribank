package ir.ac.kntu.faribank.bank.admin;

import org.json.JSONObject;

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

    @Override
    public JSONObject toJson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toJson'");
    }

    @Override
    public void parse(JSONObject jsonObject) throws InvalidInputException, NotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parse'");
    }
}
