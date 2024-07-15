package ir.ac.kntu.faribank.bank;

import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;

public interface Bank {
    Double fee = 100.0;

    void addNewClient(Client newClient) throws DuplicatedItemException;

    void addClient(Client client);

    void addAdmin(Admin admin);
}