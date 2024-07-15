package ir.ac.kntu.faribank.bank.client.transaction;

import ir.ac.kntu.faribank.bank.Bank;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.util.GenerateUniqueNumber;

public class TTransfer extends Transaction {
    private String from;
    private String to;
    private Double transfer;
    private String trackingCode;
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double bankFee = Bank.fee;

    public TTransfer(Double transfer, Client fromClient, Client toClient, Double newBalance) {
        super(newBalance);
        setTransfer(transfer);
        setFrom(fromClient.getFirstName() + " " + fromClient.getLastName());
        setTo(toClient.getFirstName() + " " + toClient.getLastName());
        setFromAccountNumber(fromClient.getAccountNumber());
        setToAccountNumber(toClient.getAccountNumber());
        setTrackingCode(GenerateUniqueNumber.generate(6));
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    public Double getTransfer() {
        return transfer;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setBankFee(Double bankFee) {
        this.bankFee = bankFee;
    }

    public Double getBankFee() {
        return bankFee;
    }

    @Override
    public String toString() {
        return "TTransfer{" +
                "\nfromAccountNumber: " + fromAccountNumber +
                "\ntoAccountNumber: " + toAccountNumber +
                "\nfrom: '" + getFrom() +
                "\'\nto: '" + getTo() +
                "\ntransfer: -" + getTransfer() +
                "\nbank fee: -" + bankFee +
                "\'\n\nnew balance: " + getNewBalance() +
                "\ndate: " + getDate() +
                "\n}";
    }

}
