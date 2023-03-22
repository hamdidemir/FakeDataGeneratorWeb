package com.demir.FakeDataGeneratorWeb.Generators.Address;

import java.util.Random;

/*
Creates random street, building, and flat numbers with various probabilities.
*/
public class StreetBuildingFlatNoGenerator {
    public static String getRandomStreetBuildingFlat() {
        // Create a Random object
        Random random = new Random();

        //Create random street no
        double d= random.nextDouble();
        int streetNo;

        if      (d < 0.7)  {streetNo = random.nextInt(100) + 1;}
        else if (d < 0.85) {streetNo = random.nextInt(100) + 101;}
        else               {streetNo = random.nextInt(200) + 201;}

        //Create random building no
        double d1= random.nextDouble();
        int buildingNo;

        if      (d1 < 0.6)    {buildingNo = random.nextInt(20) + 1;}
        else if (d1 < 0.9)    {buildingNo = random.nextInt(30) + 21;}
        else                  {buildingNo = random.nextInt(50) + 51;}

        //Create random flat no
        double d2=random.nextDouble();
        int flatNo;

        if      (d2 < 0.5)    {flatNo = random.nextInt(30) + 1;}
        else if (d2 < 0.75)   {flatNo = random.nextInt(20) + 31;}
        else if (d2 < 0.9)    {flatNo = random.nextInt(50) + 51;}
        else                  {flatNo = random.nextInt(250) + 101;}



        // Return the result as a string
        return streetNo + ". sok."+ " No:"+ buildingNo + "; Daire No:"+flatNo;
    }
//
//    public static void main(String[] args) {
//        System.out.println(getRandomStreetBuildingFlat());
//    }
}
