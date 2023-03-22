package com.demir.FakeDataGeneratorWeb.Generators.Address;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;
import java.util.Random;

public class GenerateCity {
    private static final String CITIES_BY_CODE_JSON = "addressData/cities_by_code.json";

    public static int cityCode;

    public static String getCityName() throws Exception {
        Random random = new Random();
        double r = random.nextDouble();  // generate a random number between 0 and 1


        // Generates a random city code with respect to probabilities calculated from real cumulative population distribution of the cities.
        double[] cityProbabilities = {2.263 / 84.68, 2.895 / 84.68, 3.639 / 84.68, 4.163 / 84.68, 4.498 / 84.68, 10.245 / 84.68, 12.864 / 84.68, 13.033 / 84.68, 14.167 / 84.68, 15.417 / 84.68, 15.645 / 84.68, 15.928 / 84.68, 16.280 / 84.68, 16.600 / 84.68, 16.873 / 84.68, 20.020 / 84.68, 20.577 / 84.68, 20.773 / 84.68, 21.299 / 84.68, 22.350 / 84.68, 24.141 / 84.68, 24.553 / 84.68, 25.141 / 84.68, 25.378 / 84.68, 26.134 / 84.68, 27.032 / 84.68, 29.162 / 84.68, 29.612 / 84.68, 29.762 / 84.68, 30.040 / 84.68, 31.710 / 84.68, 32.155 / 84.68, 34.046 / 84.68, 49.886 / 84.68, 54.311 / 84.68, 54.592 / 84.68, 54.967 / 84.68, 56.401 / 84.68, 56.767 / 84.68, 57.009 / 84.68, 59.042 / 84.68, 61.319 / 84.68, 61.897 / 84.68, 62.705 / 84.68, 64.161 / 84.68, 65.332 / 84.68, 66.194 / 84.68, 67.215 / 84.68, 67.620 / 84.68, 67.928 / 84.68, 68.291 / 84.68, 69.051 / 84.68, 69.396 / 84.68, 70.456 / 84.68, 71.827 / 84.68, 72.158 / 84.68, 72.376 / 84.68, 73.012 / 84.68, 74.125 / 84.68, 74.727 / 84.68, 75.543 / 84.68, 75.626 / 84.68, 77.769 / 84.68, 78.142 / 84.68, 79.283 / 84.68, 79.701 / 84.68, 80.290 / 84.68, 80.719 / 84.68, 80.804 / 84.68, 81.062 / 84.68, 81.337 / 84.68, 81.963 / 84.68, 82.509 / 84.68, 82.710 / 84.68, 82.804 / 84.68, 83.007 / 84.68, 83.298 / 84.68, 83.547 / 84.68, 83.692 / 84.68, 84.245 / 84.68, 84.68 / 84.68};
        for (int i = 0; i < cityProbabilities.length; i++) {
            if (r < cityProbabilities[i]) {
                cityCode = i + 1;
                break;
            }
        }



        // Read the JSON file and parse it into a Map<Integer, String> object
        ObjectMapper mapper = new ObjectMapper();
        InputStream jsonStream = GenerateCity.class.getClassLoader().getResourceAsStream(CITIES_BY_CODE_JSON);
        Map<Integer, String> citiesByCode = mapper.readValue(jsonStream, new TypeReference<Map<Integer, String>>() {
        });

        // Return the name of the city for the generated city code
        return citiesByCode.get(cityCode);
    }

    public static int getCityCode() {
        return cityCode;
    }


}


