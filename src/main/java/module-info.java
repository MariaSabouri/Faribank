module ir.ac.kntu.faribank {
    requires javafx.controls;
    requires javafx.fxml;


    opens ir to javafx.fxml;
    exports ir;
}