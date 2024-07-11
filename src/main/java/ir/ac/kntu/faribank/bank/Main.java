package ir.ac.kntu.faribank.bank;

import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.MWelcome;
import ir.ac.kntu.faribank.menu.client.MLoginClient;
import ir.ac.kntu.faribank.util.ScannerWrapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch();
        MWelcome.Role option = null;
        MWelcome.getInstance().printMenu();

        while (option != MWelcome.Role.EXIT) {
            try {
                option = MWelcome.getInstance().getOption();
            } catch (InvalidInputExeption e) {
                e.printStackTrace();
            }

            switch (option) {
                case CLIENT -> {
                    MLoginClient.getInstance().printMenu();
                    
                }
                case ADMIN -> {

                }
                default -> {
                    ScannerWrapper.getInstance().close();
                }
            }
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FXML_Loader.loadURL("welcome.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("FaridBank");
        stage.setScene(scene);
        stage.show();
    }
}
