package com.demir.FakeDataGeneratorWeb.web.components;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;


public class NumberOfPeopleDataModel {

    @Min(0)
    @Max(1000)
    private static int numberOfPeople;

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    public static void setNumberOfPeople(int numberOfPeople) {
        NumberOfPeopleDataModel.numberOfPeople = numberOfPeople;
    }

}
