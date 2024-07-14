package ir.ac.kntu.faribank.Controller.admin;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewClientsDetailsController implements Initializable {
    @FXML
    private Label NameLabel;

    @FXML
    private Label NationslidLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Label PhoneNumberLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button AcceptButton;

    @FXML
    private Button RejectButton;

    @FXML
    private Label lastNameLabel;
    private static Stage stage;

    private static Client ClientDetail;

    public static void setClientDetail(Client clientDetail) {
        ClientDetail = clientDetail;
    }
    public static void ChangeSceneToListOfNewClients(){
        ProjectFX.changingscene(stage,"ListOfNewClients.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        AcceptButton.setOnMouseClicked(mouseEvent -> AcceptButtonHandler());
        RejectButton.setOnMouseClicked(mouseEvent -> RejectButtonHandler());

        NameLabel.setText(ClientDetail.getFirstName());
        lastNameLabel.setText(ClientDetail.getLastName());
        NationslidLabel.setText(ClientDetail.getNationalCodeID());
        PhoneNumberLabel.setText(ClientDetail.getPhoneNumber());
        PasswordLabel.setText(ClientDetail.getPassword());
    }

    private void RejectButtonHandler() {
        stage=(Stage) RejectButton.getScene().getWindow();
    }

    private void AcceptButtonHandler() {
        stage=(Stage) AcceptButton.getScene().getWindow();
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"ListOfNewClients.fxml");
    }
}
