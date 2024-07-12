package ir.ac.kntu.faribank.Controller;

import ir.ac.kntu.faribank.FXML_Loader;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjectFX {
    public static void changingscene(Stage stage, String fxml){
        Platform.runLater(() -> {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(FXML_Loader.loadURL(fxml));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(FXML_Loader.loadURL("Style.css").toExternalForm());

                stage.setScene(scene);

                stage.show();
            }catch (IOException e){
                System.out.println("There is an error in changing scene");
                e.printStackTrace();}
        });
    }

}
