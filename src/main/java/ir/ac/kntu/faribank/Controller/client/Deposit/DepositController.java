package ir.ac.kntu.faribank.Controller.client.Deposit;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DepositController implements Initializable {
    @FXML
    private Button depositButton;

    @FXML
    private TextField depositText;

    @FXML
    private WebView depositWebView;
    @FXML
    private Button backButton;

    private static Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        depositButton.setOnMouseClicked(mouseEvent -> depositButtonHandler());
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());

        depositWebView.setPageFill(Color.TRANSPARENT);
        depositWebView.getEngine().load(Objects.requireNonNull(FXML_Loader.loadURL("images/deposit.svg")).toExternalForm());
    }

    public static void changeSceneToDisposeTransaction(){
        ProjectFX.changingscene(stage, "clientFXML/deposit/DepositTransaction.fxml");
    }
    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/deposit/deposit.fxml");
    }

    private void depositButtonHandler() {
        stage=(Stage) depositButton.getScene().getWindow();
        String depositValue=depositText.getText();

         try {
            HomeController.getClient().deposit(depositValue);
         }catch (NumberFormatException | InvalidAmountException e){
            e.printStackTrace();
            Alert.showingError(e.getMessage());
         }
    }
}
