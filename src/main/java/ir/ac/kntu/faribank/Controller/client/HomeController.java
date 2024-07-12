package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label AccountmanagementLabel;

    @FXML
    private Label AccountmanagementLabel1;

    @FXML
    private Label ContactsLabel;
    @FXML
    private HBox LogOutButton;

    @FXML
    private Label TransferLabel;

    @FXML
    private Label TransferLabel1;

    @FXML
    private WebView TransferWeb;
    @FXML
    private WebView SettingsWeb;
    @FXML
    private WebView SupportWeb;
    @FXML
    private WebView ContactsWeb;
    @FXML
    private WebView AccountManagerWeb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        mywe.setPageFill(Color.TRANSPARENT);
//        mywe.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/user-svgrepo-com.svg")).toExternalForm());\
        TransferWeb.setPageFill(Color.TRANSPARENT);
        SettingsWeb.setPageFill(Color.TRANSPARENT);
        SupportWeb.setPageFill(Color.TRANSPARENT);
        ContactsWeb.setPageFill(Color.TRANSPARENT);
        AccountManagerWeb.setPageFill(Color.TRANSPARENT);

        TransferWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Transfer.svg")).toExternalForm());
        SettingsWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Settings.svg")).toExternalForm());
        ContactsWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Contacts.svg")).toExternalForm());
        SupportWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Support.svg")).toExternalForm());
        AccountManagerWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Accountmanagement.svg")).toExternalForm());

    }
}
