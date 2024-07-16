package ir.ac.kntu.faribank.Controller.client.Fund;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.FXML_Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FundChoiceController implements Initializable {

    @FXML
    private Button CreationButton;

    @FXML
    private ListView<String> ListView;

    @FXML
    private Label fundTypeLabel;

    @FXML
    private BorderPane BonusBorder;

    @FXML
    private BorderPane RemainigBorder;

    @FXML
    private BorderPane SavingBorder;

    @FXML
    private WebView BonusWebView;

    @FXML
    private WebView RemainWebview;

    @FXML
    private WebView savingWebview;

    @FXML
    private Button backButton;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        CreationButton.setOnMouseClicked(mouseEvent -> CreationButtonHandler());
        BonusBorder.setOnMouseClicked(mouseEvent -> BonusBorderHandler());
        RemainigBorder.setOnMouseClicked(mouseEvent -> RemainigBorderHandler());
        SavingBorder.setOnMouseClicked(mouseEvent -> SavingBorderHandler());

        BonusWebView.setPageFill(Color.TRANSPARENT);
        RemainWebview.setPageFill(Color.TRANSPARENT);
        savingWebview.setPageFill(Color.TRANSPARENT);

        BonusWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/bonus.svg")).toExternalForm());
        RemainWebview.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/remain.svg")).toExternalForm());
        savingWebview.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/saving.svg")).toExternalForm());

        //todo


    }

    private void SavingBorderHandler() {
        fundTypeLabel.setText("Savings fund");
    }

    private void RemainigBorderHandler() {
        fundTypeLabel.setText("Remaining fund");
    }

    private void BonusBorderHandler() {
        fundTypeLabel.setText("Bonus fund");
    }

    private void CreationButtonHandler() {
        stage=(Stage) CreationButton.getScene().getWindow();
        //todo
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }
}
