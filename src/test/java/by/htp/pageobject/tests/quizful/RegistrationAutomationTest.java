package by.htp.pageobject.tests.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.quizful.RegistrSteps;

public class RegistrationAutomationTest {
	private RegistrSteps steps;
	private final String USERNAME = "artemKaptur";
	private final String PASSWORD = "PASSWORD";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new RegistrSteps();
		steps.initBrowser();
	}

	@Test(description = "Registration in Quizful")
	public void quizfulRegistrationTest() throws InterruptedException {
		steps.startRegistration();
		steps.fillAllFields(USERNAME, PASSWORD);
		steps.submitRegistration();
		Assert.assertTrue(steps.proofRegistration());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
