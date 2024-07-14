package ir.ac.kntu.faribank.Controller.client.Deposit;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.transaction.TDeposit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositTransactionController implements Initializable {

    @FXML
    private Button ButtonHome;

    @FXML
    private Button ButtonListOfTransactions;

    @FXML
    private Label DateLabel;

    @FXML
    private Label DepositLabel;

    @FXML
    private Label NewBalanceLabel;

    @FXML
    private Button backButton;
    private static Stage stage;

    private static String date;
    private static String deposit;
    private static String newBalance;

    public static void setValuesOfPage(TDeposit tDeposit){
        date=tDeposit.getDate().toString();
        deposit=String.valueOf(tDeposit.getDeposit());
        newBalance=String.valueOf(tDeposit.getNewBalance());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateLabel.setText(date);
        DepositLabel.setText(deposit);
        NewBalanceLabel.setText(newBalance);

        ButtonHome.setOnMouseClicked(mouseEvent -> ButtonHomeHandler());
        ButtonListOfTransactions.setOnMouseClicked(mouseEvent -> ButtonListOfTransactionsHandler());
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());


    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/client/deposit.fxml");
    }

    private void ButtonListOfTransactionsHandler() {
        stage=(Stage) ButtonListOfTransactions.getScene().getWindow();

        ProjectFX.changingscene(stage,"clientFXML/deposit/ListOfAllTransactions.fxml");
    }

    private void ButtonHomeHandler() {
        stage=(Stage) ButtonHome.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");

    }

}
