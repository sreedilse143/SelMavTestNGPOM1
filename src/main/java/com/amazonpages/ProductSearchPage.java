package com.amazonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.BasePage;

public class ProductSearchPage extends BasePage {

	private By HelloUser = By.xpath("//a[@id='nav-link-accountList']/div/span[contains(text(),'Hello, Akula')]");

	private By DeliverPincode = By.xpath("//div[@id='glow-ingress-block']/span[@id='glow-ingress-line2']");

	private By SearchProductType = By.id("searchDropdownBox");
	private By SearchProduct = By.id("twotabsearchtextbox");

	private By SearchButton = By.xpath("//span[@id='nav-search-submit-text']/input[@value='Go']");

	private By SearchResultsSort = By.id("a-autoid-0-announce");
	private By SortLowToHigh = By.id("s-result-sort-select_1");

	private By SearchResultsFilterTable = By.xpath("//div[@id='search']/div[1]/div[1]");
	private By SearchResultsTable = By.xpath("//div[@id='search']/div[1]/div[2]/div/span[3]/div[2]");

	private By SearchResults1_Name = By
			.xpath("//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']//h2/a");
	private By SearchResults1_Price1 = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@class='a-row']");
	private By SearchResults1_Price2 = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_2']//div[@class='a-section a-spacing-none a-spacing-top-mini']//div[@class='a-row']/div[2]");

	public ProductSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the helloUser
	 */
	public String getHelloUser() {
		waitForElementPresent(HelloUser);
		return getElementText(HelloUser);
	}

	/**
	 * @return the deliverPincoce
	 */
	public String getDeliverPincode() {
		return getElementText(DeliverPincode);
	}

	/**
	 * @param deliverPincoce the deliverPincoce to set
	 */
	public void setDeliverPincoce() {
		doubleClickElement(DeliverPincode);
	}

	/**
	 * @return the searchProductType
	 */
	public WebElement getSearchProductType() {
		return getElement(SearchProductType);
	}

	/**
	 * @param searchProductType the searchProductType to set
	 */
	public void setSearchProductType(String Testdata) {
		WebElement s = getElement(SearchProductType);
		/*
		 * List<WebElement> op = new Select(s).getOptions(); int size = op.size(); for
		 * (int i = 0; i < size; i++) { String options = op.get(i).getText();
		 * System.out.println(options); }
		 */
		new Select(s).selectByVisibleText(Testdata);
	}

	/**
	 * @return the searchProduct
	 */
	public WebElement getSearchProduct() {
		return getElement(SearchProduct);
	}

	/**
	 * @param searchProduct the searchProduct to set
	 */
	public void setSearchProduct(String Testdata) {
		getElement(SearchProduct).sendKeys(Testdata);
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		return getElement(SearchButton);
	}

	/**
	 * @return the searchResultsSort
	 */
	public WebElement getSearchResultsSort() {
		return getElement(SearchResultsSort);
	}

	public WebElement getSortLowToHigh() {
		return getElement(SortLowToHigh);
	}

	/**
	 * @return the searchResultsFilterTable
	 */
	public void getSearchResultsFilterTable() {
		waitForElementPresent(SearchResultsFilterTable);
	}

	/**
	 * @return the searchResultsTable
	 */
	public void getSearchResultsTable() {
		waitForElementPresent(SearchResultsTable);
	}

	/**
	 * @return the searchResults1
	 */

	public String getSearchResults1_Name1() {
		waitForElementPresent(SearchResults1_Name);
		return getElementText(SearchResults1_Name);
	}

	/**
	 * @return the searchResults1_Price1
	 */
	public String getSearchResults1_Price1() {
		return getElementText(SearchResults1_Price1);
	}

	/**
	 * @return the searchResults1_Price2
	 */
	public String getSearchResults1_Price2() {
		return getElementText(SearchResults1_Price2);
	}

	public ProductSearchPage mProductSearch(String p_ProductType, String p_Product) {

		// getAmazonTitle();
		// getAmazonLogo();
		System.out.println("---------------mProductSearch");

		System.out.println(getHelloUser().toString());
		System.out.println(getDeliverPincode().toString());

		/*
		 * Search
		 */
		//setSearchProductType(p_ProductType);
		setSearchProduct(p_Product);
		getSearchButton().click();

		switch (p_ProductType) {
		case "Amazon Fresh":
			/*
			 * Sort LowToHigh
			 */

			break;

		default:
			getSearchResultsSort().click();
			getSortLowToHigh().click();

			break;
		}

		/*
		 * Results
		 */
		getSearchResultsFilterTable();
		getSearchResultsTable();

		/*
		 * first product
		 */
		System.out.println(getSearchResults1_Name1().toString());
		System.out.println(getSearchResults1_Price1().toString());
		System.out.println("---------------mProductSearch");

		return getInstance(ProductSearchPage.class);

	}
}
