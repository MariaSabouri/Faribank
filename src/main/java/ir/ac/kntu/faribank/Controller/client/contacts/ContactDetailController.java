package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
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

public class ContactDetailController implements Initializable {


    @FXML
    private TextField AccountTextField;

    @FXML
    private Button ButtonHome;

    @FXML
    private Button EdditButton;

    @FXML
    private TextField LastNameTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private Button SaveButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField phoneNumberTextField;


    private static Stage stage;

    private static Contact contactDetail;

    public static void setContactDetail(Contact contact) {
        contactDetail=contact;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ButtonHome.setOnMouseClicked(mouseEvent -> ButtonHomeHandler());
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        SaveButton.setOnMouseClicked(mouseEvent -> SaveButtonHandler());
        EdditButton.setOnMouseClicked(mouseEvent -> EdditButtonHandler());


        NameTextField.setText(contactDetail.getFirstName());
        LastNameTextField.setText(contactDetail.getLastName());
        phoneNumberTextField.setText(contactDetail.getPhoneNumber());
        AccountTextField.setText(String.valueOf(contactDetail.getAccountNumber()));

        SaveButton.setDisable(true);
        NameTextField.setEditable(false);
        LastNameTextField.setEditable(false);
        phoneNumberTextField.setEditable(false);
        AccountTextField.setEditable(false);

    }

    private void EdditButtonHandler() {
        SaveButton.setDisable(false);
        NameTextField.setEditable(true);
        LastNameTextField.setEditable(true);
        phoneNumberTextField.setEditable(true);
        AccountTextField.setEditable(true);
    }

    private void SaveButtonHandler() {
        stage=(Stage) SaveButton.getScene().getWindow();
        EdditButton.setDisable(true);

        try {
            Contact contact=new Contact(NameTextField.getText(),LastNameTextField.getText(),phoneNumberTextField.getText(),AccountTextField.getText());
            HomeController.getClient().editContact(contact);
        }catch (InvalidInputException|NumberFormatException| NotFoundException e){
            Alert.showingError(e.getMessage());
        }
        ProjectFX.changingscene(stage,"clientFXML/contacts/ListOfAllContacts.fxml");
    }


    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/contacts/ListOfAllContacts.fxml");
    }

    private void ButtonHomeHandler() {
        stage=(Stage) ButtonHome.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }
}
