package by.htp.pageobject.steps.quizful;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.pageobject.driver.DriverSingleton;
import by.htp.pageobject.pages.quizful.EditProfilePage;
import by.htp.pageobject.pages.quizful.LoginPage;
import by.htp.pageobject.pages.quizful.YourProfilePage;

public class EditProfileSteps {
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
		editPage.startEditPersonalData();
	}

	public void editProfile(String name, String surname, String birth, String site, String company, String country,
			String city, String time, String about) {
		EditProfilePage editPage = new EditProfilePage(driver);
		editPage.fillFieldsPersonalData(name, surname, birth, site, company, about);
		editPage.sellectFieldsPersonalData(country, city, time);

		logger.info("Personal data is edited");
	}

	public void saveEditings() {
		EditProfilePage editPage = new EditProfilePage(driver);
		editPage.clickSaveEditings();
	}

	public String getPersonalData() {
		YourProfilePage profilePage = new YourProfilePage(driver);
		return profilePage.getPersonalData();
	}

}
