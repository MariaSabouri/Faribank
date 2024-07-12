package ir.ac.kntu.faribank.bank.Errors;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Invalid Input.");
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidInputException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public InvalidInputException(Throwable t) {
        super(t);
    }
}
