package com.amazonpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;

public class AddToCartPage extends BasePage {

	private String strTemp;

	
	private By AddToCartButton1 = By.xpath("//*[@id='add-to-cart-button']");
	private By AddToCartButton2 = By.xpath("//span[@id='freshAddToCartButton']");
	private By AddToCartButton3 = By.xpath("//a[@id='hlb-view-cart-announce']");

	private By fcCart = By.id("ewc-content");

	private By cAddedtoCart1 = By.xpath("//*[@id='attachDisplayAddBaseAlert']/div/h4");
	private By cAddedtoCart = By.xpath("//h1[contains(text(),'Added to Cart')]");

	private By cCartPrice1 = By.xpath("//*[@id='attach-accessory-cart-subtotal']");
	private By cCartPrice = By.xpath("//*[@id='hlb-subcart']");
	private By cCartButton1 = By.xpath("//*[@id='attach-sidesheet-view-cart-button']/span/input");
	private By cCartCloselink = By.xpath("//*[@id='attach-close_sideSheet-link']");

	private By cartFreshItems = By.xpath(
			"//ul[@id='ewc-tab']/li[@data-tab-heading-name='fresh']/following-sibling::li/div[@class='ewc-tab-quantity ewc-spacing-small']");

	private By fcCartProductName1 = By.xpath("//a[@title='Fresh Lemon, 250 g']/ancestor::div[@class='ewc-items']");
	private By fcCartProductName = By.xpath("//a[@title='" + strTemp + "']/ancestor::div[@class='ewc-items']");
	private By fcCartName = By.xpath(
			"//div[@id='ewc-active-local-market-cart-nowstore']//div[@class='ewc-items']//div[@class='ewc-item-content']/div[@class='ewc-item-info']//a[@title='Fresh Lemon, 250 g']/parent::li");
	private By fcCartPrice = By.xpath(
			"//div[@id='ewc-active-local-market-cart-nowstore']//div[@class='ewc-items']//div[@class='ewc-item-content']/div[@class='ewc-item-info'//a[@title='Fresh Lemon, 250 g']/parent::li//following-sibling::li");
	private By fcCartQuantity = By.xpath(
			"//div[@id='ewc-active-local-market-cart-nowstore']//div[@class='ewc-items']//div[@class='ewc-item-content']//a[@title='Fresh Lemon, 250 g']/ancestor::div[@class='ewc-item-info']/following-sibling::div/div[@class='ewc-item-action-col ewc-item-quantity-col']");
	private By fcCartdDelete = By.xpath(
			"//div[@id='ewc-active-local-market-cart-nowstore']//div[@class='ewc-items']//div[@class='ewc-item-content']//a[@title='Fresh Lemon, 250 g']/ancestor::div[@class='ewc-item-info']/following-sibling::div/div[@class='ewc-item-action-col ewc-item-button-col']//a[contains(text(),'Delete')]");

	private By ContinueShoppingAmazonFresh = By.xpath("//a[contains(text(),'Continue shopping on Amazon Fresh')]");

	/*
	 * return getElement(ContinueButton); return getPageTitle();
	 * 
	 */

	public AddToCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the AddCart
	 */

	public WebElement getAddCartButton() {

		By by1 = AddToCartButton1;
		By by2 = AddToCartButton2;
		By by3 = AddToCartButton3;

		List<By> we = new ArrayList<By>();
		we.add(by1);
		we.add(by2);
		we.add(by3);
		return getAvilableElement(we);

	}

	/**
	 * @return the cAddedtoCart
	 */
	public String getcAddedtoCart() {
		waitForElementPresent(cAddedtoCart);
		return getElementText(cAddedtoCart);
	}

	/**
	 * @return the cAddedtoCart
	 */
	public String getcItem(By Locator, String TestData) {
		fcCartProductName1 = By.xpath("//a[@title='Fresh Lemon, 250 g']/ancestor::div[@class='ewc-items']");
		
		fcCartProductName1.toString().replace(strTemp, TestData);
		
		return getElementText(cAddedtoCart);
	}
	
	/**
	 * @return the cCartPrice
	 */
	public String getcCartPrice() {
		return getElementText(cCartPrice);
	}

	/**
	 * @return the cCartCloseButton
	 */
	public WebElement getcCartCloselink() {
		return getElement(cCartCloselink);
	}

	/**
	 * @return the searchResultsTable
	 */

	/**
	 * login
	 */

	public AddToCartPage mAddTOCart(String p_ProductType, String p_Product) {

		/*
		 * Add to cart
		 */
		getAddCartButton().click();

		//System.out.println(getcAddedtoCart());
		//System.out.println(getcCartPrice());

		return getInstance(AddToCartPage.class);

	}

}
