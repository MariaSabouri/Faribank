package ir.ac.kntu.faribank.Controller.client.transfer;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.client.Contact;
import ir.ac.kntu.faribank.util.Alert;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class TransferController implements Initializable {

    @FXML
    private ChoiceBox<String> ListOfRecentContactsChoiceBox;

    @FXML
    private ChoiceBox<String> contactListChoiceBox;

    @FXML
    private Label SelectDestinationAccount;

    @FXML
    private TextField TransferAmountTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private static Stage stage;

    private static Contact contactChosen;

    public static void setContactChosen(Contact contactChosen) {
        TransferController.contactChosen = contactChosen;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        submitButton.setOnMouseClicked(mouseEvent -> submitButtonHandler());

        ListOfRecentContactsChoiceBox.getItems().add("");
        contactListChoiceBox.getItems().add("");


        //recent contacts list
        ArrayList<Contact> recentContacts=HomeController.getClient().getRecentContacts();
        Collections.sort(recentContacts);
        for (Contact contact:recentContacts){

            ListOfRecentContactsChoiceBox.getItems().add(contact.getFirstName()+" "+contact.getLastName());

            ListOfRecentContactsChoiceBox.setOnAction(event -> {
                String value=ListOfRecentContactsChoiceBox.getValue();
                contactListChoiceBox.setValue("");
                if (!value.equals("")){
                    SelectDestinationAccount.setText(contact.getAccountNumber());
                    setContactChosen(contact);
                }else {
                    SelectDestinationAccount.setText(""); // Set default text to nothing
                }
            });

        }


        //contacts list
        for (Contact contact: HomeController.getClient().geContacts()) {

            contactListChoiceBox.getItems().add(contact.getFirstName() + " " + contact.getLastName());

            contactListChoiceBox.setOnAction(event -> {
                String value = contactListChoiceBox.getValue();
                ListOfRecentContactsChoiceBox.setValue("");
                if (!value.equals("")) {
                    SelectDestinationAccount.setText(contact.getAccountNumber());
                    setContactChosen(contact);
                }else {
                    SelectDestinationAccount.setText(""); // Set default text to nothing
                }
            });
        }
    }

    private void submitButtonHandler() {
        stage=(Stage) submitButton.getScene().getWindow();

        if (SelectDestinationAccount.getText()==""){
            Alert.showingError("Please choose a contact");
        }else {
            String destinationAccount =SelectDestinationAccount.getText();
            String TransferAmount=TransferAmountTextField.getText();
            PaymentConfirmationController.setContctChosen(destinationAccount,TransferAmount,contactChosen);

            ProjectFX.changingscene(stage,"clientFXML/transfer/PaymentConfirmation.fxml");
        }

    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }
}
