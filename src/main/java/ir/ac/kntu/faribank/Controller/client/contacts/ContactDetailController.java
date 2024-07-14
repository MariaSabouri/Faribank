package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Contact;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactDetailController implements Initializable {

    @FXML
    private Button ButtonHome;

    @FXML
    private Button backButton;

    @FXML
    private Label AccountNumberLabel;

    @FXML
    private Label LastNameLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label phoneLabel;

    private static Stage stage;

    private static Contact contactDetail;

    public static void setContactDetail(Contact contact) {
        contactDetail=contact;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ButtonHome.setOnMouseClicked(mouseEvent -> ButtonHomeHandler());
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());

        NameLabel.setText(contactDetail.getFirstName());
        LastNameLabel.setText(contactDetail.getLastName());
        phoneLabel.setText(contactDetail.getPhoneNumber());
        AccountNumberLabel.setText(String.valueOf(contactDetail.getAccountNumber()));

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
