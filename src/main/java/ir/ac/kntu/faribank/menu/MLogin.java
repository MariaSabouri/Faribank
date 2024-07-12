package ir.ac.kntu.faribank.menu;

import ir.ac.kntu.faribank.Controller.client.SignUpController;
import ir.ac.kntu.faribank.bank.Person;

public class MLogin implements Menu {

    private static MLogin instance = new MLogin();

    public static MLogin getInstance() {
        return instance;
    }

    @Override
    public void handle(Person admin) {
        SignUpController.changeSceneToHome();

        System.out.println(toString());
    }

}
