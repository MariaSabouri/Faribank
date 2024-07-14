package ir.ac.kntu.faribank.menu.client.management;


import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.client.Client;

public class MDeposit {

    private static MDeposit instance = new MDeposit();

    public static MDeposit getInstance() {
        return instance;
    }

    public void submit(Client client, String deposit)throws InvalidInputException {
        throw new InvalidInputException();

        
    }
}