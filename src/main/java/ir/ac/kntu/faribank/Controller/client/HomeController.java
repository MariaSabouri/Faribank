package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private Label AccountNumberLabel;

    @FXML
    private Label CardnumberLabel;

    @FXML
    private Label ClientName;

    @FXML
    private Label BalanceLabel;

    @FXML
    private Button LogOutButton;

    @FXML
    private BorderPane AccountManagementBorder;

    @FXML
    private BorderPane ContactBorder;

    @FXML
    private BorderPane SettingsBorder;

    @FXML
    private BorderPane SupportBorder;

    @FXML
    private BorderPane TransferBorder;

    @FXML
    private WebView ContactsWeb;

    @FXML
    private WebView SettingsWeb;

    @FXML
    private WebView SupportWeb;

    @FXML
    private WebView TransferWeb;

    @FXML
    private WebView AccountManagerWeb;

    private static Stage stage;

    private static String name;
    private static String CardNumber;
    private static String AccountNumber;
    private static String Balance;

    private static Client client;

    public static Client getClient() {
        return client;
    }

    public static void setUserInfo(Client client) {
        HomeController.client=client;

        name = client.getFirstName()+" "+client.getLastName();
        CardNumber = client.getCardNumber();
        AccountNumber = client.getAccountNumber();
        Balance=String.valueOf(client.getBalance());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogOutButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());
        AccountManagementBorder.setOnMouseClicked(mouseEvent -> AccountManagementBorderHandler());
        ContactBorder.setOnMouseClicked(mouseEvent -> ContactBorderHandler());
        SettingsBorder.setOnMouseClicked(mouseEvent -> SettingsBorderHandler());
        SupportBorder.setOnMouseClicked(mouseEvent -> SupportBorderHandler());
        TransferBorder.setOnMouseClicked(mouseEvent -> TransferBorderHandler());

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

    private void TransferBorderHandler() {
        stage=(Stage) TransferBorder.getScene().getWindow();
    }

    private void SupportBorderHandler() {
        stage=(Stage) SupportBorder.getScene().getWindow();
    }

    private void SettingsBorderHandler() {
        stage=(Stage) SettingsBorder.getScene().getWindow();
    }

    private void ContactBorderHandler() {
        stage=(Stage) ContactBorder.getScene().getWindow();
    }

    private void AccountManagementBorderHandler() {
        stage=(Stage) AccountManagementBorder.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/deposit/deposit.fxml");
    }

    private void LogOutButtonHandler() {
        stage = (Stage) LogOutButton.getScene().getWindow();
        ProjectFX.changingscene(stage, "welcome.fxml");
    }
}
