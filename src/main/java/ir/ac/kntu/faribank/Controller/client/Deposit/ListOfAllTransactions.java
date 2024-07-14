package ir.ac.kntu.faribank.Controller.client.Deposit;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.bank.client.transaction.Transaction;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListOfAllTransactions implements Initializable {
    @FXML
    private ListView<BorderPane> LIstview;

    @FXML
    private Button backButton;

    @FXML
    private Button HomeButton;

    @FXML
    private ScrollPane scrollPane;

    private static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(mouseEvent -> backButtonHandler());
        HomeButton.setOnMouseClicked(mouseEvent -> HomeButtonHandler());

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        ArrayList<Transaction> transactions= HomeController.getClient().getTransactions();
        transactions.sort((t1, t2) -> t1.getDate().compareTo(t2.getDate()));

        for (Transaction t:transactions){
            BorderPane borderPane=new BorderPane();

            Label date=new Label(t.getDate().toString());
            Label transactioState=new Label(t.getClass().getSimpleName());

            borderPane.setLeft(date);
            borderPane.setRight(transactioState);

            LIstview.getItems().add(borderPane);

            borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage=(Stage) borderPane.getScene().getWindow();
                    if (t.getClass().getSimpleName().equals("TTransfer")){
                        TransferDetailsController.setTransactionDetails(t);
                        ProjectFX.changingscene(stage,"clientFXML/deposit/AddContacts.fxml");
                    }else {
                        DepositTransactioWithoutListOfTransactionBtnController.setTransactionDetails(t);
                        ProjectFX.changingscene(stage,"clientFXML/deposit/DepositTransactioWithoutListOfTransactionBtn.fxml");
                    }
                }
            });


        }



    }

    private void HomeButtonHandler() {
        stage=(Stage) HomeButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClentHomePage.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/deposit/DepositTransaction.fxml");
    }
}
