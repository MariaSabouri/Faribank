package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;
import ir.ac.kntu.faribank.menu.MLogin;
import ir.ac.kntu.faribank.menu.Menu;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MStatusOfEntryClient extends Menu<MStatusOfEntryClient.Option> {
    public enum Option {
        LOGIN,
        SIGNUP,
        BACK,
    }

    private static MStatusOfEntryClient instance = new MStatusOfEntryClient();

    public static MStatusOfEntryClient getInstance() {
        return instance;
    }

    @Override
    protected void printMenu() {
        System.out.println("******************************** Client ********************************");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Back <");
        System.out.print("\nPlease, select your choice: ");
    };

    @Override
    protected Option getCommand() throws InvalidCommandExeption {
        Option[] option = Option.values();

        while (true) {
            int userInput = ScannerWrapper.getInstance().nextInt() - 1;

            if (userInput >= 0 && userInput < option.length) {
                return option[userInput];
            }

            throw new InvalidCommandExeption();
        }
    }

    @Override
    public void handle() {
        Option option = null;

        while (option != MStatusOfEntryClient.Option.BACK) {
            printMenu();

            try {
                option = getCommand();

                switch (option) {
                    case LOGIN -> {
                        MLogin.getInstance().handle();
                    }
                    case SIGNUP -> {
                        MSignUp.getInstance().handle();
                    }
                    case BACK -> {}
                }
            } catch (InvalidCommandExeption e) {
                e.printStackTrace();
            }
        }
    }
}
