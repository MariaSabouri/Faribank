package ir.ac.kntu.faribank.Controller.client.Fund;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.Deposit.DepositTransactioWithoutListOfTransactionBtnController;
import ir.ac.kntu.faribank.Controller.client.Deposit.TransferDetailsController;
import ir.ac.kntu.faribank.bank.Errors.InsufficientFundsException;
import ir.ac.kntu.faribank.bank.Errors.InvalidAmountException;
import ir.ac.kntu.faribank.bank.client.fund.Fund;
import ir.ac.kntu.faribank.bank.client.fund.Savings;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;
import ir.ac.kntu.faribank.util.Alert;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
    private ListView<BorderPane> listView;

    private static Stage stage;

    private static Fund fund;

    public static void setFundDetails(Fund fund) {
        detailController.fund=fund;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        TransferButton.setOnMouseClicked(mouseEvent -> TransferButtonHandler());
        DepositButton.setOnMouseClicked(mouseEvent -> DepositButtonHandler());


        SaveLabel.setText(String.valueOf(fund.getSave()));
        TypeLabel.setText(fund.getType().toString());

        for (Transaction transaction:fund.getTransactions()){
            BorderPane borderPane=new BorderPane();

            Label left=new Label(transaction.getDate().toString());
            Label right=new Label(transaction.getClass().getSimpleName());

            borderPane.setLeft(left);
            borderPane.setRight(right);

            listView.getItems().add(borderPane);

            borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage=(Stage) borderPane.getScene().getWindow();
                    if (transaction.getClass().getSimpleName().equals("TTransfer")){
                        TransferDetailsController.setTransactionDetails(transaction);
                        ProjectFX.changingscene(stage,"clientFXML/transfer/TransferTransaction.fxml");
                    }else {
                        DepositTransactioWithoutListOfTransactionBtnController.setTransactionDetails(transaction);
                        ProjectFX.changingscene(stage,"clientFXML/deposit/DepositTransactioWithoutListOfTransactionBtn.fxml");
                    }
                }
            });





        }



    }

    private void DepositButtonHandler() {
        if (AmountTextField.getText().isEmpty()){
            Alert.showingError("Please enter an amount");
        }else {
            try {
                fund.deposit(AmountTextField.getText());
            } catch (InsufficientFundsException|InvalidAmountException e) {
                e.printStackTrace();
                Alert.showingError(e.getMessage());
            }
        }
    }

    private void TransferButtonHandler() {
        if (AmountTextField.getText().isEmpty()){
            Alert.showingError("Please enter an amount");
        }else {
            try {
                fund.transfer(AmountTextField.getText());
            } catch (InsufficientFundsException|InvalidAmountException e) {
                e.printStackTrace();
                Alert.showingError(e.getMessage());
            }
        }
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/fund/FundChoice.fxml");
    }
}
