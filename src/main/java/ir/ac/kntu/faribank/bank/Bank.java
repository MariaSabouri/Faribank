package ir.ac.kntu.faribank.bank;

import ir.ac.kntu.faribank.bank.Errors.DuplicatedItemException;

public interface Bank {
    void add(Person p) throws DuplicatedItemException;
}
