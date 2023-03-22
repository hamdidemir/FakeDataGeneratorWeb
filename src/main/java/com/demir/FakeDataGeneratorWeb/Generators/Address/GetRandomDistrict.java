package com.demir.FakeDataGeneratorWeb.Generators.Address;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;
/*
The JSON file containing districts by city comes from https://github.com/muratgozel/turkey-neighbourhoods/blob/master/data/extra/districts_by_city.json
*/
public class GetRandomDistrict {

    public static final String DISTRICTS_BY_CITY_JSON = "addressData/districts_by_city.json";

    public static String getRandomDistrict(int cityCode) throws Exception {
        // Read the JSON file and parse it into a Map<Integer, String[]> object
        ObjectMapper mapper = new ObjectMapper();
        InputStream jsonStream = GetRandomDistrict.class.getClassLoader().getResourceAsStream(DISTRICTS_BY_CITY_JSON);
        Map<Integer, String[]> districtsByCity = mapper.readValue(jsonStream, new TypeReference<Map<Integer, String[]>>() {});

        // Get the districts for the given city code
        String[] districts = districtsByCity.get(cityCode);

        // Return a random district from the list
        Random random = new Random();
        int index = random.nextInt(districts.length);
        return districts[index];
    }
}