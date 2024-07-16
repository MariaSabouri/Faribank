package ir.ac.kntu.faribank.bank.client.transaction;

import java.time.LocalDateTime;

import org.json.JSONObject;

import ir.ac.kntu.faribank.bank.Json;

public abstract class Transaction implements Comparable<Transaction>, Json {    
    private Double newBalance;
    private LocalDateTime date;

    public Transaction(Double newBalance) {
        date = LocalDateTime.now();
        setNewBalance(newBalance);
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDateNow() {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public int compareTo(Transaction transaction) {
        return transaction.getDate().compareTo(this.date);
    }

}
