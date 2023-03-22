package com.demir.FakeDataGeneratorWeb.web;

import com.demir.FakeDataGeneratorWeb.FileWriters.WriteCSVFile;
import com.demir.FakeDataGeneratorWeb.FileWriters.WriteXLSXFile;
import com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateRegion;
import com.demir.FakeDataGeneratorWeb.web.components.AgeRangeDataModel;
import com.demir.FakeDataGeneratorWeb.web.components.NumberOfPeopleDataModel;
import com.demir.FakeDataGeneratorWeb.web.components.PasswordLengthDataModel;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.cityCode;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.getCityName;
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

@Validated
@Controller
public class controller {

    @Autowired
    private WriteCSVFile writeCSVFile;

    @Autowired
    private WriteXLSXFile writeXLSXFile;


    @GetMapping("/generate-csv")
    public void generateCSVFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=random_data.csv");

        //Create the file again
        writeCSVFile.main();

        //Read from the file and copy them to new file. This is because directly referencing WriteCSVFile.main() method did not work.
        File file = new File("random_data.csv");
        InputStream inputStream = new FileInputStream(file);
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }


    @GetMapping("/generate-xlsx")
    public void generateXLSXFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=random_data.xlsx");

        //Create the file again
        writeXLSXFile.main();

        //Read from the file and copy them to new file. This is because directly referencing WriteXLSXFile.main() method did not work.
        File file = new File("random_data.xlsx");
        InputStream inputStream = new FileInputStream(file);
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

    @PostMapping("/take-password")
    public String processFormPassword(@RequestParam("passwordLength") int passwordLength) {
        // Store the password length in the data model
        PasswordLengthDataModel.setPasswordLength(passwordLength);
        return "index";
    }

    @PostMapping("/take-age-range")
    public String processFormAge(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        AgeRangeDataModel.setMinAge(minAge);
        AgeRangeDataModel.setMaxAge(maxAge);
        return "index";
    }


    @PostMapping("/take-row")
    public String processFormRows(@RequestParam("numberOfPeople") int numberOfPeople) {
        // Store the numberOfPeople value in the data model
        NumberOfPeopleDataModel.setNumberOfPeople(numberOfPeople);
        return "index";
    }



    @GetMapping("/age")
    public ResponseEntity<String> getAge() {
        int age = ageGenerator();
        return ResponseEntity.ok(Integer.toString(age));
    }

    @GetMapping("/dateOfBirth")
    public ResponseEntity<String> getDateOfBirth(@RequestParam int age) {
        String dateOfBirth = BirthDayGenerator(age);
        return ResponseEntity.ok(dateOfBirth);
    }

    @GetMapping("/phoneNumber")
    public ResponseEntity<String> getPhoneNumber() {
        String phoneNumber=PhoneNumberGenerator();
        return ResponseEntity.ok(phoneNumber);
    }

    @GetMapping("/name")
    public ResponseEntity<String> getName() throws SQLException {
        String name = NameGenerator();
        return ResponseEntity.ok(name);
    }

    @GetMapping("/surname")
    public ResponseEntity<String> getSurname() throws SQLException {
        String surname = surnameGenerator();
        return ResponseEntity.ok(surname);
    }

    @GetMapping("/tcno")
    public ResponseEntity<String> getTcNo(){
        long TcNo = generateTCno();
        return ResponseEntity.ok(Long.toString(TcNo));
    }


    @GetMapping("/email")
    public ResponseEntity<String> getEmail(@RequestParam String name, @RequestParam String surname, @RequestParam int age) {
        String email = EmailGenerator(name, surname, age);
        return ResponseEntity.ok(email);
    }

    @GetMapping("/password")
    public ResponseEntity<String> getPassword(){
        String password= passwordGenerator();
        return ResponseEntity.ok(password);
    }

    @GetMapping("/city")
    public ResponseEntity<String> getCity() throws Exception {
        String city = getCityName();
        return ResponseEntity.ok(city);
    }

    @GetMapping("/citycode")
    public ResponseEntity<String> getCityCode() throws Exception {
        return ResponseEntity.ok(Integer.toString(cityCode));
    }


    @GetMapping("/district")
    public ResponseEntity<String> getDistrict(@RequestParam int cityCode) throws Exception {
        String district = getRandomDistrict(cityCode);
        return ResponseEntity.ok(district);
    }

    @GetMapping("/neighborhood")
    public ResponseEntity<String> getNeighborhood(@RequestParam int cityCode, @RequestParam String district) throws Exception {
        String neighborhood = getRandomNeighborhood(cityCode, district);
        return ResponseEntity.ok(neighborhood);
    }

    @GetMapping("/address")
    public ResponseEntity<String> getAddress() {
        String address = getRandomStreetBuildingFlat();
        return ResponseEntity.ok(address);
    }

    @GetMapping("/region")
    public ResponseEntity<String> getRegion(@RequestParam String city) {
        String region = GenerateRegion.getRegion(city);;
        return ResponseEntity.ok(region);
    }

    @GetMapping("/height")
    public ResponseEntity<Integer> getHeight(@RequestParam int age, @RequestParam char gender) {
        int height = HeightGenerator(age, gender);
        return ResponseEntity.ok(height);
    }

    @GetMapping("/weight")
    public ResponseEntity<Integer> getWeight(@RequestParam int age, @RequestParam char gender) {
        int weight = WeightGenerator(age, gender);
        return ResponseEntity.ok(weight);
    }

    @GetMapping("/gender")
    public ResponseEntity<String> getGender() throws Exception {
        return ResponseEntity.ok(Character.toString(Gender));
    }


}
