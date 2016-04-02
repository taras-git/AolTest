package com.aol.tests.pages.autoblogpages;

import org.openqa.selenium.WebDriver;

import com.aol.tests.pages.basepage.BasePage;

public class AutoBlogPage extends BasePage {

	public AutoBlogPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if Auto blog logo is present on the web page.
	 *
	 * @return true, if Auto blog logo is present
	 */
	public boolean isLogoPresent() {
		String xpath = ".//img[@alt=\"Autoblog Logo\"]";
		return isElementPresentByXpath(xpath);
	}

}
