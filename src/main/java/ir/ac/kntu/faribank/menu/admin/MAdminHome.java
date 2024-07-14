package ir.ac.kntu.faribank.menu.admin;

import ir.ac.kntu.faribank.Controller.admin.AdminHomePageController;
import ir.ac.kntu.faribank.Controller.admin.ListOfNewClientsController;
import ir.ac.kntu.faribank.bank.FariBank;

public class MAdminHome {

    private static MAdminHome instance = new MAdminHome();

    public static MAdminHome getInstance() {
        return instance;
    }

    public void authenticationBtn() {
        ListOfNewClientsController.setNewClients(FariBank.getInstance().getNewClients());
        AdminHomePageController.changeSceneTONewClientsDetails();
    }

    public void requestsBtn() {
        
    }

}
