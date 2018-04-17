package by.htp.pageobject.steps.quizful;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.pageobject.driver.DriverSingleton;
import by.htp.pageobject.pages.quizful.LoginPage;
import by.htp.pageobject.pages.quizful.MainPage;

public class LoginSteps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void startLogin() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnLoginButton();
	}

	public void fillAllFields(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillFieldsInLoginForm(username, password);
		loginPage.chooseDontRememberMe();
	}

	public void submitLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSubmitButton();
		logger.info("Login performed");
	}

	public boolean proofLogin() {
		LoginPage loginPage = new LoginPage(driver);
		if (loginPage.getCurrentUser().getText().contains("artemKaptur"))
			return true;
		else
			return false;
	}
}
