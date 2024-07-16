package ir.ac.kntu.faribank.bank.client.fund;

import java.util.ArrayList;
import java.util.Objects;

import ir.ac.kntu.faribank.bank.Bank;
import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.bank.client.transaction.TDeposit;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;

public abstract class Fund {
    private FundType type;
    private Double save = 0.0;
    private Client client;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Fund(FundType type, Client client) {
        setType(type);
        setSave(save);
        setClient(client);
    }

    public void setType(FundType type) {
        this.type = type;
    }

    public FundType getType() {
        return type;
    }

    public void addSave(Double amount) {
        this.save += amount;
    }

    public void reduceSave(Double amount) {
        this.save -= amount;
    }

    public void setSave(Double save) {
        this.save = save;
    }

    public Double getSave() {
        return save;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void addTransactions(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void transfer(String amountStr) throws InvalidAmountException, InsufficientFundsException {
        double amount = Double.parseDouble(amountStr);

        if (amount < 0) {
            throw new InvalidAmountException();
        } else if (getSave() < (amount + Bank.fee)) {
            throw new InsufficientFundsException("ّSaving fund does not have enough money");
        }

        reduceSave(amount + Bank.fee);
        Double newBalance = getClient().getBalance() + amount;
        getClient().addBalance(amount);

        TDeposit tDeposit = new TDeposit(newBalance, amount);
        getClient().addTransactions(tDeposit);
        addTransactions(tDeposit);

        System.out.println("New Transaction added successfully!");
        System.out.println(tDeposit);
    }

    public void deposit(String amountStr) throws InvalidAmountException, InsufficientFundsException {
        double amount = Double.parseDouble(amountStr);

        if (amount < 0) {
            throw new InvalidAmountException();
        } else if (getClient().getBalance() < (amount + Bank.fee)) {
            throw new InsufficientFundsException("Client does not have enough money.");
        }

        addSave(amount);
        Double newBalance = getClient().getBalance() - (amount + Bank.fee);
        getClient().setBalance(newBalance);

        TTransfer tTransfer = new TTransfer(amount, getClient().getFirstName() + " " + getClient().getLastName(),
                getClient().getFirstName() + " " + getClient().getLastName(), getClient().getAccountNumber(),
                getClient().getAccountNumber(), newBalance);

        getClient().addTransactions(tTransfer);
        addTransactions(tTransfer);

        System.out.println("New Transaction added successfully!");
        System.out.println(tTransfer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, save);
    }

    @Override
    public String toString() {
        return "Fund{" +
                "\ntype: " + type.name() +
                "\nsave: +" + save +
                "\ntransactions: +" + transactions +
                "\n}";
    }
}
