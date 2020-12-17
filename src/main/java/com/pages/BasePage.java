package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

	JavascriptExecutor js = (JavascriptExecutor) driver;

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
	public WebElement getElement(By Locator) {
		WebElement localLocator = null;
		try {
			localLocator = driver.findElement(Locator);
			waitForElementPresent(Locator);
			return localLocator;
		} catch (Exception e) {
			System.out.println("Exception in getElement" + Locator.toString());
			e.printStackTrace();
			return localLocator;
		}

	}

	public WebElement getElement(By Locator, String strElementText) {
		WebElement localLocator = null;
		try {

			List<WebElement> AllLocators = driver.findElements(Locator);
			if (AllLocators.size() < 1) {
				System.out.println("No Elements found in the list");
			} else {
				for (WebElement currentLocator : AllLocators) {
					if (currentLocator.getText().contains(strElementText)) {
						System.out.println(currentLocator.getText());
						localLocator = currentLocator;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in getElements " + strElementText);
			e.printStackTrace();
		}
		return localLocator;
	}

	public WebElement getSearchPagination(By Pages, By Locator, String strElementText) {

		int StaleTry = 0;
		Boolean bFound = false;
		WebElement localLocator = null;
		List<WebElement> AllLocators = null;
		List<WebElement> Allpages = null;

		try {

			Allpages = driver.findElements(Pages);
			if (Allpages.size() < 1) {
				System.out.println("No Pages found");
			} else {
				System.out.println("Pages found" + Allpages.size());
			}

			for (int i = 0; i < Allpages.size(); i++) {

				StaleTry = 1;
				while (StaleTry < 2) {
					try {
						waitForTimeOut();
						driver.switchTo().defaultContent();

						AllLocators = driver.findElements(Locator);
						if (AllLocators.size() < 1) {
							System.out.println("No Elements founds in the AllLocators list");
						} else {
							for (WebElement currentLocator : AllLocators) {
								System.out.println(currentLocator.getText());

								if (currentLocator.getText().contains(strElementText)) {
									System.out.println(currentLocator.getText());
									localLocator = currentLocator;
									bFound = true;
									break;
								}
							}
						}

					} catch (StaleElementReferenceException se) {

					}
					StaleTry++;
				}
				
				if  (!bFound) {
					/*
					 * Next Page If Not Found
					 */
					StaleTry = 1;

					while (StaleTry < 2) {
						Allpages = driver.findElements(Pages);
						try {
							js.executeScript("window.scrollBy(0,1200)");

							System.out.println(Allpages.get(i + 1).getText());
							Allpages.get(i + 1).click();

						} catch (StaleElementReferenceException se) {
							se.printStackTrace();
						}
						StaleTry++;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Exception in getElements " + strElementText);
			e.printStackTrace();
		}

		return localLocator;
	}

	public WebElement getAvilableElement(List<By> we) {

		WebElement localLocator = null;

		for (int i = 0; i < we.size(); i++) {

			localLocator = getElement(we.get(i));

			if (localLocator.equals(null)) {
				System.out.println("getAvilableElement = null " + i);
			
			} else {
				System.out.println("getAvilableElement = is not null " + i);
				if (localLocator.isDisplayed()) {
					System.out.println("getAvilableElement isDisplayed " + i);
				}
				break;
			}
		}

		return localLocator;
	}

	@Override
	public void scrollclickElement(By Locator) {
		WebElement localLocator = null;
		try {
			waitForElementPresent(Locator);
			localLocator = driver.findElement(Locator);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", localLocator);
		} catch (Exception e) {
			System.out.println("Exception in getElement" + Locator.toString());
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

	public void waitForElementPresent(WebElement Element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(Element));
		} catch (Exception e) {
			System.out.println("Exception in waitForElementPresent");
			e.printStackTrace();
		}
	}

	public void waitForTimeOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Override
	public String getElementText(By Locator) {
		return getElement(Locator).getText();

	}

	public void doubleClickElement(By Locator) {
		WebElement localLocator = driver.findElement(Locator);
		waitForElementPresent(Locator);
		new Actions(driver).moveToElement(localLocator).build().perform();
		waitForElementPresent(Locator);
		new Actions(driver).doubleClick(localLocator).build().perform();
	}

	public void moveToElementClick(By Locator) {
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");
		waitForElementPresent(Locator);

		WebElement localLocator = driver.findElement(Locator);
		new Actions(driver).moveToElement(localLocator).build().perform();
		localLocator.click();
	}

	public void ClickElement(By Locator) {
		getElement(Locator).click();
	}

	public void switchAllWindow() {

		// It will return the parent window name as a Strings
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
