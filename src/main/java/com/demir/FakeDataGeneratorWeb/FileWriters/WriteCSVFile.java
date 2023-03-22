package com.demir.FakeDataGeneratorWeb.FileWriters;

import com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity;
import com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateAge;
import com.demir.FakeDataGeneratorWeb.web.components.NumberOfPeopleDataModel;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.cityCode;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.getCityName;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateRegion.getRegion;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomDistrict.getRandomDistrict;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomNeighborhood.getRandomNeighborhood;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.StreetBuildingFlatNoGenerator.getRandomStreetBuildingFlat;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateAge.ageGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateBirthDay.BirthDayGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateNames.Gender;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateNames.NameGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateSurnames.surnameGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateTCNo.generateTCno;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateEmail.EmailGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateHeight.HeightGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GeneratePassword.passwordGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GeneratePhoneNumber.PhoneNumberGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateWeight.WeightGenerator;

@Component
public class WriteCSVFile {
    public void main() {
        try {

            // Set up the file writer
            FileWriter fileWriter = new FileWriter("random_data.csv", StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the header row
            bufferedWriter.write("Name,Surname,Age,Tc No,e-mail,Password,Phone Number,Gender,Date Of Birth,City,District,Neighborhood,Address,Region,Height,Weight");
            bufferedWriter.newLine();

            int rows= NumberOfPeopleDataModel.getNumberOfPeople();



            // Generate and write 100 rows of random data
            for (int i = 0; i < rows; i++) {
                //Generate name
                String name= NameGenerator();

                //Generate surname
                String surname= surnameGenerator();

                // Generate age
                int age = ageGenerator();

                //Generate TcNo
                long TcNo = generateTCno();

                //Generate email
                String email=EmailGenerator(name,surname,age);

                //Generate password
                String password= passwordGenerator();

                //Generate phone number
                String phoneNumber=PhoneNumberGenerator();

                //Generate a random birthday using the previously generated age
                String dateOfBirth=BirthDayGenerator(age);

                // Generate City
                String city=GenerateCity.getCityName();

                //GenerateDistrict
                String district=getRandomDistrict(cityCode);

                //GenerateNeighborhood
                String neighborhood=getRandomNeighborhood(cityCode,district);

                //Generate the rest of the address
                String address=getRandomStreetBuildingFlat();

                //Generate GenerateRegion
                String region=getRegion(city);

                //Generate Height
                int height=HeightGenerator(age,Gender);

                //Generate Weight
                int weight=WeightGenerator(age,Gender);

                // Write the data to the file
                bufferedWriter.write(name + "," + surname + "," + age + "," + TcNo + "," + email +","+ password + "," +phoneNumber+ "," + Gender + "," + dateOfBirth + "," + city + "," + district + "," + neighborhood + "," + address + "," + region+ "," + height+"," + weight);
                bufferedWriter.newLine();
            }

            // Close the file
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}