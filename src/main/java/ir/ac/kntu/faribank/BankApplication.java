package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.Controller.Main;
import ir.ac.kntu.faribank.bank.FariBank;
import ir.ac.kntu.faribank.bank.admin.Admin;

public class BankApplication {
    public static void main(String[] args) {
        Admin admin1 = new Admin("Kamyar", "Sabouri", "0990", "1111");
        Admin admin2 = new Admin("NiNi", "Bighou", "0930", "1234");

        FariBank.getInstance().addAdmin(admin1);
        FariBank.getInstance().addAdmin(admin2);

        Main.main(args);
    }
}