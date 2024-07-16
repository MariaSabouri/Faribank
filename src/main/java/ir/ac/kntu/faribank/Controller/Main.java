package ir.ac.kntu.faribank.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import ir.ac.kntu.faribank.Database;
import org.apache.bcel.generic.InstructionConstants.Clinit;
import org.json.JSONArray;
import org.json.JSONObject;

import ir.ac.kntu.faribank.FXML_Loader;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
        // Exit: Update DB
//        try {
//            FileWriter fileWriter = new FileWriter("./fariBank.json", false);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            PrintWriter printWriter = new PrintWriter(bufferedWriter);
//            JSONObject jsonObject = new JSONObject();
//
//            jsonObject.put("clients", new JSONArray(FariBank.getInstance().getClients().stream().map(Client::toJson).toArray()));
//            jsonObject.put("newClients", new JSONArray(FariBank.getInstance().getNewClients().stream().map(Client::toJson).toArray()));
//
//            printWriter.write(jsonObject.toString());
//            printWriter.flush();
//            printWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            Database.getConn().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FXML_Loader.loadURL("welcome.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(FXML_Loader.loadURL("Style.css").toExternalForm());
        stage.setTitle("FaridBank");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
