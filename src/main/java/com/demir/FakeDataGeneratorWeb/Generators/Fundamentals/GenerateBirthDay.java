package com.demir.FakeDataGeneratorWeb.Generators.Fundamentals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GenerateBirthDay {
    /*
    Generates a random birthday when the age is given.
     */
    public static String BirthDayGenerator(int age) {
        Random random = new Random();

        // Get the current date as a LocalDate object
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        // Calculate the birth year based on the age and the current year
        int birthYear = currentYear - age;
        // Generate a random month
        int month = random.nextInt(12) + 1;

        // Generate a random day within the corresponding range for the selected month
        int day;
        switch (month) {
            case 2:  // February
                if (birthYear % 4 == 0) {
                    day = random.nextInt(29) + 1;
                } // return a random day between 1 and 29 for leap years
                else {
                    day = random.nextInt(28) + 1;
                } // return a random day between 1 and 28 for regular years
                break;
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11:  // November
                day = random.nextInt(30) + 1;  // return a random day between 1 and 30
                break;
            default:  // all other months
                day = random.nextInt(31) + 1;  // return a random day between 1 and 31
                break;
        }

        // Create a LocalDate object with the generated birthday
        LocalDate birthday = LocalDate.of(birthYear, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedBirthday = birthday.format(formatter);
        return formattedBirthday;
    }
}