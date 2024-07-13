package ir.ac.kntu.faribank.Controller.admin;

import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserWeb.setPageFill(Color.TRANSPARENT);
        AuthenticationWeb.setPageFill(Color.TRANSPARENT);
        RequestWeb.setPageFill(Color.TRANSPARENT);



        UserWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Account.svg")).toExternalForm());
        AuthenticationWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Authentication.svg")).toExternalForm());
        RequestWeb.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Request.svg")).toExternalForm());
    }
}
