package ir.ac.kntu.faribank.menu.client;

import ir.ac.kntu.faribank.Controller.commonControllers.LoginController;
import ir.ac.kntu.faribank.bank.Errors.InvalidCommandExeption;
import ir.ac.kntu.faribank.bank.Errors.InvalidInputExeption;
import ir.ac.kntu.faribank.menu.MEnter;
import ir.ac.kntu.faribank.util.ScannerWrapper;

public class MSignUp extends MEnter {
    private String firstName;
    private String lastName;

    public MSignUp(String firstName, String lastName, String nationalCodeID, String phoneNumber, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setNationalCode(nationalCodeID);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    private String nationalCodeID;

//    private static MSignUp instance = new MSignUp();

//    public static MSignUp getInstance() {
//        return instance;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setNationalCode(String nationalCodeID) {
        this.nationalCodeID = nationalCodeID;
    }

    public String getNationalCode() {
        return nationalCodeID;
    }

    @Override
    protected void printMenu() throws InvalidInputExeption {
        System.out.println("****************************** Client - SignUp ******************************");

        System.out.print("\nPlease, write your First Name: ");
        setFirstName(ScannerWrapper.getInstance().next());

        System.out.print("\nPlease, write your Last Name: ");
        setLastName(ScannerWrapper.getInstance().next());

        System.out.print("\nPlease, write your National Code : ");
        setLastName(ScannerWrapper.getInstance().next());

        System.out.print("\nPlease, write your Phone number: ");
        setPhoneNumber(ScannerWrapper.getInstance().next());

        if (getPhoneNumber().length() != 11) {
            throw new InvalidInputExeption("Phone Number'length must be 11 digits.");
        } else if (!getPhoneNumber().matches("[0-9]{11}")) {
            throw new InvalidInputExeption("Phone Number should only contain digits (0-9).");
        }

        System.out.println(
                "\n**The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        System.out.print("Please, write your password : ");
        setPassword(ScannerWrapper.getInstance().next());

        if (getPassword().matches("\\s")) {
            throw new InvalidInputExeption("Invalid password, because it has space (' ') character.");
        } else if (!getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W_]).+$")) {
            throw new InvalidInputExeption(
                    "The password should be have at least one Uppercase letter, one Lowercase letter, and one Special Character.");
        }
    }

    @Override
    protected Option getCommand() throws InvalidCommandExeption {
        return null;
    }

    @Override
    public void handle() {
        LoginController.changeSceneToHome();
//        try {
//            printMenu();
//        System.out.println(se);
            System.out.println("SignUp Done");
//        } catch (InvalidInputExeption e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
