package ir.ac.kntu.faribank.bank.Errors;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("The desired amount is greater than your balance.");
    }

    public InsufficientFundsException(String errorMessage) {
        super(errorMessage);
    }

    public InsufficientFundsException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public InsufficientFundsException(Throwable t) {
        super(t);
    }
}
