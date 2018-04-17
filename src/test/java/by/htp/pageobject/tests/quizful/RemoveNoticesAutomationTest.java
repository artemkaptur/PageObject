package by.htp.pageobject.tests.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.quizful.RemoveNoticesSteps;

public class RemoveNoticesAutomationTest {
	private RemoveNoticesSteps steps;

	private final String USERNAME = "artemKaptur";
	private final String PASSWORD = "PASSWORD";
	private final String NOTICES_DISABLED = "выключены";
	private final String DELIVERY_DISABLED = "нет";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new RemoveNoticesSteps();
		steps.initBrowser();
	}

	@Test(description = "Removing notices")
	public void quizfulRemoveNoticesTest() throws InterruptedException {
		steps.login(USERNAME, PASSWORD);
		steps.startEdit();
		steps.removeNotices();

		String personalData = steps.getPersonalData();
		String deliveryAbility = steps.getDeliveryAbility();
		Assert.assertTrue(deliveryAbility.equals(DELIVERY_DISABLED));
		Assert.assertTrue(personalData.contains(NOTICES_DISABLED));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
