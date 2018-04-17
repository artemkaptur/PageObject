package by.htp.pageobject.tests.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.quizful.EditPrivacySteps;

public class PrivacySettingsAutomationTest {

	private EditPrivacySteps steps;

	private final String USERNAME = "artemKaptur";
	private final String PASSWORD = "PASSWORD";
	private final String ONLY_NE_PRIVACY = "только мне";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new EditPrivacySteps();
		steps.initBrowser();
	}

	@Test(description = "Edit privacy setting")
	public void quizfulEditPrivacyTest() throws InterruptedException {
		steps.login(USERNAME, PASSWORD);
		steps.startEdit();
		steps.changeVisibility();

		String personalData = steps.getPersonalData();
		Assert.assertTrue(personalData.contains(ONLY_NE_PRIVACY));

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
