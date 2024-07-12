package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;

public interface Menu {
    void handle(Person p) throws InvalidInputException;
}