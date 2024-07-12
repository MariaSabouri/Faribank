package ir.ac.kntu.faribank.bank.Errors;

public class NotFooundException extends Exception {
    public NotFooundException() {
        super("User not found.");
    }

    public NotFooundException(String errorMessage) {
        super(errorMessage);
    }

    public NotFooundException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public NotFooundException(Throwable t) {
        super(t);
    }
}
