package com.demir.FakeDataGeneratorWeb.web.components;

public class AgeRangeDataModel {
    private static int minAge;
    private static int maxAge;

    public static int getMinAge() {
        return minAge;
    }

    public static void setMinAge(int minAge) {
        AgeRangeDataModel.minAge = minAge;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public static void setMaxAge(int maxAge) {
        AgeRangeDataModel.maxAge = maxAge;
    }
}
