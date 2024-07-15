package ir.ac.kntu.faribank.Controller.client.transfer;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferController implements Initializable {

    @FXML
    private TextField SelectDestinationAccount;

    @FXML
    private TextField TransferAmountTextField;

    @FXML
    private ChoiceBox<?> ListOfRecentContactsChoiceBox;

    @FXML
    private ChoiceBox<?> contactListChoiceBox;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        submitButton.setOnMouseClicked(mouseEvent -> submitButtonHandler());
        //todo
    }

    private void submitButtonHandler() {
        stage=(Stage) submitButton.getScene().getWindow();
        //todo
        ProjectFX.changingscene(stage,"clientFXML/transfer/PaymentConfirmation.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }
}
