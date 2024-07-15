package ir.ac.kntu.faribank.Controller.client.support;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.support.Request;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class FeedbackDetail implements Initializable {



    @FXML
    private Label SectionLabel;

    @FXML
    private Text adminComment;

    @FXML
    private Button backButton;

    @FXML
    private Text clientComment;

    @FXML
    private Label stateLabel;

    private static Stage stage;

    private static Request request;

    public static void setRequest(Request request) {
        System.out.println("TEST" + request);
        FeedbackDetail.request=request;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());

        try {
            stateLabel.setText(request.getStateOfRequest().toString());
        } catch (Exception e) {
            stateLabel.setText("-");
        }

        try {
            SectionLabel.setText(request.getFeature().toString());
        } catch (Exception e) {
            SectionLabel.setText("-");
        }

        try {
            adminComment.setText(request.getFeedbackText());
        } catch (Exception e) {
            adminComment.setText("-");
        }

        try {
            clientComment.setText(request.getRequestText());
        } catch (Exception e) {
            clientComment.setText("-");
        }





    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/support/Feedback.fxml");
    }
}
