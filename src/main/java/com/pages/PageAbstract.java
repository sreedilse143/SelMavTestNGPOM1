
/*
 * Helps in All utilities Hiding the Drive code, Page Code, utilities code
 */

package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAbstract {

	WebDriver driver;
	WebDriverWait wait;

	public PageAbstract(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);

	}

	
	public abstract String getPageTitle();
	
	public abstract String getPageURL();
	
	public abstract void waitForPageTitle(String strPageTitle);
	
	public abstract WebElement getElemenet(By Locator);
	
	public abstract void waitForElementPresent(By Locator);
	
	public abstract String getElemenetText(By Locator);

	public abstract void doubleClickElement(By Locator);

	public abstract void ClickElement(By Locator);

	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
