package ir.ac.kntu.faribank.Controller.admin.requests;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfNewClientsController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private ListView<BorderPane> RequestsLIstview;

    @FXML
    private ScrollPane scrollPane;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> LogOutButtonHandler());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (Client neclient:FariBank.getInstance().getNewClients()){
            BorderPane borderPane=new BorderPane();

            Label Name=new Label(neclient.getFirstName()+" "+neclient.getLastName());

            HBox hBox=new HBox();
            hBox.setSpacing(10.0);
            hBox.setAlignment(Pos.CENTER_LEFT);
            Label phonenumber=new Label(neclient.getPhoneNumber());
            Label comment=new Label(neclient.getAdminAuthenText());
            hBox.getChildren().add(comment);
            hBox.getChildren().add(phonenumber);

            borderPane.setLeft(Name);
            borderPane.setRight(hBox);
            RequestsLIstview.getItems().add(borderPane);

            if (neclient.getAdminAuthenText()!=null){
                borderPane.setStyle("-fx-background-color:  #D46262;");
            }
            
            borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage=(Stage) borderPane.getScene().getWindow();
                    NewClientsDetailsController.setClientDetail(neclient);
                    ProjectFX.changingscene(stage,"adminFXML/requests/NewClientsDetails.fxml");
                }
            });
        }
    }

    private void LogOutButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"adminFXML/AdminHomePage.fxml");
    }
}
