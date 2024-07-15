package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.Controller.Main;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.admin.Admin;
import ir.ac.kntu.faribank.bank.client.Client;

public class BankApplication {
    public static void main(String[] args) {

        try {
            FariBank.getInstance().addNewClient(new Client("22222222222", "K@2k", "nana", "Bighou", "001"));
            FariBank.getInstance().addNewClient(new Client("11111111111", "K@2k", "dada", "dada", "471"));
        } catch (DuplicatedItemException | InvalidInputException | NotFoundException e) {
            e.printStackTrace();
        }

        try {
            FariBank.getInstance().addAdmin(new Admin("Kamyar", "Sabouri", "11111111111", "K@2k"));
            FariBank.getInstance().addAdmin(new Admin("nana", "Bighou", "22222222222", "K@2k"));
        } catch (InvalidInputException | NotFoundException e) {
            e.printStackTrace();
        }

        Main.main(args);
    }
}