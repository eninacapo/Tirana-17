package utils;

import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailGenerator {
    //Class to generate random emails
    public String generateRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        //  It shows the length of the random string.
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@outlook.com";
    }
}
