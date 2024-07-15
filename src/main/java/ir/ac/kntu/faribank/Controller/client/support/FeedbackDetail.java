package ir.ac.kntu.faribank.Controller.client.support;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.support.Request;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class FeedbackDetail implements Initializable {
    @FXML
    private Text ClientfeedText;

    @FXML
    private Text adminFeedText;

    @FXML
    private Button backButton;

    @FXML
    private Label stateLabel;

    private static Stage stage;

    private static Request request;

    public static void setRequest(Request request) {
        FeedbackDetail.request=request;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());

        //todo

    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/support/Feedback.fxml");
    }
}
