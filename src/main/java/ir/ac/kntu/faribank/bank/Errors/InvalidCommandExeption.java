package ir.ac.kntu.faribank.bank.Errors;

public class InvalidCommandExeption extends Exception {
    public InvalidCommandExeption() {
        super("Invalid Command.");
    }

    public InvalidCommandExeption(String errorMessage) {
        super(errorMessage);
    }

    public InvalidCommandExeption(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public InvalidCommandExeption(Throwable t) {
        super(t);
    }
}
