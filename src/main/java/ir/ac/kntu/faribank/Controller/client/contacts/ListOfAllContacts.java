package ir.ac.kntu.faribank.Controller.client.contacts;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.client.Contact;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ListOfAllContacts implements Initializable {
    @FXML
    private Button AddButton;

    @FXML
    private Button backButton;

    @FXML
    private ListView<BorderPane> listOfContactsListview;

    @FXML
    private ScrollPane scrollPane;


    private static Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        AddButton.setOnMouseClicked(mouseEvent -> AddButtonHandler());

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (Contact contact: HomeController.getClient().geContacts()){
            BorderPane borderPane=new BorderPane();
            Label Name=new Label(contact.getFirstName()+" "+contact.getLastName());
            borderPane.setLeft(Name);


            VBox vBox=new VBox();
            vBox.setAlignment(Pos.CENTER_LEFT);
            Button DeleteButton=new Button("Delete");
            VBox.setMargin(DeleteButton, new Insets(0, 0, 0, 80));
            DeleteButton.setStyle("-fx-background-color:  #D46262;");
            vBox.getChildren().add(DeleteButton);
            borderPane.setRight(DeleteButton);

            listOfContactsListview.getItems().add(borderPane);

            DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Are you sure you want to continue?");
                    alert.setContentText("Choose your option:");

                    ButtonType buttonContinue = new ButtonType("Continue");
                    ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(buttonContinue, buttonCancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == buttonContinue) {
                        try {
                            HomeController.getClient().deleteContact(contact);
                        }catch (NotFoundException e){
                            ir.ac.kntu.faribank.util.Alert.showingError(e.getMessage());
                        }
                    }
                    borderPane.setStyle("-fx-background-color:  #D46262;");
                    DeleteButton.setVisible(false);
                }
            });

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
        ProjectFX.changingscene(stage,"clientFXML/contacts/AddContacts.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }
}
