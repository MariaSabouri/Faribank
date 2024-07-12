package ir.ac.kntu.faribank.menu;

public abstract class MEnter extends Menu<MEnter.Option> {
    private String phoneNumber;
    private String password;
    public enum Option {
    };

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
