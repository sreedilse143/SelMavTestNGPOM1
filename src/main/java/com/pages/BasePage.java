package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 */

/**
 * @author Acer
 *
 */
public class BasePage extends PageAbstract {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Exception in getPageTitle");
			e.printStackTrace();
			return "Exception in getPageTitle";
		}

	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public void waitForPageTitle(String strPageTitle) {
		try {
			wait.until(ExpectedConditions.titleContains(strPageTitle));
		} catch (Exception e) {
			System.out.println("Exception in waitForPageTitle" + strPageTitle.toString());
			e.printStackTrace();
		}
	}

	@Override
	public WebElement getElemenet(By Locator) {
		WebElement localLocator = null;
		try {
			localLocator = driver.findElement(Locator);
			waitForElementPresent(Locator);
			return localLocator;
		} catch (Exception e) {
			System.out.println("Exception in getElemenet" + Locator.toString());
			e.printStackTrace();
			return localLocator;
		}

	}

	@Override
	public void scrollclickElemenet(By Locator) {
		WebElement localLocator = null;
		try {
			localLocator = driver.findElement(Locator);
			waitForElementPresent(Locator);
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", localLocator);
		} catch (Exception e) {
			System.out.println("Exception in getElemenet" + Locator.toString());
			e.printStackTrace();
		}

	}

	@Override
	public void waitForElementPresent(By Locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		} catch (Exception e) {
			System.out.println("Exception in waitForElementPresent" + Locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public String getElemenetText(By Locator) {
		return getElemenet(Locator).getText();

	}

	public void doubleClickElement(By Locator) {
		Actions aa = new Actions(driver);
		WebElement localLocator = getElemenet(Locator);
		new Actions(driver).moveToElement(localLocator).build().perform();
		Action mo = aa.doubleClick(localLocator).build();
		mo.perform();
	}

	public void moveToElementClick(By Locator) {
		WebElement localLocator = getElemenet(Locator);
		new Actions(driver).moveToElement(localLocator).build().perform();
		localLocator.click();
	}

	public void ClickElement(By Locator) {
		getElemenet(Locator).click();
	}

	public void switchAllWindow() {

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.getTitle());

				// driver.close();
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());

	}

	public void switchChildBrowser() {

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.getTitle());
			}
		}

		driver.switchTo().defaultContent();
	}
}
