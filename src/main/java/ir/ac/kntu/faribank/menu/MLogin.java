package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;

public class MLogin extends Menu<MLogin.Option> {
    public enum Option {
    };

    @Override
    protected void printMenu() {
        System.out.println("******************************** Client ********************************");
        System.out.print("\nPlease, write your phone number: ");
    }

    @Override
    protected Option getOption() throws InvalidCommandExeption {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOption'");
    }

    @Override
    public void handle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }

}
