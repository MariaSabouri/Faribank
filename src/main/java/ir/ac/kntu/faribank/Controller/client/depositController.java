package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class depositController implements Initializable {
    @FXML
    private WebView depositWebView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        depositWebView.setPageFill(Color.TRANSPARENT);
        depositWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/deposit.svg")).toExternalForm());

    }
}
