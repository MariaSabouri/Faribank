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

    private void checkInput(Client newClient) throws InvalidInputException {
        if (newClient.getPhoneNumber().length() != 11) {
            throw new InvalidInputException("Phone Number'length must be 11 digits.");
        } else if (!newClient.getPhoneNumber().matches("[0-9]{11}")) {
            throw new InvalidInputException("Phone Number should only contain digits (0-9).");
        }

        if (newClient.getPassword().matches("\\s")) {
            throw new InvalidInputException("Invalid password, because it has space (' ') character.");
        } else if (!newClient.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).+$")) {
            throw new InvalidInputException(
                    "The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        }
    }

    public void handle(Client newClient) throws InvalidInputException, DuplicatedItemException {
        checkInput(newClient);
        FariBank.getInstance().addNewClient(newClient);

        SignUpController.changeSceneToAuthentication(); // GUI

        System.out.println("NewClients: " + FariBank.getInstance().getNewClients());
    }
}
