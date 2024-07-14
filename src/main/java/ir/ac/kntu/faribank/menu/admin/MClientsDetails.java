package ir.ac.kntu.faribank.menu.admin;

import ir.ac.kntu.faribank.Controller.admin.NewClientsDetailsController;
import ir.ac.kntu.faribank.bank.client.Client;

public class MClientsDetails {

    private static MClientsDetails instance = new MClientsDetails();

    public static MClientsDetails getInstance() {
        return instance;
    }

    public void accept(Client client) {
        client.setAdminAuthenText("");

        NewClientsDetailsController.ChangeSceneToListOfNewClients();
    }

    public void reject(Client client, String adminAuthenText) {
        client.setAdminAuthenText(adminAuthenText);

        NewClientsDetailsController.ChangeSceneToListOfNewClients();
    }
}
