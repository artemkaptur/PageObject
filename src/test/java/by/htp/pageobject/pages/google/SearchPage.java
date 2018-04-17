package by.htp.pageobject.pages.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.pageobject.pages.AbstractPage;

public class SearchPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://google.by";

	@FindBy(name = "q")
	private WebElement searchField;

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void beginSearch(String key) {
		searchField.sendKeys(key);
		searchField.submit();
		logger.info("Search started");
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
