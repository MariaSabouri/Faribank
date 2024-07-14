package ir.ac.kntu.faribank.menu.admin;

import java.util.ArrayList;

import ir.ac.kntu.faribank.Controller.admin.NewClientsDetailsController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.client.Client;

public class MNewClientsDetails {

    private static MNewClientsDetails instance = new MNewClientsDetails();

    public static MNewClientsDetails getInstance() {
        return instance;
    }

    public void accept(Client newClient) {
        newClient.setAdminAuthenText("");
        ArrayList<Client> newClients = FariBank.getInstance().getNewClients();

        newClients.remove(newClient);
        FariBank.getInstance().addClient(newClient);

        NewClientsDetailsController.ChangeSceneToListOfNewClients();
    }

    public void reject(Client client, String adminAuthenText) {
        client.setAdminAuthenText(adminAuthenText);

        System.out.println("**Rejected:" + client);

        NewClientsDetailsController.ChangeSceneToListOfNewClients();
    }
}
