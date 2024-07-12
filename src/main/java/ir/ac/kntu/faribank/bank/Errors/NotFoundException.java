package ir.ac.kntu.faribank.bank.Errors;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("User not found.");
    }

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NotFoundException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public NotFoundException(Throwable t) {
        super(t);
    }
}
