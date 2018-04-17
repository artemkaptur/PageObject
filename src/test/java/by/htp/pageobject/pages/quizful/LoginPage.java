package by.htp.pageobject.pages.quizful;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.pageobject.pages.AbstractPage;

public class LoginPage extends AbstractPage {
	private final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";

	@FindBy(name = "loginForm.login")
	private WebElement login;

	@FindBy(name = "loginForm.password")
	private WebElement password;

	@FindBy(name = "loginForm.rememberMe")
	private WebElement rememberMeCheckBox;

	@FindBy(name = "ok")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='user-panel']/li[1]/b/a")
	private WebElement currentUser;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillFieldsInLoginForm(String username, String passw) {
		login.sendKeys(username);
		password.sendKeys(passw);
	}

	public void chooseDontRememberMe() {
		rememberMeCheckBox.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public WebElement getCurrentUser() {
		return currentUser;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
