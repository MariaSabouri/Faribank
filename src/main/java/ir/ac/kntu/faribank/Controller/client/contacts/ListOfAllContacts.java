package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.client.Contact;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfAllContacts implements Initializable {
    @FXML
    private Button AddButton;

    @FXML
    private Button backButton;

    @FXML
    private ListView<BorderPane> listOfContactsListview;

    private static Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        AddButton.setOnMouseClicked(mouseEvent -> AddButtonHandler());

        for (Contact contact: HomeController.getClient().geContacts()){
            BorderPane borderPane=new BorderPane();
            Label Name=new Label(contact.getFirstName()+" "+contact.getLastName());
            borderPane.setLeft(Name);
            listOfContactsListview.getItems().add(borderPane);

            borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage=(Stage) borderPane.getScene().getWindow();
                    ContactDetailController.setContactDetail(contact);
                    ProjectFX.changingscene(stage,"clientFXML/contacts/ContactDetail.fxml");
                }
            });
        }


    }

    private void AddButtonHandler() {
        stage=(Stage) AddButton.getScene().getWindow();
        //todo
        ProjectFX.changingscene(stage,"clientFXML/contacts/AddContacts.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }
}
