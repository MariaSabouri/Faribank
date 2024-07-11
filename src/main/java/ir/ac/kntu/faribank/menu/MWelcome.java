package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MWelcome implements Menu<MWelcome.Role> {
    public enum Role {
        CLIENT, ADMIN, EXIT
    };

    private static MWelcome instance = new MWelcome();

    public static MWelcome getInstance() {
        return instance;
    }

    public void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                   Welcome To Online Bank!                    *\n");
        System.out.println("Roles:");
        System.out.println("1. Customer");
        System.out.println("2. Bank Assistant");
        System.out.println("2. Exit");
        System.out.print("\nPlease select your choice: ");
    };

    public Role getOption() throws InvalidInputExeption {
        Role[] roles = Role.values();

        while (true) {
            int userInput = ScannerWrapper.getInstance().nextInt() - 1;

            if (userInput >= 0 && userInput < roles.length) {
                return roles[userInput];
            }

            throw new InvalidInputExeption();
        }
    };
}