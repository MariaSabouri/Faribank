package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.Controller.client.SignUpController;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.MEnter;

public class MSignUp extends MEnter {
    private String firstName;
    private String lastName;
    private String nationalCodeID;

    public MSignUp(String firstName, String lastName, String nationalCodeID, String phoneNumber, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setNationalCode(nationalCodeID);
        setPhoneNumber(phoneNumber);
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

    public void setNationalCode(String nationalCodeID) {
        this.nationalCodeID = nationalCodeID;
    }

    public String getNationalCode() {
        return nationalCodeID;
    }

    @Override
    public String toString() {
        return "MSignUp {" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nnationalCodeID: '" + getNationalCode() +
                "\'\n'}";
    }

    @Override
    public void check() throws InvalidInputExeption {
        if (getPhoneNumber().length() != 11) {
            throw new InvalidInputExeption("Phone Number'length must be 11 digits.");
        } else if (!getPhoneNumber().matches("[0-9]{11}")) {
            throw new InvalidInputExeption("Phone Number should only contain digits (0-9).");
        }

        if (getPassword().matches("\\s")) {
            throw new InvalidInputExeption("Invalid password, because it has space (' ') character.");
        } else if (!getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).+$")) {
            throw new InvalidInputExeption(
                    "The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        }

        SignUpController.changeSceneToHome();
        
        System.out.println(toString());
    }
}
