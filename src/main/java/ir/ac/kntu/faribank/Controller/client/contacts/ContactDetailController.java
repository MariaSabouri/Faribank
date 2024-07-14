package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Contact;
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
    private TextField LastNameTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField PhonTextField;

    @FXML
    private Button EdditButton;


    @FXML
    private Button SaveButton;


    @FXML
    private Button backButton;

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
        PhonTextField.setText(contactDetail.getPhoneNumber());
        AccountTextField.setText(String.valueOf(contactDetail.getAccountNumber()));

        SaveButton.setDisable(true);
        NameTextField.setEditable(false);
        LastNameTextField.setEditable(false);
        PhonTextField.setEditable(false);
        AccountTextField.setEditable(false);

    }

    private void EdditButtonHandler() {
        SaveButton.setDisable(false);
        NameTextField.setEditable(true);
        LastNameTextField.setEditable(true);
        PhonTextField.setEditable(true);
        AccountTextField.setEditable(true);
    }

    private void SaveButtonHandler() {
        //todo
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
