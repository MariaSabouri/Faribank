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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private BorderPane AccountManagementBorder;

    @FXML
    private WebView AccountManagerWeb;

    @FXML
    private Label AccountNumberLabel;

    @FXML
    private Label BalanceLabel;

    @FXML
    private BorderPane BankFundBorderPane;

    @FXML
    private Label CardnumberLabel;

    @FXML
    private Label ClientName;

    @FXML
    private BorderPane ContactBorder;

    @FXML
    private WebView ContactsWeb;

    @FXML
    private WebView FundWebView;

    @FXML
    private Button LogOutButton;

    @FXML
    private BorderPane SettingsBorder;

    @FXML
    private WebView SettingsWeb;

    @FXML
    private BorderPane SupportBorder;

    @FXML
    private WebView SupportWeb;

    @FXML
    private BorderPane TransferBorder;

    @FXML
    private WebView TransferWeb;

    private static Stage stage;

    private static Client client;

    public static Client getClient() {
        return client;
    }

    public static void setUserInfo(Client client) {
        HomeController.client=client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogOutButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());
        AccountManagementBorder.setOnMouseClicked(mouseEvent -> AccountManagementBorderHandler());
        ContactBorder.setOnMouseClicked(mouseEvent -> ContactBorderHandler());
        SettingsBorder.setOnMouseClicked(mouseEvent -> SettingsBorderHandler());
        SupportBorder.setOnMouseClicked(mouseEvent -> SupportBorderHandler());
        TransferBorder.setOnMouseClicked(mouseEvent -> TransferBorderHandler());

        FundWebView.setPageFill(Color.TRANSPARENT);
        TransferWeb.setPageFill(Color.TRANSPARENT);
        SettingsWeb.setPageFill(Color.TRANSPARENT);
        SupportWeb.setPageFill(Color.TRANSPARENT);
        ContactsWeb.setPageFill(Color.TRANSPARENT);
        AccountManagerWeb.setPageFill(Color.TRANSPARENT);

        FundWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/BankFund.svg")).toExternalForm());
        TransferWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Transfer.svg")).toExternalForm());
        SettingsWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Settings.svg")).toExternalForm());
        ContactsWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Contacts.svg")).toExternalForm());
        SupportWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Support.svg")).toExternalForm());
        AccountManagerWeb.getEngine()
                .load(Objects.requireNonNull(FXML_Loader.loadURL("images/Accountmanagement.svg")).toExternalForm());

        ClientName.setText(client.getFirstName()+" "+client.getLastName());

        String cardnumber=fixCardNumberStyle(client.getCardNumber());
        CardnumberLabel.setText(cardnumber);

        AccountNumberLabel.setText(client.getAccountNumber());
        BalanceLabel.setText(String.valueOf(client.getBalance()));

    }

    private String fixCardNumberStyle(String cardNumber) {
        String resultCardNumberStyle;
        resultCardNumberStyle=cardNumber.substring(0,4)+" "
                +cardNumber.substring(4,8)+" "
                +cardNumber.substring(8,12)+" "
                +cardNumber.substring(12,16)+" ";
        return resultCardNumberStyle;
    }

    private void TransferBorderHandler() {
        stage=(Stage) TransferBorder.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/transfer/Transfer.fxml");
    }

    private void SupportBorderHandler() {
        stage=(Stage) SupportBorder.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/support/Feedback.fxml");
    }

    private void SettingsBorderHandler() {
        stage=(Stage) SettingsBorder.getScene().getWindow();
    }

    private void ContactBorderHandler() {
        stage=(Stage) ContactBorder.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/contacts/ListOfAllContacts.fxml");
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
