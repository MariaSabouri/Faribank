package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AuthenticationController implements Initializable {

    @FXML
    private Button LogOutButton;

    @FXML
    private WebView waitSVG;
    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogOutButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());

        waitSVG.setPageFill(Color.TRANSPARENT);
        waitSVG.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/loading.svg")).toExternalForm());


    }

    private void LogOutButtonHandler() {
        stage=(Stage) LogOutButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"Authentication.fxml");
    }
}
