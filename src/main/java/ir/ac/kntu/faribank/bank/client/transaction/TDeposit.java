package ir.ac.kntu.faribank.bank.client.transaction;

public class TDeposit extends Transaction {
    private Double deposit;

    public TDeposit(Double balance, Double deposit) {
        super(balance);
        setDeposit(deposit);
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getDeposit() {
        return deposit;
    }

    @Override
    public String toString() {
        return "TDeposit{" +
        "\ndate: " + getDate() +
        "\ndeposit: +" + getDeposit() +
        "\nnew balance: " + getNewBalance() +
        "\n}";
    }
}
