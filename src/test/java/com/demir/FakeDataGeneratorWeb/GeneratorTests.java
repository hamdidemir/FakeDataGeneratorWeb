package com.demir.FakeDataGeneratorWeb;

import com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity;
import com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomDistrict;
import com.demir.FakeDataGeneratorWeb.Generators.Address.GetRandomNeighborhood;
import com.demir.FakeDataGeneratorWeb.Generators.Personal.GeneratePassword;
import com.demir.FakeDataGeneratorWeb.web.components.PasswordLengthDataModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import static com.demir.FakeDataGeneratorWeb.Generators.Address.GenerateCity.getCityName;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateAge.ageGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateBirthDay.BirthDayGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateNames.NameGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateSurnames.surnameGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Fundamentals.GenerateTCNo.generateTCno;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateEmail.EmailGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateHeight.HeightGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GeneratePhoneNumber.PhoneNumberGenerator;
import static com.demir.FakeDataGeneratorWeb.Generators.Personal.GenerateWeight.WeightGenerator;
import static org.junit.Assert.*;


public class GeneratorTests {

	//Basic tests for the tc no generation
	@Test
	public void testGenerateTCno() {
		long tcNo = generateTCno();
		assertTrue(String.valueOf(tcNo).length() == 11); // check the length of the number
		assertTrue(String.valueOf(tcNo).charAt(0) != '0'); // check that the number does not start with 0
	}

	//Test for the algorithm for the last two digits.
	@Test
	public void testTCNoAlgorithm() {
		long tcNo = generateTCno();
		int tenthDigit = (int)((tcNo / 10) % 10);
		int eleventhDigit = (int)(tcNo % 10);

		int firstDigit = (int)(tcNo /10000000000L) %10;
		int secondDigit = (int)(tcNo /1000000000) % 10;
		int thirdDigit = (int)(tcNo /100000000) % 10;
		int fourthDigit = (int)(tcNo /10000000) % 10;
		int fifthDigit = (int)(tcNo /1000000) % 10;
		int sixthDigit = (int)(tcNo /100000) % 10;
		int seventhDigit = (int)(tcNo /10000) % 10;
		int eighthDigit = (int)(tcNo /1000) % 10;
		int ninthDigit = (int)(tcNo  /100) %10;

		int expectedTenthDigit=((firstDigit+thirdDigit+fifthDigit+seventhDigit+ninthDigit)*7-(secondDigit+fourthDigit+sixthDigit+eighthDigit))%10;
		int expectedEleventhDigit=(firstDigit+secondDigit+thirdDigit+fourthDigit+fifthDigit+sixthDigit+seventhDigit+eighthDigit+ninthDigit+expectedTenthDigit)%10;
		assertEquals(expectedTenthDigit, tenthDigit);
		assertEquals(expectedEleventhDigit, eleventhDigit);
	}


	@Test
	public void testAgeGenerator() {
		int age = ageGenerator();
		int minAge= 0;
		int maxAge=105;
		assertTrue(age >= minAge && age <= maxAge); // check that the returned age is within the valid range
	}


	@Test
	public void testBirthDayGenerator() {
		// Test with age = 20
		String birthday = BirthDayGenerator(20);
		assertTrue(birthday.matches("\\d{2}/\\d{2}/\\d{4}"));

		// Test with age = 30
		birthday = BirthDayGenerator(30);
		assertTrue(birthday.matches("\\d{2}/\\d{2}/\\d{4}"));
	}

	// Checks if name generator returns a string
	@Test
	public void testNameGenerator() throws SQLException {
		String name = NameGenerator();
		assertNotNull(name);
		assertTrue(name.length() > 0);
	}

	// Checks if surname generator returns a string
	@Test
	public void testSurnameGenerator() throws SQLException {
		String surname = surnameGenerator();
		assertNotNull(surname);
		assertTrue(surname.length() > 0);
	}


	// checks the "generate-email" method against a designated regex for the email pattern
	@Test
	public void testEmailGenerator() {
		String name="example";
		String surname="mail";
		int age=66;
		String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
		String email = EmailGenerator(name,surname,age);
		assertNotNull(email);
		assertTrue(EMAIL_PATTERN.matcher(email).matches());
	}

