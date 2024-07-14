package ir.ac.kntu.faribank.bank.client.transaction;

public class TTransfer extends Transaction {
    private String from;
    private String to;
    private Double transfer;

    public TTransfer(Double transfer, String from, String to, Double newBalance) {
        super(newBalance);
        setTransfer(transfer);
        setFrom(from);
        setTo(to);
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

    @Override
    public String toString() {
        return "TTransfer{" +
        "\ndate: " + getDate() +
        "\ntransfer: " + getTransfer() +
        "\nfrom: '" + getFrom() +
        "\'\nto: '" + getTo() +
        "\'\n\nnew balance: " + getNewBalance() +
        "\'\n}";
    }
    
}
