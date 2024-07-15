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
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;

public class Client extends Person {
    private String nationalCodeID;
    private String adminAuthenText;
    private String cardNumber;
    private String accountNumber;
    private Double balance = 0.0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private ArrayList<Contact> recentContacts = new ArrayList<Contact>();

    public Client(String phoneNumber, String password, String firstName, String lastName, String nationalCodeID) throws InvalidInputException, NotFoundException {
        super(firstName, lastName, phoneNumber, password);
        setNationalCodeID(nationalCodeID);
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

    public void setBalance(Double balance) {
        this.balance = balance;
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
        System.err.println(contact);
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

    public void transfer(String amountStr, String accountNumber)
            throws InvalidAmountException, InsufficientFundsException, NumberFormatException, NotFoundException {
        double amount = Double.parseDouble(amountStr);

        if (amount < 0) {
            throw new InvalidAmountException();
        } else if (balance < amount + Bank.wage) {
            throw new InsufficientFundsException();
        }

        // boolean accountNumberFound = false;
        // int index = 0;
        // for (Client client : FariBank.getInstance().getClients()) {
        //     if (client.getAccountNumber().equals(accountNumber)) {
        //         // if (client.geContacts().contains(new Contact("","",HomeController.getClient().getPhoneNumber(),""))) {
        //         //     System.out.println();
        //         // }
        //         accountNumberFound = true;
        //         break;
        //     }
        //     index++;
        // }

        // if (!accountNumberFound) {
        //     throw new NotFoundException("This account number does not exist in the bank.");
        // }

        balance -= amount;
        // TODO
    }

    public void transfer(Contact contact)
            throws InvalidAmountException, InsufficientFundsException, NumberFormatException {
        // double amount = Double.parseDouble(amountStr);

        // if (amount < 0) {
        //     throw new InvalidAmountException();
        // } else if (balance < amount) {
        //     throw new InsufficientFundsException();
        // }

        // balance -= amount;
        // TODO
    }

    public void confirm(Contact contact) {
        // TODO
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

            if (getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
                return true;

            if (otherCustomer.getNationalCodeID().equals("")) {
                if (getPassword().equals(otherCustomer.getPassword()))
                    return true;
            } else {
                if (nationalCodeID.equals(otherCustomer.getNationalCodeID()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nnationalCodeID: '" + getNationalCodeID() +
                "\'\nadminAuthenText: '" + getAdminAuthenText() +
                "\'\ncardNumber: '" + getCardNumber() +
                "\'\naccountNumber: '" + getAccountNumber() +
                "\'\n}";
    }
}
