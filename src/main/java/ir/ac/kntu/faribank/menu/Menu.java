package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;

public interface Menu {
    void check() throws InvalidInputExeption;
}