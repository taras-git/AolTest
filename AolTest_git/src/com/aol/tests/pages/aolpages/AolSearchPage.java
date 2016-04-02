package com.aol.tests.pages.aolpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aol.tests.pages.basepage.BasePage;


public class AolSearchPage extends BasePage{

	public AolSearchPage(WebDriver driver) {
		super(driver);
	}

	
	/**
	 * Checks if a link with text "Web" can be found on the web page.
	 *
	 * @return true, if the link present on the web page
	 */
	public boolean isWebLinkPresent() {
		String xpath = ".//div[contains(text(),\"Web\")]";
		return isElementPresentByXpath(xpath);
	}

	/**
	 * Checks if a link with id "mail" can be found on the web page.
	 *
	 * @return true, if the link present on the web page
	 */
	public boolean isMailLinkPresent() {
		String xpath = ".//*[@id=\"mail\"]";
		return isElementPresentByXpath(xpath);
	}

	/**
	 * Check if the link "www.autoblog.com" is present on the result search
	 * page, click on it, and opens a new tab for it
	 *
	 * @return true, if successful
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public boolean clickAutoBlog() throws InterruptedException {
		String xpath = "//*[@href=\"http://www.autoblog.com/\"]";
		if (isElementPresentByXpath(xpath)){
			openLinkInNewTab(By.xpath(xpath));
			return true;
		}
		return false;
	}

}
