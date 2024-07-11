module ir.ac.kntu.faribank {
    requires javafx.controls;
    requires javafx.fxml;


    opens ir.ac.kntu.faribank to javafx.fxml;
    exports ir.ac.kntu.faribank;
}