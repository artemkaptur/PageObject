package by.htp.pageobject.tests.google;

import static by.htp.pageobject.steps.util.PrintListToConsole.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageobject.steps.google.SearchSteps;

public class GoogleSearchAutomationTest {
	private SearchSteps steps;
	private final String key = "Java";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new SearchSteps();
		steps.initBrowser();
	}

	@Test(description = "Search in google")
	public void searchInGoogleTest() {
		steps.startSearch(key);
		printList(steps.getFindedElements());
		Assert.assertTrue(steps.getFindedElements().size() != 0);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
