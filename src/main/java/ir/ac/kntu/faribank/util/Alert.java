package ir.ac.kntu.faribank.util;

public class Alert {
    public static void showingError(String errMessage){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(errMessage);
        alert.showAndWait();
    }
}
