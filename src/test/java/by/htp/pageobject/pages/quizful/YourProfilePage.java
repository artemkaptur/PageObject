package by.htp.pageobject.pages.quizful;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.pageobject.pages.AbstractPage;

public class YourProfilePage extends AbstractPage {

	@FindBy(xpath = "//*[@id='middle']/div[2]/div[1]")
	private WebElement personalData;

	@FindBy(xpath = "//*[@id='personal-contacts']/dd[8]")
	private WebElement deliveryAbility;

	public YourProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getPersonalData() {
		return personalData.getText();
	}

	public String getDeliveryAbility() {
		return deliveryAbility.getText();
	}

	@Override
	public void openPage() {

	}

}
