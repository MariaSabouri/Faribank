package ir.ac.kntu.faribank.menu;

import java.util.ArrayList;

import ir.ac.kntu.faribank.Controller.client.HomeController;
import ir.ac.kntu.faribank.Controller.commonControllers.LoginController;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.client.Client;
import org.json.JSONObject;

public class MLogin implements Menu {

    private static MLogin instance = new MLogin();

    public static MLogin getInstance() {
        return instance;
    }

    @Override
    public void handle(Person p) throws NotFoundException {
        Client c = (Client) p; // Person: Admin - Client
        ArrayList<Client> clients = FariBank.getInstance().getClients();

        int index = clients.indexOf(c);
        if (index == -1) {
            throw new NotFoundException();
        }

        Client foundedClient = clients.get(index);

        if (foundedClient.getAdminAuthenText().equals("null")) {
            LoginController.changeSceneToAuthen();
        } else if (foundedClient.getAdminAuthenText().isEmpty()) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("firstName", foundedClient.getFirstName());
            jsonObject.put("lastName", foundedClient.getLastName());
            jsonObject.put("cardNumber", foundedClient.getCardNumber());
            jsonObject.put("accountNumber", foundedClient.getAccountNumber());

            HomeController.SetUserInfo(jsonObject);
            LoginController.changeSceneToHome(); // GUI

            System.out.println("Login successfully!");
            System.out.println(clients.get(index).toString());
            System.out.println("Check Bank Class HashCode: " + FariBank.getInstance());
        } else {
            LoginController.changeSceneToSignUp(foundedClient.getAdminAuthenText());
        }
    }
}
