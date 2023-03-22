package com.demir.FakeDataGeneratorWeb.Generators.Personal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
The height distribution in people can be modelled as a Gaussian distribution. The median and standard deviation for the Gaussian
distribution changes by age and gender. So the method takes the age and gender as an input. For the underage, there are different
values for Gaussian variables. The values are taken from: http://beyazhastane.com/17/Persentil_Tablosu__Erkek_.aspx and http://beyazhastane.com/16/Persentil_Tablosu__Kiz_.aspx
And for the adults, the national average values are used.
 */

public class GenerateHeight {
    private static final Map<Integer, Double> AVERAGE_HEIGHTS_MALE = new HashMap<>();
    private static final Map<Integer, Double> AVERAGE_HEIGHTS_FEMALE = new HashMap<>();
    private static final Map<Integer, Double> STANDARD_DEVIATIONS_MALE = new HashMap<>();
    private static final Map<Integer, Double> STANDARD_DEVIATIONS_FEMALE = new HashMap<>();


    public static int HeightGenerator(int age, char gender) {
        Random random = new Random();

        int[] ageList={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        double[] averageHeightsMale = {50,76.9,88.0,96.8,104.0,110.0,116.0,121.5,126.9,132.1,137.6,143.8,150.6,157.7,164.9,170.3,173.4,175.0,176.2};
        double[] standardDeviationsMale = {1.5,2.1,2.6,2.7,2.9,3.5,3.2,3.2,3.4,3.8,4.0,4.3,4.8,5.3,5.2,5.2,4.5,4.3,3.8};
        double[] averageHeightsFemale = {49.4,75.1,86.8,95.4,102.5,109.1,115.1,121.1,126.7,132.1,137.9,145.4,153.1,157.8,160.4,161.7,162.4,162.7,163.1};
        double[] standardDeviationsFemale = {1.4,2.0,2.4,2.7,3.0,3.1,3.3,3.3,3.6,3.9,4.3,4.7,5.0,4.3,3.9,4.0,3.9,4.0,4.0};

        for (int i = 0; i < 19; i++) {
            AVERAGE_HEIGHTS_MALE.put(ageList[i], averageHeightsMale[i]);
            STANDARD_DEVIATIONS_MALE.put(ageList[i], standardDeviationsMale[i]);
            AVERAGE_HEIGHTS_FEMALE.put(ageList[i],averageHeightsFemale[i] );
            STANDARD_DEVIATIONS_FEMALE.put(ageList[i],standardDeviationsFemale[i] );
        }

        double averageHeight, standardDeviation;
        if (age < 18) {
            // Look up the mean and standard deviation for the age group and gender
            if (gender == 'M') {
                averageHeight = AVERAGE_HEIGHTS_MALE.get(age);
                standardDeviation = STANDARD_DEVIATIONS_MALE.get(age);
            } else if (gender == 'F') {
                averageHeight = AVERAGE_HEIGHTS_FEMALE.get(age);
                standardDeviation = STANDARD_DEVIATIONS_FEMALE.get(age);
            } else {
                throw new IllegalArgumentException("Invalid gender: " + gender);
            }
        } else if (gender == 'M') {
            averageHeight = 176; // Average height for Turkish adult men
            standardDeviation = 8;
        } else if (gender == 'F') {
            averageHeight = 165; // Average height for Turkish adult women
            standardDeviation = 6;
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }

        // Generate a random height according to the Gaussian distribution
        int height =(int) (averageHeight + random.nextGaussian() * standardDeviation);

        return height;
    }
}