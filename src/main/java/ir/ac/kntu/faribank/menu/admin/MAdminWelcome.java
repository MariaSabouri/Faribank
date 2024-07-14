package ir.ac.kntu.faribank.menu.admin;

import ir.ac.kntu.faribank.Controller.admin.ListOfNewClientsController;
import ir.ac.kntu.faribank.bank.FariBank;

public class MAdminWelcome {

    private static MAdminWelcome instance = new MAdminWelcome();

    public static MAdminWelcome getInstance() {
        return instance;
    }

    public void authenticationBtn() {
        ListOfNewClientsController.setNewClients(FariBank.getInstance().getNewClients());
    }

    public void requestsBtn() {

    }

}
