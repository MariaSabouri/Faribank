package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.bank.client.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.MWelcome;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class Main {
    public static void main(String[] args) {
        MWelcome.Role option = null;
        MWelcome.getInstance().printMenu();

        try {
            while (option != MWelcome.Role.EXIT) {
                try {
                    MWelcome.getInstance().printMenu();
                    option = MWelcome.getInstance().getOption();
                } catch (InvalidInputExeption e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
            System.out.println("Sorry! An exception has been occurred!");
        } finally {
            ScannerWrapper.getInstance().close();
        }
    }

}
