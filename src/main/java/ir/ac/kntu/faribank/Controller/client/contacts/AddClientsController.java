package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.client.Contact;
import ir.ac.kntu.faribank.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddClientsController implements Initializable {


    @FXML
    private TextField AccountLabel;

    @FXML
    private TextField LastNameLabel;

    @FXML
    private TextField NameLabel;

    @FXML
    private TextField PhoneLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button homeButton;


    @FXML
    private Button addButton;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        homeButton.setOnMouseClicked(mouseEvent -> homeButtonHandler());
        addButton.setOnMouseClicked(mouseEvent -> addButtonHandler());

    }

    private void addButtonHandler() {
        stage=(Stage) addButton.getScene().getWindow();

        Contact contact=new Contact(NameLabel.getText(),LastNameLabel.getText(),PhoneLabel.getText(),Double.parseDouble(AccountLabel.getText()));

        try {
            HomeController.getClient().addContact(contact);
        }catch (NotFoundException|DuplicatedItemException e){
            Alert.showingError(e.getMessage());
        }

        ProjectFX.changingscene(stage,"clientFXML/contacts/ListOfAllContacts.fxml");
    }

    private void homeButtonHandler() {
        stage=(Stage) homeButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/contacts/ListOfAllContacts.fxml");
    }
}
