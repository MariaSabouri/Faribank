package ir.ac.kntu.faribank.Controller.client.transfer;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentConfirmationController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private static Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        submitButton.setOnMouseClicked(mouseEvent -> submitButtonHandler());

    }

    private void submitButtonHandler() {
        stage=(Stage) submitButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/transfer/TransferTransaction.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/transfer/Transfer.fxml");
    }
}
