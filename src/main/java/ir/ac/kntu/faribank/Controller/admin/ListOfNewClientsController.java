package ir.ac.kntu.faribank.Controller.admin;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

public class ListOfNewClientsController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private ListView<BorderPane> RequestsLIstview;
    @FXML
    private ScrollPane scrollPane;
    private static ArrayList<Client> newClients;

    public static void setNewClients(ArrayList<Client> newClients) {
        ListOfNewClientsController.newClients = newClients;
    }


    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        for (Client neclient:newClients){
            BorderPane borderPane=new BorderPane();
            Label Name=new Label(neclient.getFirstName()+" "+neclient.getLastName());
            Label phonenumber=new Label(neclient.getPhoneNumber());
            borderPane.setLeft(Name);
            borderPane.setRight(phonenumber);
            RequestsLIstview.getItems().add(borderPane);
        }


    }

    private void LogOutButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"AdminHomePage.fxml");
    }
}
