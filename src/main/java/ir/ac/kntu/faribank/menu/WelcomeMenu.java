package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.enums.Role;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class WelcomeMenu {
    private static WelcomeMenu instance = new WelcomeMenu();

    public static WelcomeMenu getInstance() {
        return instance;
    }

    public void printMenu() {
        System.out.println("*****************************************************************");
        System.out.println("*                   Welcome To Online Bank!                    *\n");
        System.out.println("Roles:");
        System.out.println("1-Customer");
        System.out.println("2-Bank Assistant");
        System.out.println("2-Exit");
        System.out.println("*****************************************************************");
        System.out.print("Please select your choice: ");
    };

    public Role getOption() {
        Role[] roles = Role.values();

        while (true) {
            int userInput = ScannerWrapper.getInstance().nextInt() - 1;

            if (userInput >= 0 && userInput < roles.length) {
                return roles[userInput];
            }

            System.out.print("EER: Wrong number. Please try again: ");
        }
    };
}
