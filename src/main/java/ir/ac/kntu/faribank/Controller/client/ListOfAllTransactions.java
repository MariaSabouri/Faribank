package ir.ac.kntu.faribank.Controller.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfAllTransactions implements Initializable {
    @FXML
    private ListView<?> RequestsLIstview;

    @FXML
    private Button backButton;

    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
