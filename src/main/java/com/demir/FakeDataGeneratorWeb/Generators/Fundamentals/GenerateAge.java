package com.demir.FakeDataGeneratorWeb.Generators.Fundamentals;

import com.demir.FakeDataGeneratorWeb.web.components.AgeRangeDataModel;

import java.util.Random;


public class GenerateAge {
    /*
        According to data from the Turkish Statistical Institute (TÜİK), the age distribution of Turkey's population in 2021 is as follows:
                0-14 years: 26.5%
                15-24 years: 14.7%
                25-34 years: 16.4%
                35-44 years: 16.0%
                45-54 years: 12.8%
                55-64 years: 8.9%
                65 years and over: 11.7%

                This method will give a random age between given minimum and maximum values with relative respect to the probabilities above.
    */


    public static int ageGenerator() {

        int minAge = AgeRangeDataModel.getMinAge();
        int maxAge = AgeRangeDataModel.getMaxAge();
//
//        int maxAge = 25;
//        int minAge = 25;
        // Set the probabilities for the given age gaps
        double p0to14=0.265;
        double p15to24=p0to14+0.147;
        double p25to34=p15to24+0.164;
        double p35to44=p25to34+0.160;
        double p45to54=p35to44+0.128;
        double p55to64=p45to54+0.089;
        double plus65=p55to64+0.117;

        Random random = new Random(); // Random object
        int ageRange = maxAge - minAge-1;  // total number of ages between minAge and maxAge
        double r = random.nextDouble();  // generate a random number between 0 and 1

        if (r < p0to14) {
            return random.nextInt(ageRange / 7+1) + minAge;       // return a random age between minAge and minAge + ageRange / 7 with 26.5% probability
        } else if (r < p15to24) {
            return random.nextInt(ageRange / 7+1) + minAge + ageRange / 7;  // return a random age between minAge + ageRange / 7 and minAge + 2 * ageRange / 7 with 14.7% probability
        } else if (r < p25to34) {
            return random.nextInt(ageRange / 7+1) + minAge + 2 * ageRange / 7;  // return a random age between minAge + 2 * ageRange / 7 and minAge + 3 * ageRange / 7 with 16.4% probability
        } else if (r < p35to44) {
            return random.nextInt(ageRange / 7+1) + minAge + 3 * ageRange / 7;  // return a random age between minAge + 3 * ageRange / 7 and minAge + 4 * ageRange / 7 with 16.0% probability
        } else if (r < p45to54) {
            return random.nextInt(ageRange / 7+1) + minAge + 4 * ageRange / 7;  // return a random age between minAge + 4 * ageRange / 7 and minAge + 5 * ageRange / 7 with 12.8% probability
        } else if (r < p55to64) {
            return random.nextInt(ageRange / 7+1) + minAge + 5 * ageRange / 7;  // return a random age between minAge + 5 * ageRange / 7 and minAge + 6 * ageRange / 7 with 8.9% probability
        } else {
            return random.nextInt(ageRange / 7+1) + minAge + 6 * ageRange / 7;  // return a random age between minAge + 6 * ageRange / 7 and maxAge with 11.7% probability
        }
    }
}