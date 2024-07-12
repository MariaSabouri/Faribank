package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;

public abstract class Menu<T extends Enum<T>> {

    protected abstract void printMenu();

    protected abstract T getOption() throws InvalidCommandExeption;

    public abstract void handle();
}