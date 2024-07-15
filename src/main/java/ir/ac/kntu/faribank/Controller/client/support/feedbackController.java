package ir.ac.kntu.faribank.Controller.client.support;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.client.support.Feature;
import ir.ac.kntu.faribank.bank.client.support.Request;
import ir.ac.kntu.faribank.bank.client.support.StateOfRequest;
import ir.ac.kntu.faribank.util.Alert;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class feedbackController implements Initializable {

    @FXML
    private AnchorPane ContactsAnchor;

    @FXML
    private AnchorPane SettingAnchor;

    @FXML
    private AnchorPane TransferAnchor;

    @FXML
    private AnchorPane depositAnchor;

    @FXML
    private WebView depositWebView;

    @FXML
    private WebView ContactsWebView;

    @FXML
    private WebView SettingWebView;

    @FXML
    private WebView TransferWebView;

    @FXML
    private Label sectionfeedbackLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextArea TextArea;

    @FXML
    private ChoiceBox<String> feedbackChoicebox;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        depositWebView.setPageFill(Color.TRANSPARENT);
        ContactsWebView.setPageFill(Color.TRANSPARENT);
        SettingWebView.setPageFill(Color.TRANSPARENT);
        TransferWebView.setPageFill(Color.TRANSPARENT);

        depositWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/deposit.svg")).toExternalForm());
        ContactsWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Contacts.svg")).toExternalForm());
        SettingWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Settings.svg")).toExternalForm());
        TransferWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/Transfer.svg").toExternalForm()));

        depositAnchor.setOnMouseClicked(mouseEvent -> depositAnchorHandler());
        ContactsAnchor.setOnMouseClicked(mouseEvent -> ContactsAnchorHandler());
        SettingAnchor.setOnMouseClicked(mouseEvent -> SettingAnchorHandler());
        TransferAnchor.setOnMouseClicked(mouseEvent -> TransferAnchorHandler());

        BackButton.setOnMouseClicked(mouseEvent -> BackButtonHandler());
        submitButton.setOnMouseClicked(mouseEvent -> submitButtonHandler());

        ArrayList<Request> requests=HomeController.getClient().getRequests();
        Collections.sort(requests);

        feedbackChoicebox.getItems().add("");
        for (Request request: requests){

            feedbackChoicebox.getItems().add(request.getDate().toString());
            feedbackChoicebox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage=(Stage) feedbackChoicebox.getScene().getWindow();
                    FeedbackDetail.setRequest(request);
                    ProjectFX.changingscene(stage,"clientFXML/support/feedbackDetail.fxml");
                }
            });

        }
    }

    private void submitButtonHandler() {
        stage=(Stage) submitButton.getScene().getWindow();

        if (sectionfeedbackLabel.getText().isEmpty()){
            Alert.showingError("Please Select a section among Transfer,Setting,Contacts,Deposit");
        }

        Request request;
        switch (sectionfeedbackLabel.getText()){
            case "Transfer" -> {
                request = new Request(Feature.TRANSFER, TextArea.getText());
            } case "Setting" -> {
                request = new Request(Feature.SETTINGS, TextArea.getText());
            } case "Contacts" -> {
                request = new Request(Feature.CONTACTS, TextArea.getText());
            } default -> {
                request = new Request(Feature.DEPOSIT, TextArea.getText());
            }
        }

        HomeController.getClient().addRequest(request);

        ProjectFX.changingscene(stage,"clientFXML/support/feedbackDetail.fxml");

    }

    private void BackButtonHandler() {
        stage=(Stage) BackButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }

    private void TransferAnchorHandler() {
        sectionfeedbackLabel.setText("Transfer");
    }

    private void SettingAnchorHandler() {
        sectionfeedbackLabel.setText("Setting");
    }

    private void ContactsAnchorHandler() {
        sectionfeedbackLabel.setText("Contacts");
    }

    private void depositAnchorHandler() {
        sectionfeedbackLabel.setText("Deposit");
    }
}
