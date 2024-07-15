package ir.ac.kntu.faribank.Controller.client.transfer;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Contact;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentConfirmationController implements Initializable {

    @FXML
    private Label ToLabel;

    @FXML
    private Label TransferLabel;

    @FXML
    private Label desAccountLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private static Stage stage;

    private static String destinationAccount;
    private static String TransferAmount;
    private static Contact contactChosen;

    public static void setContctChosen(String destinationAccount, String transferAmount, Contact contactChosen) {
        PaymentConfirmationController.contactChosen=contactChosen;
        PaymentConfirmationController.destinationAccount=destinationAccount;
        PaymentConfirmationController.TransferAmount=transferAmount;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        submitButton.setOnMouseClicked(mouseEvent -> submitButtonHandler());

        ToLabel.setText(contactChosen.getFirstName()+" "+contactChosen.getLastName());
        desAccountLabel.setText(destinationAccount);
        TransferLabel.setText(TransferAmount);


    }

    private void submitButtonHandler() {
        stage=(Stage) submitButton.getScene().getWindow();
        //todo
        ProjectFX.changingscene(stage,"clientFXML/transfer/TransferTransaction.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/transfer/Transfer.fxml");
    }
}
