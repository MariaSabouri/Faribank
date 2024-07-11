package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.Menu;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MStatusOfEnter extends Menu<MStatusOfEnter.Option> {
    public enum Option {
        LOGIN,
        SIGNUP,
        BACK,
    }

    private static MStatusOfEnter instance = new MStatusOfEnter();

    public static MStatusOfEnter getInstance() {
        return instance;
    }

    @Override
    protected void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Back <");
        System.out.print("\nPlease select your choice: ");
    };

    @Override
    protected Option getOption() throws InvalidInputExeption {
        Option[] option = Option.values();

        while (true) {
            int userInput = ScannerWrapper.getInstance().nextInt() - 1;

            if (userInput >= 0 && userInput < option.length) {
                return option[userInput];
            }

            throw new InvalidInputExeption();
        }
    }

    @Override
    public void handle() {
        Option option = null;
  
        while (option != MStatusOfEnter.Option.BACK) {
            printMenu();

            try {
                option = getOption();

                switch (option) {
                    case LOGIN -> {
                        
                    }
                    case SIGNUP -> {

                    }
                    case BACK -> {}
                }
            } catch (InvalidInputExeption e) {
                e.printStackTrace();
            }
        }
    }    
}
