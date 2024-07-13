package ir.ac.kntu.faribank.Controller.commonControllers;

import ir.ac.kntu.faribank.Controller.ProjectFX;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.menu.MLogin;
import ir.ac.kntu.faribank.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Label LoginLabel;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private BorderPane loginBorderPane;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;
    @FXML
    private Label DoNotHaveAnAccountLAbel;

    private static String LabelText;
    private static Stage stage;

    public static void setLoginLabel(String text) {
        LabelText=text;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackButton.setOnMouseClicked(mouseEvent -> BackButtonHandler());
        signUpButton.setOnMouseClicked(mouseEvent -> signUpButtonHandler());
        loginButton.setOnMouseClicked(mouseEvent -> loginButtonHandler());


        if (LabelText.equals("Customer")){
            loginBorderPane.setBackground(new Background(new BackgroundFill(Color.web("3387CC"), null, null)));
            LoginLabel.setText("Client - Login");
        }else {
            DoNotHaveAnAccountLAbel.setVisible(false);
            signUpButton.setVisible(false);
            loginBorderPane.setBackground(new Background(new BackgroundFill(Color.web("4F51a5"), null, null)));
            LoginLabel.setText("Admin - Login");
        }
    }

    private void loginButtonHandler() {
        stage=(Stage) loginButton.getScene().getWindow();

        String phoneNumber=PhoneNumber.getText();
        String password=passwordField.getText();

        if (LabelText.equals("Customer")){
            try {
                MLogin.getInstance().handle(new Client(phoneNumber, password, "", "", ""));
            } catch (NotFoundException e) {
                Alert.showingError(e.getMessage());
            }finally {
                PhoneNumber.clear();
                passwordField.clear();
            }

        }else {
            //todo
        }

    }

    public static void changeSceneToHome() {ProjectFX.changingscene(stage,"ClentHomePage.fxml");}
    public static void changeSceneToAuthen() {ProjectFX.changingscene(stage,"Authentication.fxml");}
    public static void changeSceneToSignUp(String errMessage) {
        ProjectFX.changingscene(stage,"signUp-view.fxml");
        Alert.showingError(errMessage);
    }

    private void signUpButtonHandler() {
        stage=(Stage) signUpButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"signUp-view.fxml");
    }

    private void BackButtonHandler() {
        stage=(Stage) BackButton.getScene().getWindow();
        ProjectFX.changingscene(stage,"welcome.fxml");
    }
}
