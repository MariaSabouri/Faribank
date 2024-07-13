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
        Client client = (Client) p; // Person: Admin - Client
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
    
            HomeController.SetUserInfo(jsonObject);
            LoginController.changeSceneToHome(); // GUI
    
            System.out.println("Login successfully!");
            System.out.println(clients.get(index).toString());
            System.out.println("Check Bank Class HashCode: " + FariBank.getInstance());
        }
    }
}
