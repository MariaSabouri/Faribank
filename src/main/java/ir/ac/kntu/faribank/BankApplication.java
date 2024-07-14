package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.Controller.Main;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;

public class BankApplication {
    public static void main(String[] args) {

        try {
            FariBank.getInstance().addNewClient(new Client("12345678900", "K@2k", "nana", "nana", "001"));
            FariBank.getInstance().addNewClient(new Client("11111111111", "K@2k", "dada", "dada", "471"));
        } catch (DuplicatedItemException e) {
            e.printStackTrace();
        }

        Admin admin1 = new Admin("Kamyar", "Sabouri", "0990", "1111");
        Admin admin2 = new Admin("NiNi", "Bighou", "0930", "1234");

        FariBank.getInstance().addAdmin(admin1);
        FariBank.getInstance().addAdmin(admin2);

        Main.main(args);
    }
}