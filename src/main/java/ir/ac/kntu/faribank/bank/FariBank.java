package ir.ac.kntu.faribank.bank;

import java.util.ArrayList;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;
import ir.ac.kntu.faribank.util.GenerateUniqueNumber;

public class FariBank implements Bank {
    private static final FariBank instance = new FariBank();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public static FariBank getInstance() {
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public void addClient(Client client) throws DuplicatedItemException {
        if (clients.contains(client)) {
            if (client.getAdminAuthenText().equals("")) {
                throw new DuplicatedItemException("Duplicated Account (Phone Number or National ID) has found!");
            } else if (client.getAdminAuthenText().equals(null)) {
                throw new DuplicatedItemException("This Account has already be created. Please wait until admin authenticates your account.");
            }
        }

        client.setAccountNumber(GenerateUniqueNumber.generate(10));
        client.setCardNumber(GenerateUniqueNumber.generate(16));
        clients.add(client);
    }

    @Override
    public void addAdmin(Admin admin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAdmin'");
    }

}
