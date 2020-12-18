package com.amazonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;

public class AmazonLogout extends BasePage {

	private By Menulink = By.xpath("//*[@id='nav-hamburger-menu']/i");
	private By Signlink = By
			.xpath("//div[@id='hmenu-canvas']/div[@id='hmenu-content']//a[contains(text(),'Sign Out')]");

	public AmazonLogout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the Menu link
	 */
	public WebElement getMenulink() {
		return getElement(Menulink);
	}

	/**
	 * @return the Sign link
	 */
	public WebElement getSignlink() {
		return getElement(Signlink);
	}

	/**
	 * set the Sign link
	 */
	public void setSignlink() {
		moveToElementClick(Signlink);
	}

	
	
	
	public AmazonLogout mAmazonLogout() {

		getMenulink().click();
		setSignlink();

		return getInstance(AmazonLogout.class);
	}

}
