package ir.ac.kntu.faribank;

import ir.ac.kntu.faribank.enums.Role;
import ir.ac.kntu.faribank.menu.MWelcome;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class Main {
    public static void main(String[] args) {
        MWelcome.getInstance().printMenu();
        Role option = MWelcome.getInstance().getOption();

        while (option != Role.EXIT) {
            MWelcome.getInstance().printMenu();
            option = MWelcome.getInstance().getOption();
        }
        
        ScannerWrapper.getInstance().close();
    }
}
