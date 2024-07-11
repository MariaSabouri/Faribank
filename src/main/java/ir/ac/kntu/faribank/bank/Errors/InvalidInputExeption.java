package ir.ac.kntu.faribank.bank.Errors;

public class InvalidInputExeption extends Exception {
    public InvalidInputExeption() {
        super("Invalid input.");
    }

    public InvalidInputExeption(String errorMessage) {
        super(errorMessage);
    }

    public InvalidInputExeption(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

    public InvalidInputExeption(Throwable t) {
        super(t);
    }
}
