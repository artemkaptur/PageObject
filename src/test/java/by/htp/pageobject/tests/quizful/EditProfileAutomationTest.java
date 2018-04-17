package by.htp.pageobject.tests.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.quizful.EditProfileSteps;

public class EditProfileAutomationTest {
	private EditProfileSteps steps;
	
	private final String USERNAME = "artemKaptur";
	private final String PASSWORD = "PASSWORD";
	private final String NAME = "Artem";
	private final String SURNAME = "Kaptur";
	private final String BIRTH_DATE = "1994";
	private final String SITE = "epam.com";
	private final String COMPANY = "epam";
	private final String COUNTRY = "Беларусь";
	private final String CITY = "Минск";
	private final String TIME_ZONE = "Белоруссия/Минск(GMT+3)";
	private final String ABOUT = "Good guy";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new EditProfileSteps();
		steps.initBrowser();
	}

	@Test(description = "Edit personal data in profile")
	public void quizfulEditProfileTest() {
		steps.login(USERNAME, PASSWORD);
		steps.startEdit();
		steps.editProfile(NAME, SURNAME, BIRTH_DATE, SITE, COMPANY, COUNTRY, CITY, TIME_ZONE, ABOUT);
		steps.saveEditings();
		
		String personalData = steps.getPersonalData();
		Assert.assertTrue(
				personalData.contains(NAME) && personalData.contains(SURNAME) && personalData.contains(ABOUT));
		Assert.assertTrue(personalData.contains(BIRTH_DATE) && personalData.contains(SITE));
		Assert.assertTrue(personalData.contains(COMPANY) && personalData.contains(COUNTRY));
		Assert.assertTrue(personalData.contains(CITY) && personalData.contains(TIME_ZONE));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
