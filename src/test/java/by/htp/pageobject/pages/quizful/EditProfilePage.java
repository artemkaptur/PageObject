package by.htp.pageobject.pages.quizful;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import by.htp.pageobject.pages.AbstractPage;

public class EditProfilePage extends AbstractPage {

	@FindBy(xpath = "//*[@id='user-panel']/li[1]/b/a")
	private WebElement currentUser;

	@FindBy(xpath = "//*[@id='middle']/div[2]/div[1]/div[2]/div/a")
	private WebElement editProfile;

	@FindBy(xpath = "//*[@id='profile-personal-form']/div[2]/img")
	private WebElement personalData;

	@FindBy(xpath = "//*[@id='profile-notifications-form']/div[1]/img")
	private WebElement notices;

	@FindBy(xpath = "//*[@id='profile-privacy-form']/div[1]/b")
	private WebElement privacy;

	@FindBy(name = "notificationsForm.notificationsEnabled")
	private WebElement noticesCheckBox;

	@FindBy(name = "notificationsForm.deliveryEnabled")
	private WebElement deliveryChekBox;

	@FindBy(name = "notificationsForm.save")
	private WebElement saveNotices;

	@FindBy(xpath = "//*[@id='profile-privacy-form']/div[2]/form/table/tbody/tr[4]/td[1]/label/input")
	private WebElement visibility;

	@FindBy(name = "privacyForm.save")
	private WebElement saveVisibility;

	@FindBy(name = "personalForm.name")
	private WebElement name;

	@FindBy(name = "personalForm.surname")
	private WebElement surname;

	@FindBy(name = "personalForm.birthyear")
	private WebElement birthDate;

	@FindBy(name = "personalForm.site")
	private WebElement site;

	@FindBy(name = "personalForm.company")
	private WebElement company;

	@FindBy(name = "personalForm.countryId")
	private WebElement country;

	@FindBy(name = "personalForm.cityId")
	private WebElement city;

	@FindBy(name = "personalForm.zone")
	private WebElement timeZone;

	@FindBy(name = "personalForm.about")
	private WebElement aboutYouself;

	@FindBy(name = "personalForm.save")
	private WebElement saveEditings;

	public EditProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void startEditPersonalData() {
		startEditProfile();
		personalData.click();
	}

	public void startEditNotices() {
		startEditProfile();
		notices.click();
	}

	public void startEditPrivacy() {
		startEditProfile();
		privacy.click();
	}

	private void startEditProfile() {
		currentUser.click();
		editProfile.click();
	}

	public void fillFieldsPersonalData(String name, String surname, String birth, String site, String company, String about) {
		this.name.sendKeys(name);
		this.surname.sendKeys(surname);
		birthDate.sendKeys(birth);
		this.site.sendKeys(site);
		this.company.sendKeys(company);
		aboutYouself.sendKeys(about);
	}

	public void sellectFieldsPersonalData(String country, String city, String time) {
		Select selectCountry = new Select(this.country);
		selectCountry.selectByVisibleText(country);
		Select selectCity = new Select(this.city);
		selectCity.selectByVisibleText(city);
		Select selectTimeZone = new Select(timeZone);
		selectTimeZone.selectByVisibleText(time);
	}

	public void clickSaveEditings() {
		saveEditings.click();
	}

	public void removeNotices() throws InterruptedException {
		Thread.sleep(4000);
		noticesCheckBox.click();
		deliveryChekBox.click();
		saveNotices.click();
	}

	public void changeVisibility() throws InterruptedException {
		Thread.sleep(4000);
		visibility.click();
		saveVisibility.click();
	}

	@Override
	public void openPage() {

	}

}
