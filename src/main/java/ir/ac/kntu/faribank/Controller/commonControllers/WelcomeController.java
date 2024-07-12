package ir.ac.kntu.faribank.Controller.commonControllers;
import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    private Stage stage ;
    @FXML
    private Button BanckAssistantButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button customerButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExitButton.setOnMouseClicked(mouseEvent -> ExitButtonHandler());

        BanckAssistantButton.setOnMouseClicked(mouseEvent -> BanckAssistantButtonHandler());
        customerButton.setOnMouseClicked(mouseEvent -> customerButtonHandler());

    }

    private void customerButtonHandler() {
        stage=(Stage) customerButton.getScene().getWindow();
        LoginController.setLoginLabel(customerButton.getText());
        ProjectFX.changingscene(stage,"login-view.fxml");

    }

    private void BanckAssistantButtonHandler() {
        stage=(Stage) BanckAssistantButton.getScene().getWindow();
        LoginController.setLoginLabel(BanckAssistantButton.getText());
        ProjectFX.changingscene(stage,"login-view.fxml");


    }

    private void ExitButtonHandler() {
        stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
        System.exit(0);
    }
}
