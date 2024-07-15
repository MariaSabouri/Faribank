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
    private ArrayList<Admin> admins = new ArrayList<Admin>();

    public static FariBank getInstance() {
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Client> getNewClients() {
        return newClients;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    @Override
    public void addNewClient(Client newClient) throws DuplicatedItemException {
        if (clients.contains(newClient)) {
            throw new DuplicatedItemException("Duplicated Account has found! this (Phone Number or National ID) has already been taken.");
        } else if (newClients.contains(newClient)) {
            throw new DuplicatedItemException("This Account has already been created with (Phone Number or National ID). Please wait until admin authenticates your account.");
        }

        newClients.add(newClient);
        System.out.println("New Client was added successfully!\n-->Authenticating...");
        System.out.println(newClient);
    }

    @Override
    public void addClient(Client newClient) {
        newClient.setAccountNumber(GenerateUniqueNumber.generate(10));
        newClient.setCardNumber(GenerateUniqueNumber.generate(16));

        clients.add(newClient);
        System.out.println("Client added successfully!\nNow Client has Account number and Card number.");
        System.out.println(newClient);
    }

    @Override
    public void addAdmin(Admin admin) {
        admins.add(admin);
        System.out.println("Admin added successfully!");
        System.out.println(admin);
    }

}
