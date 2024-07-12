package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.Controller.client.SignUpController;

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
        SignUpController.changeSceneToHome();
        
        System.out.println(toString());
    }

}
