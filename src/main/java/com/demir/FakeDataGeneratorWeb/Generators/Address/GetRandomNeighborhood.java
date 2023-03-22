package com.demir.FakeDataGeneratorWeb.Generators.Address;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;
import java.util.Random;
/*
The JSON file containing neighbourhoods comes from https://github.com/muratgozel/turkey-neighbourhoods/blob/master/data/extra/neighbourhoods_by_district_and_city.json
*/
public class GetRandomNeighborhood {

    public static final String NEIGHBOURHOODS_BY_DISTRICT_AND_CITY_JSON = "addressData/neighbourhoods_by_district_and_city.json";

    public static String getRandomNeighborhood(int cityCode, String district) throws Exception {
        // Read the JSON file and parse it into a Map<int, Map<String, String[]>> object
        ObjectMapper mapper = new ObjectMapper();
        InputStream jsonStream = GetRandomNeighborhood.class.getClassLoader().getResourceAsStream(NEIGHBOURHOODS_BY_DISTRICT_AND_CITY_JSON);
        Map<Integer, Map<String, String[]>> neighborhoodsByDistrictAndCity = mapper.readValue(jsonStream, new TypeReference<Map<Integer, Map<String, String[]>>>() {});

        // Get the neighborhoods for the given city code and district
        String[] neighborhoods = neighborhoodsByDistrictAndCity.get(cityCode).get(district);

        // Return a random neighborhood from the list
        Random random = new Random();
        int index = random.nextInt(neighborhoods.length);
        return neighborhoods[index];
    }
}

