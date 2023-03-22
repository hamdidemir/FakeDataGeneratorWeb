package com.demir.FakeDataGeneratorWeb.FileWriters;
import com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity;
import com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateAge;
import com.demir.FakeDataGeneratorWeb.web.components.NumberOfPeopleDataModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.demir.FakeDataGeneratorWeb.FileWriters.XLSXFormatter.CellStyleProviderXLS.*;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.cityCode;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.getCityName;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateRegion.getRegion;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomDistrict.getRandomDistrict;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomNeighborhood.getRandomNeighborhood;
import static com.demir.FakeDataGeneratorWeb.Generators.Address.StreetBuildingFlatNoGenerator.getRandomStreetBuildingFlat;
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
public class WriteXLSXFile {
    public void main() {
        try {
            int rows= NumberOfPeopleDataModel.getNumberOfPeople();
            String[] headers = {"Name", "Surname", "Age", "Tc No", "e-mail", "Password", "Phone Number", "Gender", "Date Of Birth", "City", "District", "Neighborhood", "Address", "Region", "Height", "Weight"};

            // Create a workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            // Create a sheet
            XSSFSheet sheet = workbook.createSheet("Random Data");

            //Calling styles for the excel file.
            XSSFCellStyle style1 = getStyle1(workbook);
            XSSFCellStyle style2 = getStyle2(workbook);
            XSSFCellStyle style3 = getStyle3(workbook);

            // Create the header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(style3);
            }


            // Generate and write 100 rows of random data
            for (int i = 0; i < rows; i++) {
                Row dataRow = sheet.createRow(i + 1);

                // Generate name
                String name = NameGenerator();
                Cell nameCell = dataRow.createCell(0);
                nameCell.setCellValue(name);
                if (i % 2 == 0) {nameCell.setCellStyle(style1);} else {nameCell.setCellStyle(style2);}

                // Generate surname
                String surname = surnameGenerator();
                Cell surnameCell = dataRow.createCell(1);
                surnameCell.setCellValue(surname);
                if (i % 2 == 0) {surnameCell.setCellStyle(style1);} else {surnameCell.setCellStyle(style2);}

                // Generate age
                GenerateAge ageInstance=new GenerateAge();
                int age = ageInstance.ageGenerator();
                Cell ageCell = dataRow.createCell(2);
                ageCell.setCellValue(age);
                if (i % 2 == 0) {ageCell.setCellStyle(style1);} else {ageCell.setCellStyle(style2);}

                // Generate Tc Number
                long tcNo = generateTCno();
                Cell tcNoCell = dataRow.createCell(3);
                tcNoCell.setCellValue(tcNo);
                if (i % 2 == 0) {tcNoCell.setCellStyle(style1);} else {tcNoCell.setCellStyle(style2);}

                //Generate email
                String email=EmailGenerator(name,surname,age);
                Cell emailCell = dataRow.createCell(4);
                emailCell.setCellValue(email);
                if (i % 2 == 0) {emailCell.setCellStyle(style1);} else {emailCell.setCellStyle(style2);}

                //Generate password
                String password= passwordGenerator();
                Cell passwordCell = dataRow.createCell(5);
                passwordCell.setCellValue(password);
                if (i % 2 == 0) {passwordCell.setCellStyle(style1);} else {passwordCell.setCellStyle(style2);}

                //Generate phone number
                String phoneNumber=PhoneNumberGenerator();
                Cell phoneCell = dataRow.createCell(6);
                phoneCell.setCellValue(phoneNumber);
                if (i % 2 == 0) {phoneCell.setCellStyle(style1);} else {phoneCell.setCellStyle(style2);}

                //Retrieve gender
                String gender=Character.toString(Gender);
                Cell genderCell = dataRow.createCell(7);
                genderCell.setCellValue(gender);
                if (i % 2 == 0) {genderCell.setCellStyle(style1);} else {genderCell.setCellStyle(style2);}

                //Generate a random birthday using the previously generated age
                String dateOfBirth=BirthDayGenerator(age);
                Cell birthDateCell = dataRow.createCell(8);
                birthDateCell.setCellValue(dateOfBirth);
                if (i % 2 == 0) {birthDateCell.setCellStyle(style1);} else {birthDateCell.setCellStyle(style2);}

                // Generate City
                String city=getCityName();
                Cell cityCell = dataRow.createCell(9);
                cityCell.setCellValue(city);
                if (i % 2 == 0) {cityCell.setCellStyle(style1);} else {cityCell.setCellStyle(style2);}

                //GenerateDistrict
                String district=getRandomDistrict(cityCode);
                Cell districtCell = dataRow.createCell(10);
                districtCell.setCellValue(district);
                if (i % 2 == 0) {districtCell.setCellStyle(style1);} else {districtCell.setCellStyle(style2);}

                //GenerateNeighborhood
                String neighborhood=getRandomNeighborhood(cityCode,district);
                Cell neighborhoodCell = dataRow.createCell(11);
                neighborhoodCell.setCellValue(neighborhood);
                if (i % 2 == 0) {neighborhoodCell.setCellStyle(style1);} else {neighborhoodCell.setCellStyle(style2);}

                //Generate the rest of the address
                String address=getRandomStreetBuildingFlat();
                Cell addressCell = dataRow.createCell(12);
                addressCell.setCellValue(address);
                if (i % 2 == 0) {addressCell.setCellStyle(style1);} else {addressCell.setCellStyle(style2);}

                //Generate GenerateRegion
                String region=getRegion(city);
                Cell regionCell = dataRow.createCell(13);
                regionCell.setCellValue(region);
                if (i % 2 == 0) {regionCell.setCellStyle(style1);} else {regionCell.setCellStyle(style2);}

                //Generate Height
                int height=HeightGenerator(age,Gender);
                Cell heightCell = dataRow.createCell(14);
                heightCell.setCellValue(height);
                if (i % 2 == 0) {heightCell.setCellStyle(style1);} else {heightCell.setCellStyle(style2);}

                //Generate Weight
                int weight=WeightGenerator(age,Gender);
                Cell weightCell = dataRow.createCell(15);
                weightCell.setCellValue(weight);
                if (i % 2 == 0) {weightCell.setCellStyle(style1);} else {weightCell.setCellStyle(style2);}
            }

            //Formatting the column width
            for(int i=0;i<headers.length;i++) {
                sheet.setColumnWidth(0, 10 * 256);
                sheet.setColumnWidth(1, 15 * 256);
                sheet.setColumnWidth(4, 30 * 256);
                sheet.setColumnWidth(9, 20 * 256);
                sheet.setColumnWidth(10, 20 * 256);
                sheet.setColumnWidth(11, 20 * 256);
                sheet.autoSizeColumn(i); // Rest can be automatic
            }

            // Insert auto filter for the table
            CellRangeAddress range = new CellRangeAddress(0, rows, 0, headers.length);
            sheet.setAutoFilter(range);

            // Write the workbook to a file
            FileOutputStream fileOut = new FileOutputStream("random_data.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Close the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
