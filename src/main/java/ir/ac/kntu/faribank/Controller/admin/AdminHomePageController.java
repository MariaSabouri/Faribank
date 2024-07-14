package ir.ac.kntu.faribank.Controller.admin;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminHomePageController implements Initializable {

    @FXML
    private Label UserName;

    @FXML
    private Button LogOutButton;

    @FXML
    private WebView AuthenticationWeb;

    @FXML
    private WebView RequestWeb;

    @FXML
    private WebView UserWeb;
    @FXML
    private BorderPane AuthenticationBorder;
    @FXML
    private BorderPane RequestBorder;

    private static Stage stage;

    private static JSONObject userInfo;

    public static void setUserInfo(JSONObject jsonObject) {
        userInfo = jsonObject;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogOutButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());
        AuthenticationBorder.setOnMouseClicked(mouseEvent -> AuthenticationBorderBorder());
        RequestBorder.setOnMouseClicked(mouseEvent -> RequestBorderHandler());

        UserWeb.setPageFill(Color.TRANSPARENT);
        AuthenticationWeb.setPageFill(Color.TRANSPARENT);
        RequestWeb.setPageFill(Color.TRANSPARENT);

        UserWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Account.svg")).toExternalForm());
        AuthenticationWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Authentication.svg")).toExternalForm());
        RequestWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Request.svg")).toExternalForm());

        UserName.setText(userInfo.getString("firstName") + " " + userInfo.getString("lastName"));
    }

    private void RequestBorderHandler() {
        stage=(Stage) RequestBorder.getScene().getWindow();


    }

    private void AuthenticationBorderBorder() {
    }

    private void LogOutButtonHandler() {
        stage = (Stage) LogOutButton.getScene().getWindow();
        ProjectFX.changingscene(stage, "welcome.fxml");
    }
}
