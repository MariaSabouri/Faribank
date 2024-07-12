package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.Controller.client.SignUpController;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.menu.Menu;

public class MSignUp implements Menu {

    private static MSignUp instance = new MSignUp();

    public static MSignUp getInstance() {
        return instance;
    }

    @Override
    public void handle(Person client) throws InvalidInputException, DuplicatedItemException  {
        if (client.getPhoneNumber().length() != 11) {
            throw new InvalidInputException("Phone Number'length must be 11 digits.");
        } else if (!client.getPhoneNumber().matches("[0-9]{11}")) {
            throw new InvalidInputException("Phone Number should only contain digits (0-9).");
        }

        if (client.getPassword().matches("\\s")) {
            throw new InvalidInputException("Invalid password, because it has space (' ') character.");
        } else if (!client.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).+$")) {
            throw new InvalidInputException(
                    "The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        }

        FariBank.getInstance().add(client);

        SignUpController.changeSceneToHome(); // GUI

        System.out.println("Client added successfully!");
        System.out.println(client.toString());
        System.out.println("Check Bank Class HashCode: " + FariBank.getInstance());
    }
}
