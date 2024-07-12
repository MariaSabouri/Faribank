package ir.ac.kntu.faribank.menu;

import java.util.ArrayList;
import ir.ac.kntu.faribank.Controller.client.SignUpController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.NotFooundException;
import ir.ac.kntu.faribank.bank.client.Client;

public class MLogin implements Menu {

    private static MLogin instance = new MLogin();

    public static MLogin getInstance() {
        return instance;
    }

    @Override
    public void handle(Person p) throws NotFooundException {
        Client c = (Client) p; // Person: Admin - Client
        ArrayList<Client> clients = FariBank.getInstance().getClients();
        int index = clients.indexOf(c);

        if (index == -1) {
            throw new NotFooundException();
        } else {
            System.out.println(clients.get(index).toString());
        }

        SignUpController.changeSceneToHome();
    }

}
