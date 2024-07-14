package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
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
import java.util.Collections;
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

        ArrayList<Transaction> transactions=HomeController.getClient().getTransactions();
        Collections.sort(transactions);

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
                        ProjectFX.changingscene(stage,"TransferDetails.fxml");
                    }else {
                        DepositTransactioWithoutListOfTransactionBtnController.setTransactionDetails(t);
                        ProjectFX.changingscene(stage,"DepositTransactioWithoutListOfTransactionBtn.fxml");
                    }
                }
            });


        }



    }

    private void HomeButtonHandler() {
        stage=(Stage) HomeButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"ClentHomePage.fxml");
    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"DepositTransaction.fxml");
    }
}
