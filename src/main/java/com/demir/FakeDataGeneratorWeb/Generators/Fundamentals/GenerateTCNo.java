package com.demir.FakeDataGeneratorWeb.Generators.Fundamentals;

import java.util.Random;

public class GenerateTCNo {
    /*
     Turkish identity number (TC No) is 11-digit number whose first 9 digit is random and 10th and 11th digits are calculated by using previous digits.
     Additionally, it cannot start with zero.
     */
    public static long generateTCno() {
        Random random = new Random();
        int first9Digit;
        do {first9Digit = random.nextInt((int) Math.pow(10, 9));}
        while (first9Digit < (int) Math.pow(10, 8));
        // Generates a random 9-digit number that does not start with 0.

        int ninthDigit=(first9Digit)%10;
        int eighthDigit=(first9Digit/10)%10;
        int seventhDigit=(first9Digit/100)%10;
        int sixthDigit=(first9Digit/1000)%10;
        int fifthDigit=(first9Digit/10000)%10;
        int fourthDigit=(first9Digit/100000)%10;
        int thirdDigit=(first9Digit/1000000)%10;
        int secondDigit=(first9Digit/10000000)%10;
        int firstDigit=(first9Digit/100000000)%10;
        // Separate the every digit since we need them to calculate last two digit.

        int tenthDigit=((firstDigit+thirdDigit+fifthDigit+seventhDigit+ninthDigit)*7-(secondDigit+fourthDigit+sixthDigit+eighthDigit))%10;
        // Calculate 10th Digit.

        int eleventhDigit=(firstDigit+secondDigit+thirdDigit+fourthDigit+fifthDigit+sixthDigit+seventhDigit+eighthDigit+ninthDigit+tenthDigit)%10;
        // Calculate 11th Digit.

        long tcNo= ((long) first9Digit*100L) + ( 10L * tenthDigit) + (eleventhDigit);
        // Merge all of them into an 11-digit number. 11 digit is too long for an int, that's why it was cast to a long.

        return tcNo;
    }
//    public static void main(String[] args) {
//        long randomNumber = generateTCno();
//        System.out.println("Tc No: " + randomNumber);
//    }
}
