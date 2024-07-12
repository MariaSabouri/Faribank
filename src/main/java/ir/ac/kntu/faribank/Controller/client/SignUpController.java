package ir.ac.kntu.faribank.Controller.client;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.Controller.commonControllers.LoginController;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.menu.client.MSignUp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField NationalID;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    private Button signUpButton;

    private static Stage stage;

    public static void changeSceneToHome() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnMouseClicked(mouseEvent -> loginButtonHandler());
        signUpButton.setOnMouseClicked(mouseEvent -> signUpButtonHandler());

        signUpBorderPane.setBackground(new Background(new BackgroundFill(Color.web("3387CC"), null, null)));

    }

    private void signUpButtonHandler() {
        stage = (Stage) signUpButton.getScene().getWindow();

        String Name = NameField.getText();
        String LastName = LastNameField.getText();
        String nationalID = NationalID.getText();
        String phoneNumber = PhoneNumber.getText();
        String password = passwordField.getText();

        MSignUp mSignUp = new MSignUp(Name, LastName, nationalID, phoneNumber, password);
        try {
            mSignUp.check();
        } catch (InvalidInputException e) {
            e.getMessage();
        }

    }

    private void loginButtonHandler() {
        stage = (Stage) loginButton.getScene().getWindow();

        LoginController.setLoginLabel("Customer");
        ProjectFX.changingscene(stage, "login-view.fxml");

    }
}
