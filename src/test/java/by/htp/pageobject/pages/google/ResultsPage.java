package by.htp.pageobject.pages.google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import by.htp.pageobject.pages.AbstractPage;

public class ResultsPage extends AbstractPage {

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getResults() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='rso']/div/div/div/div/div/h3/a"));
		return searchResults;
	}

	@Override
	public void openPage() {

	}
}
