package com.letgo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.letgo.tests.pages.basepage.BasePage;
import com.letgo.tests.utils.Utils;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	String iniFile = "/resources/config/testStation.ini";
	/** Url for the main page. */
	String baseUrl = Utils.getIniFileValue("base.url", iniFile);

	/**
	 * Maximize the browser window, set url, and open this url
	 */
	public void openMainPage() {
		maximizeBrowserScreen();
		driver.get(baseUrl);
	}

	public void clickStayInUS() {
		By stayInUS = By.xpath("(//button[@data-test=\"update-location-cancel\"])");
		waitForElement(stayInUS).click();
	}

	public void logIn() {
		By logIn = By.xpath("(//button[@data-test=\"login\"])");
		waitForElement(logIn).click();
	}

	public void signUp() {
		By signUp = elementBySpanText("Sign Up");
		waitForElement(signUp).click();
	}

	public void searchItem(String text) {
		By search = By.name("searchField");
		waitForElement(search).sendKeys(text);
		driver.findElement(search).sendKeys(Keys.RETURN);
	}

	public boolean isItemFound(String item) {
		By by = By.xpath("//h4[contains(@class, 'capitalize m0') and contains(., '" + item + "')] ");
		return isElementDisplayed(by);
	}

	public void clickCars() {
		By cars = By.xpath("(//div[@data-test=\"cars\"])");
		waitForElement(cars).click();
	}

	public void clickSellYourStaff() {
		By sell = By.xpath("(//button[@data-test=\"sell-your-stuff-button\"])");
		waitForElement(sell).click();
	}

	public void clickDragAndDropOrBrowse() {
		By dragDropBrowse = By.xpath("(//p[@data-test=\"post-product-image\"])");
		waitForElement(dragDropBrowse).click();
	}

	public void confirmUploadPhoto() {
		By done = By.xpath("(//button[@data-test=\"confirm-sell-button\"])");
		waitForElement(done).click();
	}
}
