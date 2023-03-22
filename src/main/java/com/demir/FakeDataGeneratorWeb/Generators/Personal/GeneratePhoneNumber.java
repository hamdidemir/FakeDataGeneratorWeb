package com.demir.FakeDataGeneratorWeb.Generators.Personal;

import java.text.NumberFormat;
import java.util.Random;
/*
    Generates a random 10 digit cell phone number starting with 53x or 54x or 55x which is valid numbers for Turkey.
 */
public class GeneratePhoneNumber {
    public static String PhoneNumberGenerator() {
        Random random = new Random();

        // Generate a random mobile phone prefix between 530 and 559
        int prefix = random.nextInt(30) + 530;

        // Generate a random 7-digit suffix
        int suffix = random.nextInt((int) Math.pow(10, 7));

        // Concatenate the prefix and suffix to get the full phone number
        long phoneNumber = (prefix * ((long) Math.pow(10, 7))) + suffix;

        //Formatting
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(10);
        formatter.setGroupingUsed(false);
        String formattedNumber = formatter.format(phoneNumber);
        formattedNumber = "(" + formattedNumber.substring(0, 3) + ") "
                + formattedNumber.substring(3, 6) + "-"
                + formattedNumber.substring(6, 8) + "-"
                + formattedNumber.substring(8);
//        System.out.println(formattedNumber);

        return formattedNumber;
    }
}
