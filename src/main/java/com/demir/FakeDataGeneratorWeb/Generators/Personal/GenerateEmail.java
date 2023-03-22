package com.demir.FakeDataGeneratorWeb.Generators.Personal;


import java.time.LocalDate;
import java.util.Random;
public class GenerateEmail {
    /*
    Creates various mail addresses with various probabilities by using the name, surname and last 2 digit of birth year
     */

    public static String EmailGenerator(String name, String surname, int age){
        Random random= new Random();
        String mail=null;
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int last2OfBirthYear=(currentYear - age)%100; //get the last two digit of birthdate
        String[] mailClients={"gmail.com","outlook.com","yahoo.com","icloud.com","yandex.com"};
        double p=random.nextDouble();
        double d=random.nextDouble();

        //Removes the Turkish characters using regex and casts them to lower case for the mail use
        name=name.toLowerCase().replaceAll("[ş]","s").replaceAll("[ç]","c").replaceAll("[ğ]","g").replaceAll("[ı]","i").replaceAll("[ö]","o").replaceAll("[ü]","u").replaceAll("\s+","");
        surname=surname.toLowerCase().replaceAll("[ş]","s").replaceAll("[ç]","c").replaceAll("[ğ]","g").replaceAll("[ı]","i").replaceAll("[ö]","o").replaceAll("[ü]","u").replaceAll("\s+","");


        if (p<0.6){
            if (d<0.55) {mail = name + "." + surname + "@" + mailClients[0];}
            else if (d<0.95) {mail=name+surname+last2OfBirthYear+"@"+mailClients[0];}
            else {mail = name + "." + surname + "@" + mailClients[0]+".tr";}
        }
        else if (p<0.85){
            if (d<0.55) {mail = name + "." + surname + "@" + mailClients[1];}
            else if (d<0.95) {mail=name+surname+last2OfBirthYear+"@"+mailClients[1];}
            else {mail = name + "." + surname + "@" + mailClients[1]+".tr";}
        }
        else if (p<0.9){
            if (d<0.55) {mail = name + "." + surname + "@" + mailClients[2];}
            else if (d<0.95) {mail=name+surname+last2OfBirthYear+"@"+mailClients[2];}
            else {mail = name + "." + surname + "@" + mailClients[2]+".tr";}
        }
        else if (p<0.95){
            if (d<0.55) {mail = name + "." + surname + "@" + mailClients[3];}
            else if (d<0.95) {mail=name+surname+last2OfBirthYear+"@"+mailClients[3];}
            else {mail = name + "." + surname + "@" + mailClients[3]+".tr";}
        }
        else {mail = name + "." + surname + "@" + mailClients[4];}

        return mail;
    }
}
