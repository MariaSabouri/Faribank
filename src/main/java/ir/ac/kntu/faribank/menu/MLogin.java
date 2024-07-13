package ir.ac.kntu.faribank.menu;

import java.util.ArrayList;

import ir.ac.kntu.faribank.Controller.admin.AdminHomePageController;
import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.Controller.commonControllers.LoginController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;
import org.json.JSONObject;

public class MLogin {

    private static MLogin instance = new MLogin();

    public static MLogin getInstance() {
        return instance;
    }

    public void clientLogin(Client client) throws NotFoundException {
        ArrayList<Client> clients = FariBank.getInstance().getClients();
        ArrayList<Client> newClients = FariBank.getInstance().getNewClients();

        int i = newClients.indexOf(client);
        if (i != -1) {
            Client foundedNewClient = clients.get(i);

            if (foundedNewClient.getAdminAuthenText().length() > 0) {
                LoginController.changeSceneToSignUp(foundedNewClient.getAdminAuthenText());
            } else {
                LoginController.changeSceneToAuthen();
            }

        } else {
            int index = clients.indexOf(client);
            if (index == -1) {
                throw new NotFoundException();
            }

            Client foundedClient = clients.get(index);

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("firstName", foundedClient.getFirstName());
            jsonObject.put("lastName", foundedClient.getLastName());
            jsonObject.put("cardNumber", foundedClient.getCardNumber());
            jsonObject.put("accountNumber", foundedClient.getAccountNumber());

            HomeController.setUserInfo(jsonObject);
            LoginController.changeSceneToHome(); // GUI

            System.out.println("Login successfully!");
            System.out.println(clients.get(index));
            System.out.println("Check Bank Class HashCode: " + FariBank.getInstance());
        }
    }

    public void adminLogin(Admin admin) throws NotFoundException {
        ArrayList<Admin> admins = FariBank.getInstance().getAdmins();

        int index = admins.indexOf(admin);
        if (index == -1) {
            throw new NotFoundException();
        }

        Admin foundedClient = admins.get(index);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("firstName", foundedClient.getFirstName());
        jsonObject.put("lastName", foundedClient.getLastName());

        AdminHomePageController.setUserInfo(jsonObject);
        LoginController.changeSceneToAdminHome(); // GUI

        System.out.println("Login successfully!");
        System.out.println(admins.get(index));
        System.out.println("Check Bank Class HashCode: " + FariBank.getInstance());
    }
}
