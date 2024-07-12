package ir.ac.kntu.faribank.bank;

import ir.ac.kntu.faribank.bank.Errors.duplicatedItemException;

public interface Bank {
    void add(Person p) throws duplicatedItemException;
}
