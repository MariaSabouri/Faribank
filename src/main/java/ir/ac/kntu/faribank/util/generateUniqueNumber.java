package ir.ac.kntu.faribank.util;

import java.security.SecureRandom;

public class GenerateUniqueNumber {

    public static String generate(int cartNumberLength) {
        SecureRandom secureRandom = new SecureRandom();

        StringBuilder cartNumber = new StringBuilder();
        for (int i = 0; i < cartNumberLength; i++) {
            int digit = secureRandom.nextInt(10); // Generate a random digit (0-9)
            cartNumber.append(digit);
        }

        return cartNumber.toString();
    }

}
