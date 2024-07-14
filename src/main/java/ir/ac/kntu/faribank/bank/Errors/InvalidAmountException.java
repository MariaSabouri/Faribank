package ir.ac.kntu.faribank.bank.Errors;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
        super("Invalid amount");
    }

    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidAmountException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public InvalidAmountException(Throwable t) {
        super(t);
    }
}
