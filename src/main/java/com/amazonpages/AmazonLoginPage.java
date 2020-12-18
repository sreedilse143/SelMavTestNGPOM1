package com.amazonpages;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;

public class AmazonLoginPage extends BasePage {

	private By AmazonSignIn= By.xpath("//a[@id='nav-link-accountList']/div/span[contains(text(),'Sign in')]");
	
	private By AmazonLogo = By.xpath("//a[@class='a-link-nav-icon']");
	private By AmazonUserName = By.id("ap_email");
	private By ContinueButton = By.xpath("//input[@id='continue']");
	
	private By loginUserName = By.xpath("//div[@id='authportal-main-section']//div[@class='a-box-inner a-padding-extra-large']/div[1]/span[1]");
	private By AmazonPassword = By.id("ap_password");
	private By LoginButton = By.id("signInSubmit");

	public AmazonLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the getAmazonTitle
	 */
	public String getAmazonTitle() {
		return getPageTitle();
	}

	/**
	 * @return the login
	 */

	public void doubleClickAmazonSignIn() {
		doubleClickElement(AmazonSignIn);
	}
	
	/**
	 * @return the amazonLogo
	 */
	public WebElement getAmazonLogo() {
		return getElement(AmazonLogo);
	}

	/**
	 * @return the amazonUserName
	 */
	public WebElement getAmazonUserName() {
		waitForElementPresent(AmazonUserName);
		return getElement(AmazonUserName);
	}

	/**
	 * @return the amazonPassword
	 */
	public WebElement getAmazonPassword() {
		return getElement(AmazonPassword);
	}

	
	private WebElement getloginUserName() {
		return getElement(loginUserName);
		
	}
	
	/**
	 * @return the continue
	 */
	public WebElement getContinueButton() {
		return getElement(ContinueButton);
	}

	/**
	 * @return the login
	 */
	public WebElement getLoginButton() {
		return getElement(LoginButton);

	}
	
	
	
	/**
	 * login
	 */
	
	public AmazonLoginPage mlogin(String p_Username, String p_password) {

		//getAmazonTitle();
		//getAmazonLogo();
		
		doubleClickAmazonSignIn();		
				
		getAmazonUserName().sendKeys(p_Username);
		getContinueButton().click();
		
		getloginUserName();
		
		byte[] b = Base64.getDecoder().decode(p_password.getBytes());		
		getAmazonPassword().sendKeys(new String(b));
		getLoginButton().click();
		
		return getInstance(AmazonLoginPage.class);

	}
	


	public AmazonLoginPage mlogin(Boolean bNeg) {

		if (bNeg) {
			//getAmazonTitle();
			//getAmazonLogo();
			
			doubleClickAmazonSignIn();

			getAmazonUserName().sendKeys();
			getContinueButton().click();		
			getAmazonPassword().sendKeys();
			getLoginButton().click();			
		}

		
		return getInstance(AmazonLoginPage.class);

	}

}
