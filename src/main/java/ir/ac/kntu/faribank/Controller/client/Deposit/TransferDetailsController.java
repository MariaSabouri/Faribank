package ir.ac.kntu.faribank.Controller.client.Deposit;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferDetailsController implements Initializable {

    @FXML
    private Label DateLabel;

    @FXML
    private Label FromLabel;

    @FXML
    private Label ToLabel;

    @FXML
    private Label NewBalanceLabel;

    @FXML
    private Label TransferLabel;

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

        TTransfer tTransfer=(TTransfer)transaction;
        DateLabel.setText(tTransfer.getDate().toString());
        TransferLabel.setText(String.valueOf(tTransfer.getTransfer()));
        FromLabel.setText(tTransfer.getFrom());
        ToLabel.setText(tTransfer.getTo());
        NewBalanceLabel.setText(String.valueOf(tTransfer.getNewBalance()));
    }

    private void ButtonHomeHandler() {
        stage=(Stage) ButtonHome.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ListOfAllTransactions.fxml");
    }
}
