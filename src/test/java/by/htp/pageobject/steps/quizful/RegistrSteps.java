package by.htp.pageobject.steps.quizful;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.pageobject.driver.DriverSingleton;
import by.htp.pageobject.pages.quizful.RegistrationPage;
import by.htp.pageobject.pages.quizful.MainPage;

public class RegistrSteps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void startRegistration() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnRegistrationButton();
	}

	public void fillAllFields(String username, String password) throws InterruptedException {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.fillFieldsInRegistrForm(username, password);
		registrationPage.chooseToBeCorporateClient();
		registrationPage.fillCaptcha();
	}

	public void submitRegistration() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.clickSubmitButton();
		logger.info("Registration performed");
	}

	public boolean proofRegistration() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		if (registrationPage.getRegistrationProof().getText().contains("Регистрация прошла успешно"))
			return true;
		else
			return false;
	}
}
