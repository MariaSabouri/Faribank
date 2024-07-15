package ir.ac.kntu.faribank.bank;

import java.util.Objects;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public Person(String firstName, String lastName, String phoneNumber, String password) throws InvalidInputException, NotFoundException {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public void setFirstName(String firstName) throws InvalidInputException {
        if (firstName.isEmpty()) {
            throw new InvalidInputException("First name is empty.");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) throws InvalidInputException {
        if (lastName.isEmpty()) {
            throw new InvalidInputException("Last name is empty.");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidInputException, NotFoundException {
        if (phoneNumber.length() != 11) {
            throw new InvalidInputException("Phone Number'length must be 11 digits.");
        } else if (!phoneNumber.matches("[0-9]{11}")) {
            throw new InvalidInputException("Phone Number should only contain digits (0-9).");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) throws InvalidInputException {
        if (password.matches("\\s")) {
            throw new InvalidInputException("Invalid password, because it has space (' ') character.");
        } else if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).+$")) {
            throw new InvalidInputException(
                    "The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        }
        
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, password);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Person otherCustomer) {
            if (phoneNumber.equals(otherCustomer.getPhoneNumber()))
                return true;
        }
        return false;
    }
}
