package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;

public abstract class Menu<T extends Enum<T>> {

    protected abstract void printMenu() throws InvalidInputExeption;

    protected abstract T getCommand() throws InvalidCommandExeption;

    public abstract void handle();
}