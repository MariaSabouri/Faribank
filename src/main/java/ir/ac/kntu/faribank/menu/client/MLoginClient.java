package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.Menu;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MLoginClient implements Menu<MLoginClient.Option> {
    public enum Option {
        LOGIN,
        SIGNUP,
        BACK,
    }

    private static MLoginClient instance = new MLoginClient();

    public static MLoginClient getInstance() {
        return instance;
    }

    @Override
    public void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Back <");
        System.out.print("\nPlease select your choice: ");
    };

    @Override
    public Option getOption() throws InvalidInputExeption {
        Option[] option = Option.values();

        while (true) {
            int userInput = ScannerWrapper.getInstance().nextInt() - 1;

            if (userInput >= 0 && userInput < option.length) {
                return option[userInput];
            }

            throw new InvalidInputExeption();
        }
    }    
}
