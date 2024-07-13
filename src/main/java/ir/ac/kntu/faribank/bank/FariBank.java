package ir.ac.kntu.faribank.bank;

import java.util.ArrayList;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.util.GenerateUniqueNumber;

public class FariBank implements Bank {
    private static final FariBank instance = new FariBank();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Client> newClients = new ArrayList<Client>();

    public static FariBank getInstance() {
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Client> getNewClients() {
        return newClients;
    }

    @Override
    public void addNewClient(Client newClient) throws DuplicatedItemException {
        if (clients.contains(newClient)) {
            throw new DuplicatedItemException("Duplicated Account has found! this (Phone Number or National ID) has already been taken.");
        } else if (newClients.contains(newClient)) {
            throw new DuplicatedItemException("This Account has already been created. Please wait until admin authenticates your account.");
        }

        newClients.add(newClient);
    }

    @Override
    public void addClient(Client newClient) {
        newClient.setAccountNumber(GenerateUniqueNumber.generate(10));
        newClient.setCardNumber(GenerateUniqueNumber.generate(16));

        clients.add(newClient);
        System.out.println("Client added successfully!\nNow Client has Account number and Card number.");
    }

    @Override
    public void addAdmin(Admin admin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAdmin'");
    }

}
