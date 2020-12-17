package com.amazonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.BasePage;

public class BuyNow extends BasePage {



	private By AmazonPayLoo = By.xpath("//*[@id='paymentOptionsSection']//img['Amazon pay logo']");

	private By PayByCard = By.xpath("//*[@id='card-radiobutton-smart-0']");
	private By CardCvv = By.xpath("//*[@id='cvv_smart-0']");
	private By PayByUPI = By.xpath("//*[@id='upi-saved-handle-radio-button']");

	private By CheckoutButton = By.xpath("//*[@id='checkout-button']");
	private By PlaceOrderButton = By.xpath("//*[@id='place-order-button']");

	private By DeliveryToAddress = By.xpath("//*[@id='addres-select']/h1");
	private By DeliveryToAddressButton = By.xpath("//*[@id='address-book-entry-0']/div[2]/span/a");
	private By PlaceOrderButton2 = By.xpath("//*[@id='place-order-button']");

	private By PayByDelivery = By.xpath("//*[@id='pp-mhvqEt-221']");
	private By ContinueButton = By.xpath("//*[@id='pp-mhvqEt-224']/span/input[1]");

	private By ReviewYourOrderHeader = By.xpath("//*[@id='header']/div[2]/div/div[1]");
	private By ReviewYourOrder = By.xpath("//*[@id='spc-top']");

	private By OrderSummary = By.xpath("//*[@id='spc-order-summary']");
	private By PlaceOrderButton3 = By.xpath("//*[@id='placeYourOrder']/span/input]");

	private By BuyNowButton = By.xpath("//*[@id='checkout-button']");

	
	/*
	 * return getElement(ContinueButton); return getPageTitle();
	 * 
	 */

	public BuyNow(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the buyNowButton
	 */
	public WebElement getBuyNowButton() {
		return getElement(BuyNowButton);
	}




	/**
	 * login
	 */

	public BuyNow mBuyNow(String p_ProductType, String p_Product) {

		// getAmazonTitle();
		// getAmazonLogo();

		System.out.println(getBuyNowButton().toString());

		/*
		 * Search
		 */


		getBuyNowButton().click();

	


		return getInstance(BuyNow.class);

	}

}
