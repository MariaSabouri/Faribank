package ir.ac.kntu.faribank.bank;

import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    private Integer cardNumber;
    private Integer acountNumber;

    public Person(String firstName, String lastName, String phoneNumber, String password) {
        setFirstName(firstName);
        setLastName(lastName);
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAcountNumber(Integer acountNumber) {
        this.acountNumber = acountNumber;
    }

    public Integer getAcountNumber() {
        return acountNumber;
    }
    
    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, password);
    }
}
