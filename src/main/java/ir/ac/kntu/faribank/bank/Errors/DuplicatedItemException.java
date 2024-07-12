package ir.ac.kntu.faribank.bank.Errors;

public class DuplicatedItemException extends Exception {
    public DuplicatedItemException() {
        super("Doublicated item has found.");
    }

    public DuplicatedItemException(String errorMessage) {
        super(errorMessage);
    }

    public DuplicatedItemException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public DuplicatedItemException(Throwable t) {
        super(t);
    }
}
