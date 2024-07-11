package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;

public abstract class Menu<T extends Enum<T>> {

    protected abstract void printMenu();

    protected abstract T getOption() throws InvalidInputExeption;

    public abstract void handle();
}