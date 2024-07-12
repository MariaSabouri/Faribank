package ir.ac.kntu.faribank.Controller;

import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.menu.MWelcome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
         launch();
//        MWelcome.getInstance().handle();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FXML_Loader.loadURL("welcome.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(FXML_Loader.loadURL("Style.css").toExternalForm());
        stage.setTitle("FaridBank");
        stage.setScene(scene);
        stage.show();
    }
}
