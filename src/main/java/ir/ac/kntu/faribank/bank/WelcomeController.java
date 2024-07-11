package ir.ac.kntu.faribank.bank;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    private Stage stage ;
    @FXML
    private RadioButton BanckAssistantButton;

    @FXML
    private Button ExitButton;

    @FXML
    private RadioButton customerButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExitButton.setOnMouseClicked(mouseEvent -> ExitButtonHandler());
    }

    private void ExitButtonHandler() {
        stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
        System.exit(0);
    }
}
