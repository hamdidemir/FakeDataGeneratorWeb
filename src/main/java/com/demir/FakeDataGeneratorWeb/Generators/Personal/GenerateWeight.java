package com.demir.FakeDataGeneratorWeb.Generators.Personal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
The weight distribution is modelled as a Gaussian distribution. The median and standard deviation for the Gaussian
distribution changes by age and gender. So the method takes the age and gender as an input. For the underage, there are different
values for Gaussian variables. The values are taken from: http://beyazhastane.com/17/Persentil_Tablosu__Erkek_.aspx and http://beyazhastane.com/16/Persentil_Tablosu__Kiz_.aspx
And for the adults, the national average values are used.
 */

public class GenerateWeight {
    private static final Map<Integer, Double> AVERAGE_WEIGHTS_MALE = new HashMap<>();
    private static final Map<Integer, Double> AVERAGE_WEIGHTS_FEMALE = new HashMap<>();
    private static final Map<Integer, Double> STANDARD_DEVIATIONS_MALE = new HashMap<>();
    private static final Map<Integer, Double> STANDARD_DEVIATIONS_FEMALE = new HashMap<>();


    public static int WeightGenerator(int age, char gender) {
        Random random = new Random();

        int[] ageList={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        double[] averageWeightsMale = {3.43,10.36,12.66,14.83,16.8,18.6,20.7,23.2,25.8,28.8,32.2,37.8,44.3,49.8,56.2,62.1,66.2,69.2,71.8};
        double[] standardDeviationsMale = {0.3,0.7,1.0,1.8,1.9,2.0,2.2,3.1,4.2,4.5,5.3,5.8,6.1,6.3,6.3,6.7,7.1,7.2,7.3};
        double[] averageWeightFemale = {3.29,9.39,11.94,14.98,16.1,18.4,20.6,22.9,25.7,28.9,32.6,38.2,45.1,50.0,55.3,55.3,56.3,57.2,58.1};
        double[] standardDeviationsFemale = {0.3,0.9,1.1,1.3,2.1,2.4,2.6,3.1,3.5,3.9,4.4,4.8,5.1,5.3,4.9,5.2,4.8,5.3,4.8};

        for (int i = 0; i < 19; i++) {
            AVERAGE_WEIGHTS_MALE.put(ageList[i], averageWeightsMale[i]);
            STANDARD_DEVIATIONS_MALE.put(ageList[i], standardDeviationsMale[i]);
            AVERAGE_WEIGHTS_FEMALE.put(ageList[i],averageWeightFemale[i] );
            STANDARD_DEVIATIONS_FEMALE.put(ageList[i],standardDeviationsFemale[i] );
        }

        double averageWeight, standardDeviation;
        if (age < 18) {
            // Look up the mean and standard deviation for the age group and gender
            if (gender == 'M') {
                averageWeight = AVERAGE_WEIGHTS_MALE.get(age);
                standardDeviation = STANDARD_DEVIATIONS_MALE.get(age);
            } else if (gender == 'F') {
                averageWeight = AVERAGE_WEIGHTS_FEMALE.get(age);
                standardDeviation = STANDARD_DEVIATIONS_FEMALE.get(age);
            } else {
                throw new IllegalArgumentException("Invalid gender: " + gender);
            }
        } else if (gender == 'M') {
            averageWeight = 78; // Average weight for Turkish adult men
            standardDeviation = 9;
        } else if (gender == 'F') {
            averageWeight = 68; // Average weight for Turkish adult women
            standardDeviation = 6;
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }

        // Generate a random height according to the Gaussian distribution
        int weight =(int) (averageWeight + random.nextGaussian() * standardDeviation);

        return weight;
    }
}
