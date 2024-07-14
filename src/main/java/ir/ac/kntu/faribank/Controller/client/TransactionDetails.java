package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.bank.client.transaction.Transaction;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionDetails implements Initializable {

    private static Transaction transaction;

    public static void setTransactionDetails(Transaction t){
        transaction=t;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
