package by.htp.pageobject.steps.google;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.pageobject.driver.DriverSingleton;
import by.htp.pageobject.pages.google.ResultsPage;
import by.htp.pageobject.pages.google.SearchPage;

public class SearchSteps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void startSearch(String key) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.openPage();
		searchPage.beginSearch(key);
	}

	public List<WebElement> getFindedElements() {
		ResultsPage resultsPage = new ResultsPage(driver);
		List<WebElement> searchResults = resultsPage.getResults();

		logger.info("Count of finded elements: " + searchResults.size());
		return searchResults;
	}

}
