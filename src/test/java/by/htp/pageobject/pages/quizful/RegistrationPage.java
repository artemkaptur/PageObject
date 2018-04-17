package by.htp.pageobject.pages.quizful;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.pageobject.pages.AbstractPage;

public class RegistrationPage extends AbstractPage {
	private final String BASE_URL = "http://www.quizful.net/LoginAction.registration";

	@FindBy(name = "registrationForm.login")
	private WebElement login;

	@FindBy(name = "registrationForm.password")
	private WebElement password;

	@FindBy(name = "registrationForm.repassword")
	private WebElement rePassword;

	@FindBy(name = "registrationForm.email")
	private WebElement email;

	@FindBy(name = "registrationForm.corporate")
	private WebElement corporateCheckBox;

	@FindBy(name = "registrationForm.captcha")
	private WebElement captcha;

	@FindBy(name = "ok")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillFieldsInRegistrForm(String username, String passw) {
		login.sendKeys(username);
		password.sendKeys(passw);
		rePassword.sendKeys(passw);
		email.sendKeys("testprofile@mail.ru");
	}

	public void chooseToBeCorporateClient() {
		corporateCheckBox.click();
	}

	public void fillCaptcha() throws InterruptedException {
		Thread.sleep(7000);
		captcha.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public WebElement getRegistrationProof() {
		WebElement registrationProof = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.className("content")));
		return registrationProof;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
