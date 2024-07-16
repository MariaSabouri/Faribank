package ir.ac.kntu.faribank.bank.client.transaction;

import java.time.LocalDateTime;

import org.json.JSONObject;

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
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("newBalance", getNewBalance());
        jsonObject.put("date", getDate());
        jsonObject.put("deposit", deposit);

        return jsonObject;
    }

    // @Override
    // public void parse(JSONObject jsonObject) {
    //     setNewBalance(jsonObject.getDouble("newBalance"));
    //     setDate(LocalDateTime.parse(jsonObject.getString("date")));
    //     setDeposit(jsonObject.getDouble("deposit"));
    // }

    @Override
    public String toString() {
        return "TDeposit{" +
                "\ndate: " + getDate() +
                "\ndeposit: +" + getDeposit() +
                "\nnew balance: " + getNewBalance() +
                "\n}";
    }
}
