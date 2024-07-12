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
    private WebView mywe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mywe.setPageFill(Color.TRANSPARENT);
        mywe.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("D:\\Maria\\Dada\\FariBank\\src\\main\\resources\\ir\\ac\\kntu\\faribank\\images\\user-svgrepo-com.svg")).toExternalForm());

    }
}
