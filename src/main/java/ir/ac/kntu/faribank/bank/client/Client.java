package ir.ac.kntu.faribank.bank.client;

import java.util.ArrayList;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.Controller.client.Deposit.DepositController;
import ir.ac.kntu.faribank.Controller.client.Deposit.DepositTransactionController;
import ir.ac.kntu.faribank.Controller.client.transfer.PaymentConfirmationController;
import ir.ac.kntu.faribank.Controller.client.transfer.TransferTransactionController;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.Bank;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.client.fund.Fund;
import ir.ac.kntu.faribank.bank.client.fund.Remaining;
import ir.ac.kntu.faribank.bank.client.support.Request;
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
    private ArrayList<Request> requests = new ArrayList<Request>();
    private ArrayList<Fund> funds = new ArrayList<Fund>();

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

    public void addBalance(Double amount) {
        this.balance += amount;
    }

    public void reduceBalance(Double amount) {
        this.balance -= amount;
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

    public void addTransactions(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Contact> geContacts() {
        return contacts;
    }

    public ArrayList<Contact> getRecentContacts() {
        return recentContacts;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public ArrayList<Fund> getFunds() {
        return funds;
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

    public void deleteContact(Contact contact) throws NotFoundException {
        if (!contacts.contains(contact)) {
            throw new NotFoundException();
        }

        contacts.remove(contact);
        System.out.println("Contact deleted successfully!");
    }

    public void addRecentContact(Contact contact) {
        if (!recentContacts.contains(contact)) {
            recentContacts.add(contact);
            System.out.println("\"Contact added to recentContacts successfully!\"");
            System.out.println("RecentContact: " + contact);
        } else {
            int index = recentContacts.indexOf(contact);

            recentContacts.remove(index);
            recentContacts.add(contact);
            System.out.println("\"Contact edited and add to recentContacts successfully!\"");
            System.out.println("RecentContact: " + contact);
        }
        contact.setDateNow();
    }

    public void transfer(String amountStr, Contact contact)
            throws InvalidAmountException, InsufficientFundsException, NumberFormatException, InvalidInputException,
            NotFoundException {
        double amount = Double.parseDouble(amountStr);

        if (amount < 0) {
            throw new InvalidAmountException();
        } else if (balance < (amount + Bank.fee)) {
            throw new InsufficientFundsException();
        }

        // Do destination client'contacts have my accountNum?
        for (Client client : FariBank.getInstance().getClients()) {
            if (client.getPhoneNumber().equals(contact.getPhoneNumber())) { // find my contact

                for (Contact toContact : client.geContacts()) {
                    if (toContact.getPhoneNumber().equals(HomeController.getClient().getPhoneNumber())) {
                        client.addBalance(amount);
                        balance -= (amount + Bank.fee);

                        TTransfer tTransfer = new TTransfer(amount, this.getFirstName() + " " + this.getLastName(),
                            client.getFirstName() + " " + client.getLastName(), this.getAccountNumber(), client.getAccountNumber(), balance);
                        transactions.add(tTransfer);

                        TransferTransactionController.settTransfer(tTransfer);
                        PaymentConfirmationController.changeSceneToTransferTYransaction();

                        addRecentContact(contact);
                        System.out.println("New Transaction added successfully!");
                        System.out.println(tTransfer);

                        // Remaining Fund
                        funds.forEach((fund) -> {
                            if (fund instanceof Remaining remaining) {
                                try {
                                    remaining.remain(balance);
                                } catch (InvalidAmountException | InsufficientFundsException e) {
                                    e.printStackTrace();
                                }
                            }
                        }); 
                        return;
                    }
                }
            }
        }

        throw new NotFoundException("The destination client'contacts does not have you.");
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

    public void addRequest(Request request) {
        requests.add(request);

        System.out.println("New request added successfully!");
        System.out.println(request);
    }

    public void addFund(Fund fund) throws DuplicatedItemException {
        if (funds.contains(fund)) {
            throw new DuplicatedItemException("Your contact is already in the contact list.");
        }

        funds.add(fund);
        System.out.println("New fund added successfully!");
        System.out.println(fund);
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", getFirstName()); //
        jsonObject.put("lastName", getLastName()); //
        jsonObject.put("phoneNumber", getPhoneNumber()); //
        jsonObject.put("password", password); //
        jsonObject.put("nationalCodeID", nationalCodeID); //
        jsonObject.put("adminAuthenText", adminAuthenText); //
        jsonObject.put("cardNumber", cardNumber); //
        jsonObject.put("accountNumber", accountNumber); //
        jsonObject.put("balance", balance); //

        JSONArray tDepositArray = new JSONArray();
        transactions.stream()
                    .filter(transaction -> transaction instanceof TDeposit)
                    .map(transaction -> ((TDeposit) transaction).toJson())
                    .forEach(tDepositArray::put);

        JSONArray tTransactionArray = new JSONArray();
        transactions.stream()
                    .filter(transaction -> transaction instanceof TTransfer)
                    .map(transaction -> ((TTransfer) transaction).toJson())
                    .forEach(tTransactionArray::put);

        jsonObject.put("transactions", new JSONObject()
                                            .put("tDeposit", tDepositArray)
                                            .put("tTransaction", tTransactionArray));

        jsonObject.put("contacts", new JSONArray(contacts.stream().map(Contact::toJson).toArray()));
        jsonObject.put("recentContacts", new JSONArray(recentContacts.stream().map(Contact::toJson).toArray()));
        jsonObject.put("requests", new JSONArray(requests.stream().map(Request::toJson).toArray()));

        return jsonObject;
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
                // Login
                if (password.equals(otherCustomer.getPassword())
                        && getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
                    return true;
            } else {
                // SignUp
                if (nationalCodeID.equals(otherCustomer.getNationalCodeID())
                        || getPhoneNumber().equals(otherCustomer.getPhoneNumber()))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nfirstName: '" + getFirstName() +
                "\'\nlastName: '" + getLastName() +
                "\'\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + password +
                "\'\nnationalCodeID: '" + nationalCodeID +
                "\'\nadminAuthenText: '" + adminAuthenText +
                "\'\ncardNumber: '" + cardNumber +
                "\'\naccountNumber: '" + accountNumber +
                "\'\n}";
    }
}
