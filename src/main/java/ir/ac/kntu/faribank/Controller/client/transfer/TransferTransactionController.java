package ir.ac.kntu.faribank.Controller.client.transfer;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.client.transaction.TTransfer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferTransactionController implements Initializable {

    @FXML
    private Label DateLabel;

    @FXML
    private Label DestinationAccountLabel;

    @FXML
    private Label FromLabel;

    @FXML
    private Button HomeButton;

    @FXML
    private Label IssueTrackingLabel;

    @FXML
    private Label ProvenanceAccountLabel;

    @FXML
    private Label ToLabel;

    @FXML
    private Label bankfeeLabel;

    @FXML
    private Label newBalanceLabel;

    @FXML
    private Label transferLabel;

    private static Stage stage;

    private static TTransfer tTransfer;

    public static void settTransfer(TTransfer tTransfer){
        TransferTransactionController.tTransfer=tTransfer;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HomeButton.setOnMouseClicked(mouseEvent -> HomeButtonHandler());
        DateLabel.setText(tTransfer.getDate().toString());
        FromLabel.setText(tTransfer.getFrom());
        ToLabel.setText(tTransfer.getTo());
        IssueTrackingLabel.setText(tTransfer.getTrackingCode());
        DestinationAccountLabel.setText(tTransfer.getToAccountNumber());
        ProvenanceAccountLabel.setText(tTransfer.getFromAccountNumber());
        bankfeeLabel.setText(String.valueOf(tTransfer.getBankFee()));
        newBalanceLabel.setText(String.valueOf(tTransfer.getNewBalance()));
        transferLabel.setText(String.valueOf(tTransfer.getTransfer()));

    }

    private void HomeButtonHandler() {
        stage=(Stage) HomeButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }
}
