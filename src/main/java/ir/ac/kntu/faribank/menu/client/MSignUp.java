package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.Controller.client.SignUpController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;

public class MSignUp {

    private static MSignUp instance = new MSignUp();

    public static MSignUp getInstance() {
        return instance;
    }

    public void handle(Client newClient) throws InvalidInputException, DuplicatedItemException {
        FariBank.getInstance().addNewClient(newClient);

        SignUpController.changeSceneToAuthentication(); // GUI
    }
}
