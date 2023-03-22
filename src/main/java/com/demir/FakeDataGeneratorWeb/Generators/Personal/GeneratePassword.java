package com.demir.FakeDataGeneratorWeb.Generators.Personal;

import com.demir.FakeDataGeneratorWeb.web.components.PasswordLengthDataModel;

import java.util.Random;

/*
Sets up a totally random password whose length can be adjusted.
 */

public class GeneratePassword {
    public static String passwordGenerator(){
        // Retrieve the length of the password
        int length = PasswordLengthDataModel.getPasswordLength();

        // Set the characters that can be used in the password
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|':.<>/?";

        // Create a new Random object
        Random random = new Random();

        // Use a StringBuilder to build the password
        StringBuilder password = new StringBuilder();

        // Generate a random password
        for (int i = 0; i < length; i++) {
            // Get a random character from the characters string
            int index = random.nextInt(characters.length());
            char c = characters.charAt(index);
            // Append the character to the password
            password.append(c);
        }

        return password.toString();
    }
}
