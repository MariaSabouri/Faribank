package ir.ac.kntu.faribank.Controller.client.Deposit;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.transaction.TDeposit;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositTransactioWithoutListOfTransactionBtnController implements Initializable {
    @FXML
    private Label DateLabel;

    @FXML
    private Label DepositLabel;

    @FXML
    private Label NewBalanceLabel;

    @FXML
    private Button backButton;
    @FXML
    private Button ButtonHome;

    private static Stage stage;

    private static Transaction transaction;

    public static void setTransactionDetails(Transaction t){
        transaction=t;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        ButtonHome.setOnMouseClicked(mouseEvent -> ButtonHomeHandler());

        TDeposit tDeposit=(TDeposit)transaction;
        DateLabel.setText(String.valueOf(tDeposit.getDate()));
        DepositLabel.setText(String.valueOf(tDeposit.getDeposit()));
        NewBalanceLabel.setText(String.valueOf(tDeposit.getNewBalance()));


    }

    private void ButtonHomeHandler() {
        stage=(Stage) ButtonHome.getScene().getWindow();
        ProjectFX.changingscene(stage,"ClentHomePage.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"ListOfAllTransactions.fxml");
    }
}
