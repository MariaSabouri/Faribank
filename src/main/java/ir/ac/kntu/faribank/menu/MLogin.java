package ir.ac.kntu.faribank.menu;

public class MLogin extends MEnter {

    public MLogin(String phoneNumber, String password) {
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    @Override
    public String toString() {
        return "MLogin {" +
                "\nphoneNumber: '" + getPhoneNumber() +
                "\'\npassword: '" + getPassword() +
                "\'\n'}";
    }

    @Override
    public void check() {
        System.out.println(toString());
    }

}
