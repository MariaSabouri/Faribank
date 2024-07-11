module ir.ac.kntu.faribank {
    requires javafx.controls;
    requires javafx.fxml;

    exports ir.ac.kntu.faribank to javafx.graphics;
    exports ir.ac.kntu.faribank.Bank.Admin.Controller to javafx.fxml;

    opens ir.ac.kntu.faribank.Bank.Admin.Controller to javafx.fxml;
    opens ir.ac.kntu.faribank to javafx.fxml;
}