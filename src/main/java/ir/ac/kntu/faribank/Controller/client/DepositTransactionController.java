package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
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
    private VBox LabelDate;

    @FXML
    private VBox LabelDeposit;

    @FXML
    private VBox LabelNewBalance;

    @FXML
    private Label NationslidLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Label PhoneNumberLabel;

    @FXML
    private Button ButtonHome;

    @FXML
    private Button ButtonListOfTransactions;

    @FXML
    private Button backButton;
    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ButtonHome.setOnMouseClicked(mouseEvent -> ButtonHomeHandler());
        ButtonListOfTransactions.setOnMouseClicked(mouseEvent -> ButtonListOfTransactionsHandler());
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());


    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"deposit.fxml");
    }

    private void ButtonListOfTransactionsHandler() {
        stage=(Stage) ButtonListOfTransactions.getScene().getWindow();
        //todo
        ProjectFX.changingscene(stage,"ListOfAllTransactions.fxml");
    }

    private void ButtonHomeHandler() {
        stage=(Stage) ButtonHome.getScene().getWindow();
        ProjectFX.changingscene(stage,"ClentHomePage.fxml");

    }

}
