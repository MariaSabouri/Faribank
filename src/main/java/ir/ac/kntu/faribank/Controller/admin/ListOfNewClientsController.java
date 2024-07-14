package ir.ac.kntu.faribank.Controller.admin;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

public class ListOfNewClientsController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private ListView<?> RequestsLIstview;

    public static void setNewClients(ArrayList<Client> newClients) {
        ListOfNewClientsController.newClients = newClients;
    }

    private static ArrayList<Client> newClients;


    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());

    }

    private void LogOutButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"AdminHomePage.fxml");
    }
}
