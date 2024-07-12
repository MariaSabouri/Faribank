package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Person;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputException;
import ir.ac.kntu.faribank.bank.Errors.NotFoundException;
import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;

public interface Menu {
    void handle(Person p) throws InvalidInputException, DuplicatedItemException, NotFoundException;
    // void handle(String phoneNumber, String password) throws InvalidInputException, duplicatedItemException;
}