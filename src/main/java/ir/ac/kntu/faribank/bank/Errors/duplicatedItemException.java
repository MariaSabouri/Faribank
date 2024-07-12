package ir.ac.kntu.faribank.bank.Errors;

public class duplicatedItemException extends Exception {
    public duplicatedItemException() {
        super("Doublicated item has found.");
    }

    public duplicatedItemException(String errorMessage) {
        super(errorMessage);
    }

    public duplicatedItemException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public duplicatedItemException(Throwable t) {
        super(t);
    }
}
