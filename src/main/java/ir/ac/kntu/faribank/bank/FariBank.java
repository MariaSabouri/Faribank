package ir.ac.kntu.faribank.bank;

import java.util.ArrayList;
import ir.ac.kntu.faribank.bank.Errors.duplicatedItemException;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.util.GenerateUniqueNumber;

public class FariBank implements Bank {
    private static FariBank instance = new FariBank();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public static FariBank getInstance() {
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public void add(Person p) throws duplicatedItemException {
        Client client = (Client) p; // Person: Admin - Client

        if (clients.contains(client)) {
            throw new duplicatedItemException();
        } else {
            client.setAccountNumber(GenerateUniqueNumber.generate(10));
            client.setCardNumber(GenerateUniqueNumber.generate(16));
            clients.add(client);
        }
    }

}
