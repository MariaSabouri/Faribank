package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;

public interface Menu<T extends Enum<T>> {

    void printMenu();

    T getOption() throws InvalidInputExeption;
}
