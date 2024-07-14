package ir.ac.kntu.faribank.bank.client.transaction;

import java.time.LocalDateTime;

public abstract class Transaction {    
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

    public LocalDateTime getDate() {
        return date;
    }
}
