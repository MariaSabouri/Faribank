package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.MWelcome;
import ir.ac.kntu.faribank.menu.client.MLoginClient;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class Main {
    public static void main(String[] args) {
        MWelcome.Role option = null;
        MWelcome.getInstance().printMenu();

        while (option != MWelcome.Role.EXIT) {
            try {
                option = MWelcome.getInstance().getOption();
            } catch (InvalidInputExeption e) {
                e.printStackTrace();
            }

            switch (option) {
                case CLIENT -> {
                    MLoginClient.getInstance().printMenu();
                    
                }
                case ADMIN -> {

                }
                default -> {
                    ScannerWrapper.getInstance().close();
                }
            }
        }

    }

}