	@Test
	public void testHeightGenerator() {
		int height = HeightGenerator(18, 'M');
		assertTrue(height >= 0); // Height cannot be negative
	}

	@Test
	public void testInvalidGender() {
		try {
			HeightGenerator(18, 'X');
			fail("Exception should be thrown for invalid gender");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid gender: X", e.getMessage());
		}
	}

	@Test
	public void testPasswordGenerator() {
		GeneratePassword PasswordGenerator = null;
		String password = PasswordGenerator.passwordGenerator();

		// Check that the generated password has the expected length
		int expectedLength = PasswordLengthDataModel.getPasswordLength();
		assertEquals(expectedLength, password.length());

		// Check that the generated password only contains valid characters
		String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|':.<>/?";
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			assertTrue(validCharacters.contains(String.valueOf(c)));
		}
	}

	@Test
	public void testPhoneNumberGenerator() {
		String phoneNumber = PhoneNumberGenerator();
		assertNotNull(phoneNumber);
		assertTrue(phoneNumber.matches("\\(5[3-5][0-9]\\) \\d{3}-\\d{2}-\\d{2}"));
	}

	@Test
	public void testWeightGenerator() {
		int weight = WeightGenerator(18, 'F');
		assertTrue(weight >= 0); // Height cannot be negative
	}


	@Test
	public void testGetCityName() throws Exception {
		// Read the JSON file and parse it into a Map<Integer, String> object
		ObjectMapper mapper = new ObjectMapper();
		InputStream jsonStream = GenerateCity.class.getClassLoader().getResourceAsStream("addressData/cities_by_code.json");
		Map<Integer, String> citiesByCode = mapper.readValue(jsonStream, new TypeReference<Map<Integer, String>>() {});

		// Test that the city name returned is not null and is a valid city name
		String cityName = getCityName();
		assertNotNull(cityName);
		assertTrue(citiesByCode.containsValue(cityName));
	}


	@Test
	public void testGetRandomDistrict() throws Exception {
		// Read the JSON file and parse it into a Map<Integer, String[]> object
		ObjectMapper mapper = new ObjectMapper();
		InputStream jsonStream = GetRandomDistrict.class.getClassLoader().getResourceAsStream(GetRandomDistrict.DISTRICTS_BY_CITY_JSON);
		Map<Integer, String[]> districtsByCity = mapper.readValue(jsonStream, new TypeReference<Map<Integer, String[]>>(){});

		Random random = new Random();
		int cityCode = random.nextInt(districtsByCity.size()) + 1;
		String[] districts = districtsByCity.get(cityCode);
		String randomDistrict = GetRandomDistrict.getRandomDistrict(cityCode);

		// Test that the random district returned is not null and is a valid district for the given city code
		assertNotNull(randomDistrict);
		assertTrue(Arrays.asList(districts).contains(randomDistrict));
	}


	@Test
	public void testGetRandomNeighborhood() throws Exception {
		// Read the JSON file and parse it into a Map<Integer, Map<String, String[]>> object
		ObjectMapper mapper = new ObjectMapper();
		InputStream jsonStream = GetRandomNeighborhood.class.getClassLoader().getResourceAsStream(GetRandomNeighborhood.NEIGHBOURHOODS_BY_DISTRICT_AND_CITY_JSON);
		Map<Integer, Map<String, String[]>> neighborhoodsByDistrictAndCity = mapper.readValue(jsonStream, new TypeReference<Map<Integer, Map<String, String[]>>>() {});

		Random random = new Random();
		int cityCode = random.nextInt(neighborhoodsByDistrictAndCity.size()) + 1;
		String[] districts = neighborhoodsByDistrictAndCity.get(cityCode).keySet().toArray(new String[0]);
		String district = districts[random.nextInt(districts.length)];
		String[] neighborhoods = neighborhoodsByDistrictAndCity.get(cityCode).get(district);
		String randomNeighborhood = GetRandomNeighborhood.getRandomNeighborhood(cityCode, district);

		// Test that the random neighborhood returned is not null and is a valid neighborhood for the given city code and district
		assertNotNull(randomNeighborhood);
		assertTrue(Arrays.asList(neighborhoods).contains(randomNeighborhood));
	}


}
