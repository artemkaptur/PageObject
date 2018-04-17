package by.htp.pageobject.tests.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.quizful.LoginSteps;

public class LoginAutomationTest {
	private LoginSteps steps;
	private final String USERNAME = "artemKaptur";
	private final String PASSWORD = "PASSWORD";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new LoginSteps();
		steps.initBrowser();
	}

	@Test(description = "Login in Quizful")
	public void quizfulLoginTest() throws InterruptedException {
		steps.startLogin();
		steps.fillAllFields(USERNAME, PASSWORD);
		steps.submitLogin();
		Assert.assertTrue(steps.proofLogin());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
