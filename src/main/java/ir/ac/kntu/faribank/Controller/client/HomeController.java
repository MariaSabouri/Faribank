package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import org.json.JSONObject;

public class HomeController implements Initializable {

    @FXML
    private WebView AccountManagerWeb;

    @FXML
    private Label AccountNumberLabel;

    @FXML
    private Label CardnumberLabel;

    @FXML
    private Label ClientName;

    @FXML
    private WebView ContactsWeb;

    @FXML
    private Button LogOutButton;

    @FXML
    private WebView SettingsWeb;

    @FXML
    private WebView SupportWeb;

    @FXML
    private WebView TransferWeb;

    @FXML
    private WebView CardWeb;

    private static Stage stage;

    private static String name;
    private static String CardNumber;
    private static String AccountNumber;

    public static void SetUserInfo(JSONObject jsonObject) {
        name = jsonObject.getString("firstName") + " " + jsonObject.getString("lastName");
        CardNumber = jsonObject.getString("cardNumber");
        AccountNumber = jsonObject.getString("accountNumber");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogOutButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());

        TransferWeb.setPageFill(Color.TRANSPARENT);
        SettingsWeb.setPageFill(Color.TRANSPARENT);
        SupportWeb.setPageFill(Color.TRANSPARENT);
        ContactsWeb.setPageFill(Color.TRANSPARENT);
        AccountManagerWeb.setPageFill(Color.TRANSPARENT);

        TransferWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Transfer.svg")).toExternalForm());
        SettingsWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Settings.svg")).toExternalForm());
        ContactsWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Contacts.svg")).toExternalForm());
        SupportWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Support.svg")).toExternalForm());
        AccountManagerWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Accountmanagement.svg")).toExternalForm());

        ClientName.setText(name);
        CardnumberLabel.setText(CardNumber);
        AccountNumberLabel.setText(AccountNumber);

    }

    private void LogOutButtonHandler() {
        stage = (Stage) LogOutButton.getScene().getWindow();
        ProjectFX.changingscene(stage, "welcome.fxml");
    }
}
