package ir.ac.kntu.faribank.Controller.client.Fund;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class detailController implements Initializable {
    @FXML
    private TextField AmountTextField;

    @FXML
    private Button DepositButton;

    @FXML
    private Label TypeLabel;

    @FXML
    private Label SaveLabel;

    @FXML
    private Button TransferButton;

    @FXML
    private Button backButton;

    @FXML
    private ListView<?> listView;

    private static Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        TransferButton.setOnMouseClicked(mouseEvent -> TransferButtonHandler());
        DepositButton.setOnMouseClicked(mouseEvent -> DepositButtonHandler());


//        SaveLabel.setText(?);
//        TypeLabel.setText(?);

        //todo



    }

    private void DepositButtonHandler() {
        if (AmountTextField.getText().isEmpty()){
            Alert.showingError("Please enter an amount");
        }else {
            //todo
        }
    }

    private void TransferButtonHandler() {
        if (AmountTextField.getText().isEmpty()){
            Alert.showingError("Please enter an amount");
        }else {
            //todo
        }
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/fund/FundChoice.fxml");
    }
}
