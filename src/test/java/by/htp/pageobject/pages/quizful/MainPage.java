package by.htp.pageobject.pages.quizful;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.pageobject.pages.AbstractPage;

public class MainPage extends AbstractPage {

	private final String BASE_URL = "http://www.quizful.net/test";

	@FindBy(xpath = "//*[@id='user-panel']/li[3]/a")
	private WebElement registrationButton;

	@FindBy(xpath = "//*[@id='user-panel']/li[1]/a")
	private WebElement loginButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnRegistrationButton() {
		registrationButton.click();
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
