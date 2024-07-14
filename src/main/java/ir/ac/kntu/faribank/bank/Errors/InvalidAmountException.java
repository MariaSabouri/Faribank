package ir.ac.kntu.faribank.bank.Errors;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
        super("Invalid amount because is less than 0.");
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
