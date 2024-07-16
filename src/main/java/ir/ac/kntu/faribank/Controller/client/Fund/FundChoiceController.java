package ir.ac.kntu.faribank.Controller.client.Fund;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.client.fund.*;
import ir.ac.kntu.faribank.util.Alert;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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

        System.out.println(HomeController.getClient().getFunds());

        for (Fund fund: HomeController.getClient().getFunds()){
            ListView.getItems().add(fund.getType().toString());

             ListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     stage=(Stage) ListView.getScene().getWindow();
                     detailController.setFundDetails(fund);
                     ProjectFX.changingscene(stage,"clientFXML/fund/detail.fxml");
                 }
             });
        }


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
        System.out.println("salam");
        stage=(Stage) CreationButton.getScene().getWindow();
        Fund fund;
        if (fundTypeLabel.getText().equals("Savings fund")){
            fund=new Savings(FundType.SAVINGS,HomeController.getClient());
        } else if (fundTypeLabel.getText().equals("Remaining fund")) {
            fund=new Remaining(FundType.REMAINING,HomeController.getClient());
        }else {
            fund=new Bonus(FundType.BONUS,HomeController.getClient());
        }
        try {
            HomeController.getClient().addFund(fund);
        }catch (Exception e){
            e.printStackTrace();
            Alert.showingError(e.getMessage());
        }

    }

    private void backButtonHandler() {
        stage=(Stage) backButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"clientFXML/ClientHomePage.fxml");
    }
}
