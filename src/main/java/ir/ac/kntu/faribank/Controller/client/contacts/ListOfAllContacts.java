package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfAllContacts implements Initializable {
    @FXML
    private Button AddButton;

    @FXML
    private Button backButton;

    @FXML
    private ListView<?> listOfContactsListview;

    private static Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        AddButton.setOnMouseClicked(mouseEvent -> AddButtonHandler());



    }

    private void AddButtonHandler() {
        stage=(Stage) AddButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/contacts/AddClients.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
    }
}
