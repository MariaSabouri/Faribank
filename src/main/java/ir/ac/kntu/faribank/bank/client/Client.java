package ir.ac.kntu.faribank.bank.client;

import java.util.ArrayList;
import java.util.Objects;

import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.Controller.client.Deposit.DepositController;
import ir.ac.kntu.faribank.Controller.client.Deposit.DepositTransactionController;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.Bank;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.client.transaction.TDeposit;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;

public class Client extends Person {
    private String password;
    private String nationalCodeID;
    private String adminAuthenText;
    private String cardNumber;
    private String accountNumber;
    private Double balance = 0.0;

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private ArrayList<Contact> recentContacts = new ArrayList<Contact>();

    public Client(String phoneNumber, String password, String firstName, String lastName, String nationalCodeID)
            throws InvalidInputException, NotFoundException {
        super(firstName, lastName, phoneNumber);
        setPassword(password);
        setNationalCodeID(nationalCodeID);
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

    public void setNationalCodeID(String nationalCodeID) throws InvalidInputException {
        if (nationalCodeID.isEmpty()) {
            throw new InvalidInputException("National ID is empty.");
        }
        this.nationalCodeID = nationalCodeID;
    }

    public String getNationalCodeID() {
        return nationalCodeID;
    }

    public void setAdminAuthenText(String adminAuthenText) {
        this.adminAuthenText = adminAuthenText;
    }

    public String getAdminAuthenText() {
        return adminAuthenText;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void addAmountToBalance(Double amount) {
        this.balance += amount;
    }

    public Double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Contact> geContacts() {
        return contacts;
    }

    public ArrayList<Contact> getRecentContacts() {
        return recentContacts;
    }

    public void editContact(Contact editedContact) throws NotFoundException, InvalidInputException {
        int index = contacts.indexOf(editedContact);
        if (index == -1) {
            throw new NotFoundException();
        }

        contacts.remove(index);
        System.out.println("Contact edited successfully!");
        contacts.add(editedContact);
    }

    public void addContact(Contact contact) throws DuplicatedItemException {
        if (contacts.contains(contact)) {
            throw new DuplicatedItemException("Your contact is already in the contact list.");
        }

        contacts.add(contact);
        System.out.println("New Contact added successfully!");
        System.out.println(contact);
    }

    public void addRecentContact(Contact contact) {
        if (!recentContacts.contains(contact)) {
            contact.setDate();
            recentContacts.add(contact);
            System.out.println("\"Contact added to recentContacts successfully!\"");
            System.out.println("RecentContact: " + contact);
        } else {
            int index = recentContacts.indexOf(contact);

            recentContacts.remove(index);
            contact.setDate();
            recentContacts.add(contact);
            System.out.println("\"Contact edited and add to recentContacts successfully!\"");
            System.out.println("RecentContact: " + contact);
        }

        // Collections.sort() ??
    }

    // public void transfer(String amountStr, String accountNumber)
    //         throws InvalidAmountException, InsufficientFundsException, NumberFormatException, NotFoundException,
    //         InvalidInputException {
    //     double amount = Double.parseDouble(amountStr);

    //     if (amount < 0) {
    //         throw new InvalidAmountException();
    //     } else if (balance < (amount + Bank.wage)) {
    //         throw new InsufficientFundsException();
    //     }

    //     boolean pass1 = false, pass2 = false;
    //     // Check it in my contacts
    //     for (Contact contact : HomeController.getClient().geContacts()) {
    //         if (contact.getAccountNumber().equals(accountNumber)) {
    //             pass1 = true;
    //             break;
    //         }
    //     }

    //     if (!pass1) {
    //         throw new NotFoundException("This account number does not exist in your contacts");
    //     }

    //     // check it in my destination client'contacts, do he/she have my accountNum in
    //     // its contacts
    //     for (Client client : FariBank.getInstance().getClients()) {
    //         if (client.getAccountNumber().equals(accountNumber)) {
    //             if (client.geContacts()
    //                     .contains(new Contact("-", "-", HomeController.getClient().getPhoneNumber(), "----------"))) {
    //                 client.addAmountToBalance(amount);
    //                 balance -= (amount + Bank.wage);

    //                 TTransfer tTransfer = new TTransfer(amount, client.getFirstName() + " " + client.getLastName(),
    //                         contact.getFirstName() + " " + contact.getLastName(), balance);
    //                 transactions.add(tTransfer);

    //                 System.out.println("New Transaction added successfully!");
    //                 System.out.println(tTransfer);
    //                 return;
    //             }
    //         }
    //     }

    //     if (!pass2) {
    //         throw new NotFoundException("The destination user does not have you in its contacts.");
    //     }
    // }

    public void transfer(String amountStr, Contact contact)
            throws InvalidAmountException, InsufficientFundsException, NumberFormatException, InvalidInputException,
            NotFoundException {
        double amount = Double.parseDouble(amountStr);

        if (amount < 0) {
            throw new InvalidAmountException();
        } else if (balance < (amount + Bank.wage)) {
            throw new InsufficientFundsException();
        }

        // check it in my destination client'contacts, do he/she have my accountNum in
        // its contacts
        for (Client client : FariBank.getInstance().getClients()) {
            if (client.getPhoneNumber().equals(contact.getPhoneNumber())) {
                if (client.geContacts()
                        .contains(new Contact("-", "-", HomeController.getClient().getPhoneNumber(), "----------"))) {
                    client.addAmountToBalance(amount);
                    balance -= (amount + Bank.wage);
                    TTransfer tTransfer = new TTransfer(amount, client.getFirstName() + " " + client.getLastName(),
                            contact.getFirstName() + " " + contact.getLastName(), balance);
                    transactions.add(tTransfer);

                    System.out.println("New Transaction added successfully!");
                    System.out.println(tTransfer);
                    return;
                }
            }
        }

        throw new NotFoundException();
    }

    public void confirm(Contact contact) {

    }

    public void deposit(String amountStr) throws InvalidAmountException, NumberFormatException {
        double amount = Double.parseDouble(amountStr);

        if (amount <= 0) {
            throw new InvalidAmountException();
        }

        balance += amount;
        TDeposit tDeposit = new TDeposit(balance, amount);
        transactions.add(new TDeposit(balance, amount));

        DepositTransactionController.setValuesOfPage(tDeposit);
        DepositController.changeSceneToDisposeTransaction();

        System.out.println("New Transaction added successfully!");
        System.out.println(tDeposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nationalCodeID, adminAuthenText, cardNumber, accountNumber);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        if (other instanceof Client otherCustomer) {

            if (otherCustomer.getAccountNumber() != null) {
                if (password.equals(otherCustomer.getPassword()) && getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
                    return true;
            } else {
                if (nationalCodeID.equals(otherCustomer.getNationalCodeID()) || getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + password +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nnationalCodeID: '" + nationalCodeID +
                "\'\nadminAuthenText: '" + adminAuthenText +
                "\'\ncardNumber: '" + cardNumber +
                "\'\naccountNumber: '" + accountNumber +
                "\'\n}";
    }
}
