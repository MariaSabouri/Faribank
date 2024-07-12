package ir.ac.kntu.faribank.bank;

import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;

public interface Bank {
    void addClient(Client client) throws DuplicatedItemException;
    void addAdmin(Admin admin);
}
