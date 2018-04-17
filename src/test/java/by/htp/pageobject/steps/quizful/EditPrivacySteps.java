package by.htp.pageobject.steps.quizful;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.pageobject.driver.DriverSingleton;
import by.htp.pageobject.pages.quizful.EditProfilePage;
import by.htp.pageobject.pages.quizful.LoginPage;
import by.htp.pageobject.pages.quizful.YourProfilePage;

public class EditPrivacySteps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.fillFieldsInLoginForm(username, password);
		loginPage.chooseDontRememberMe();
		loginPage.clickSubmitButton();
	}

	public void startEdit() {
		EditProfilePage editPage = new EditProfilePage(driver);
		editPage.startEditPrivacy();
	}

	public void changeVisibility() throws InterruptedException {
		EditProfilePage editPage = new EditProfilePage(driver);
		editPage.changeVisibility();
		logger.info("Visibility was changed");
	}

	public String getPersonalData() {
		YourProfilePage profilePage = new YourProfilePage(driver);
		return profilePage.getPersonalData();
	}

}
