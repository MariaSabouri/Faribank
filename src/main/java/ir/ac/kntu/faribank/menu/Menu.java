package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.duplicatedItemException;

public interface Menu {
    void handle(Person p) throws InvalidInputException, duplicatedItemException;
}