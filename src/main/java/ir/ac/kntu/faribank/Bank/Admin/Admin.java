package ir.ac.kntu.faribank.Bank.Admin;

import java.util.Objects;

public class Admin {
    private boolean confirmation = false;
    private String comment;

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public boolean getConfirmation() {
        return confirmation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "BankAssistant{" +
                "confirmation=" + confirmation +
                ", comment='" + comment +
                "\'}";
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(confirmation, comment);
    }
}
