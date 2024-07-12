package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MLogin extends MEnter {

    private static MLogin instance = new MLogin();

    public static MLogin getInstance() {
        return instance;
    }

    @Override
    protected void printMenu() throws InvalidInputExeption {
        System.out.println("****************************** Client - Login ******************************");

        System.out.print("\nPlease, write your Phone number: ");
        setPhoneNumber(ScannerWrapper.getInstance().next());

        System.out.print("\nPlease, write your password: ");
        setPassword(ScannerWrapper.getInstance().next());
    }

    @Override
    protected Option getCommand() throws InvalidCommandExeption {
        return null;
    }

    @Override
    public void handle() {
        try {
            printMenu();
            System.out.println("Login Done");
        } catch (InvalidInputExeption e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
