package com.amazonpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;

public class ProductInfoPage extends BasePage {

	private By Pagination = By.xpath("//div[@id='search']//ul[@class='a-pagination']/li");

	private By FindProduct = By.xpath("//h2[contains(@class,'a-size-mini a-spacing-none a-color-base s-line-clamp')]");

	private By ProductName = By.id("productTitle");
	private By ProductSource = By.xpath("//a[@id='a-autoid-6-announce']");
	private By ProductSourceLink = By.xpath("//a[@id='a-autoid-6-announce']");

	private By pPrice1 = By.xpath("//*[@id='priceblock_ourprice']");
	private By pPrice2 = By.xpath("//div[@id='newAccordionRow]/div/div[1]/a/h5/div[2]/div/span[1]");
	private By pPrice3 = By.xpath("//div[@id='soldByThirdParty']");

	private By acAvailability1 = By.xpath("//*[@id='availability-string']");
	private By acAvailability = By.xpath("//div[contains(@id,'availability')]/span");

	private By acWithExchangePrice = By.xpath("//*[@id='buyBackAccordionRow']/div/div[1]/a");
	private By acWithoutExchangePrice = By.xpath("//*[@id='newAccordionRow']/div/div[1]/a");
	private By acDeliveryAddress = By.xpath("//*[@id='contextualIngressPtLabel_deliveryShortLine']");

	/*
	 * return getElement(ContinueButton); return getPageTitle();
	 * 
	 */

	public ProductInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the searchResults in Page 1
	 */

	public WebElement getSearchPage(String Text) {
		return getElement(FindProduct, Text);
	}

	/**
	 * @return the searchResults in Pagination
	 */

	public WebElement getSearchPagination(String strText) {
		
		return getSearchPagination(Pagination, FindProduct, strText);
	}

	/**
	 * @return the productName
	 */
	public String getProductNameHeader() {
		return getElementText(ProductName);
	}

	/**
	 * @return the productSource
	 */
	public String getProductSource() {
		return getElementText(ProductSource);
	}

	
	/**
	 * @return the productSourceLink
	 */
	public WebElement getProductSourceLink() {
		return getElement(ProductSourceLink);
	}

	/**
	 * @return the acPrice
	 */
	public String getpPrice() {

		By by1 = pPrice1;
		By by2 = pPrice2;
		By by3 = pPrice3;
		List<By> we = new ArrayList<By>();
		we.add(by1);
		we.add(by2);
		we.add(by3);
		return getAvilableElement(we).getText();

	}

	/**
	 * @return the acWithExchangePrice
	 */

	public String getacWithExchangePrice() {
		return getElementText(acWithExchangePrice);
	}

	/**
	 * @return the acWithoutExchangePrice
	 */
	public String getacWithoutExchangePrice() {
		return getElementText(acWithoutExchangePrice);
	}

	/**
	 * @return the acAvailability
	 */
	public String getacAvailability() {
		return getElementText(acAvailability);
	}

	/**
	 * @return the acDeliveryAddress
	 */
	public String getacDeliveryAddress() {
		return getElementText(acDeliveryAddress);
	}

	/**
	 * login
	 */

	public ProductInfoPage mProductInfo(String p_ProductType, String p_Product) {

		System.out.println("---------------mProductInfo");

		/*
		 * Select searched product
		 */
		// getSearchPage(p_Product).click();
		getSearchPagination(p_Product).click();

		/*
		 * product verifications
		 */
		switchChildBrowser();
		/*
		 * Select first product in search
		 */

		System.out.println(getProductNameHeader());

		if (p_ProductType.contains("Books")) {
			System.out.println(getProductSource());
		}

		System.out.println(getpPrice());
		System.out.println(getacAvailability());

		switch (p_ProductType) {
		case "Electronics":
			System.out.println(getacWithExchangePrice());
			System.out.println(getacWithoutExchangePrice());

			System.out.println(getacDeliveryAddress());

			break;

		default:

			break;
		}

		System.out.println("---------------mProductInfo");

		return getInstance(ProductInfoPage.class);

	}

}
