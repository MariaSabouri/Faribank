package ir.ac.kntu.faribank.menu.admin;

import java.util.ArrayList;

import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.client.Client;

public class MAuthentication {

    private static MAuthentication instance = new MAuthentication();

    public static MAuthentication getInstance() {
        return instance;
    }

    public ArrayList<Client> authenticationBtn() {
        return FariBank.getInstance().getNewClients();
    }

    public void requestsBtn() {

    }

}
