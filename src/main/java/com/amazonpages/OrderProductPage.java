package com.amazonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.BasePage;

public class OrderProductPage extends BasePage {

	private By HelloUser = By.xpath("//a[@id='nav-link-accountList']/div/span[contains(text(),'Hello, Akula')]");

	private By DeliverPincode = By.xpath("//div[@id='glow-ingress-block']/span[@id='glow-ingress-line2']");

	private By SearchProductType = By.id("searchDropdownBox");
	private By SearchProduct = By.id("twotabsearchtextbox");

	private By SearchButton = By.xpath("//span[@id='nav-search-submit-text']/input[@value='Go']");

	private By SearchResultsSort = By.id("a-autoid-0-announce");
	private By SortLowToHigh = By.id("s-result-sort-select_1");

	private By SearchResultsFilterTable = By.xpath("//div[@id='search']/div[1]/div[1]");
	private By SearchResultsTable = By.xpath("//div[@id='search']/div[1]/div[2]");
	private By SearchResult1 = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_2']");

	private By SearchResults1_Name = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_2']//a[@class='a-link-normal a-text-normal']");
	private By SearchResults1_Price1 = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_2']//div[@class='a-row a-size-base a-color-base']");
	private By SearchResults1_Price2 = By.xpath(
			"//div[@id='search']//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_2']//div[@class='a-section a-spacing-none a-spacing-top-mini']//div[@class='a-row']/div[2]");

	private By ProductName = By.id("productTitle");
	private By ProductSource = By.xpath("//*[@id='a-autoid-5-announce']");
	private By ProductSourceLink = By.xpath("//a[@id='a-autoid-5-announce']");

	private By acPrice = By.xpath("//*[@id='priceblock_ourprice']");
	private By acWithExchangePrice = By.xpath("//*[@id='buyBackAccordionRow']/div/div[1]/a");
	private By acWithoutExchangePrice = By.xpath("//*[@id='newAccordionRow']/div/div[1]/a");
	private By acAvailability = By.xpath("//*[@id='availability']/span");
	private By acDeliveryAddress = By.xpath("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
	private By BuyNowButton = By.xpath("//*[@id='checkout-button']");
	private By AddCartButton = By.xpath("//*[@id='add-to-cart-button']");

	private By cAddedtoCart = By.xpath("//*[@id='attachDisplayAddBaseAlert']/div/h4");
	private By cCartPrice = By.xpath("//*[@id='attach-accessory-cart-subtotal']");
	private By cCartButton = By.xpath("//*[@id='attach-sidesheet-view-cart-button']/span/input");
	private By cCartCloselink = By.xpath("//*[@id='attach-close_sideSheet-link']");

	private By Menulink = By.xpath("//*[@id='nav-hamburger-menu']/i");
	private By Signlink = By.xpath("//*[@id='hmenu-content']/ul[1]/li[29]/a");

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

	/*
	 * return getElemenet(ContinueButton); return getPageTitle();
	 * 
	 */

	public OrderProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the helloUser
	 */
	public String getHelloUser() {
		return getElemenetText(HelloUser);
	}

	/**
	 * @return the deliverPincoce
	 */
	public String getDeliverPincode() {
		return getElemenetText(DeliverPincode);
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
		return getElemenet(SearchProductType);
	}

	/**
	 * @param searchProductType the searchProductType to set
	 */
	public void setSearchProductType(String Testdata) {
		WebElement s = getElemenet(SearchProductType);
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
		return getElemenet(SearchProduct);
	}

	/**
	 * @param searchProduct the searchProduct to set
	 */
	public void setSearchProduct(String Testdata) {
		getElemenet(SearchProduct).sendKeys(Testdata);
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		return getElemenet(SearchButton);
	}

	/**
	 * @return the searchResultsSort
	 */
	public WebElement getSearchResultsSort() {
		return getElemenet(SearchResultsSort);
	}

	public WebElement getSortLowToHigh() {
		return getElemenet(SortLowToHigh);
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
	public void getSearchResult1() {
		waitForElementPresent(SearchResult1);
	}

	/**
	 * @return the searchResults1_Name
	 */

	public WebElement getSearchResults1_Name() {
		return getElemenet(SearchResults1_Name);
	}

	/**
	 * @return the searchResults1_Price1
	 */
	public String getSearchResults1_Price1() {
		return getElemenetText(SearchResults1_Price1);
	}

	/**
	 * @return the searchResults1_Price2
	 */
	public String getSearchResults1_Price2() {
		return getElemenetText(SearchResults1_Price2);
	}

	/**
	 * @return the productName
	 */
	public String getProductNameHeader() {
		return getElemenetText(ProductName);
	}

	/**
	 * @return the productSource
	 */
	public String getProductSource() {
		return getElemenetText(ProductSource);
	}

	/**
	 * @return the productSourceLink
	 */
	public WebElement getProductSourceLink() {
		return getElemenet(ProductSourceLink);
	}

	/**
	 * @return the buyNowButton
	 */
	public WebElement getBuyNowButton() {
		return getElemenet(BuyNowButton);
	}

	/**
	 * @return the acPrice
	 */
	public WebElement getacPrice() {
		return getElemenet(acPrice);
	}

	/**
	 * @return the acWithExchangePrice
	 */
	public WebElement getacWithExchangePrice() {
		return getElemenet(acWithExchangePrice);
	}

	/**
	 * @return the acWithoutExchangePrice
	 */
	public WebElement getacWithoutExchangePrice() {
		return getElemenet(acWithoutExchangePrice);
	}

	/**
	 * @return the acAvailability
	 */
	public WebElement getacAvailability() {
		return getElemenet(acAvailability);
	}

	/**
	 * @return the acDeliveryAddress
	 */
	public WebElement getacDeliveryAddress() {
		return getElemenet(acDeliveryAddress);
	}

	/**
	 * @return the AddCart
	 */
	public WebElement getAddCartButton() {
		return getElemenet(AddCartButton);
	}

	/**
	 * @return the cAddedtoCart
	 */
	public String getcAddedtoCart() {
		waitForElementPresent(cAddedtoCart);
		return getElemenetText(cAddedtoCart);
	}

	/**
	 * @return the cCartPrice
	 */
	public WebElement getcCartPrice() {
		return getElemenet(cCartPrice);
	}

	/**
	 * @return the cCartButton
	 */
	public WebElement getcCartButton() {
		return getElemenet(cCartButton);
	}

	/**
	 * @return the cCartCloseButton
	 */
	public WebElement getcCartCloselink() {
		return getElemenet(cCartCloselink);
	}

	/**
	 * @return the amazonPayLoo
	 */
	public By getAmazonPayLoo() {
		return AmazonPayLoo;
	}

	/**
	 * @param amazonPayLoo the amazonPayLoo to set
	 */
	public void setAmazonPayLoo(By amazonPayLoo) {
		AmazonPayLoo = amazonPayLoo;
	}

	/**
	 * @return the payByCard
	 */
	public By getPayByCard() {
		return PayByCard;
	}

	/**
	 * @param payByCard the payByCard to set
	 */
	public void setPayByCard(By payByCard) {
		PayByCard = payByCard;
	}

	/**
	 * @return the cardCvv
	 */
	public By getCardCvv() {
		return CardCvv;
	}

	/**
	 * @param cardCvv the cardCvv to set
	 */
	public void setCardCvv(By cardCvv) {
		CardCvv = cardCvv;
	}

	/**
	 * @return the payByUPI
	 */
	public By getPayByUPI() {
		return PayByUPI;
	}

	/**
	 * @param payByUPI the payByUPI to set
	 */
	public void setPayByUPI(By payByUPI) {
		PayByUPI = payByUPI;
	}

	/**
	 * @return the checkoutButton
	 */
	public By getCheckoutButton() {
		return CheckoutButton;
	}

	/**
	 * @param checkoutButton the checkoutButton to set
	 */
	public void setCheckoutButton(By checkoutButton) {
		CheckoutButton = checkoutButton;
	}

	/**
	 * @return the placeOrderButton
	 */
	public By getPlaceOrderButton() {
		return PlaceOrderButton;
	}

	/**
	 * @param placeOrderButton the placeOrderButton to set
	 */
	public void setPlaceOrderButton(By placeOrderButton) {
		PlaceOrderButton = placeOrderButton;
	}

	/**
	 * @return the deliveryToAddress
	 */
	public By getDeliveryToAddress() {
		return DeliveryToAddress;
	}

	/**
	 * @param deliveryToAddress the deliveryToAddress to set
	 */
	public void setDeliveryToAddress(By deliveryToAddress) {
		DeliveryToAddress = deliveryToAddress;
	}

	/**
	 * @return the deliveryToAddressButton
	 */
	public By getDeliveryToAddressButton() {
		return DeliveryToAddressButton;
	}

	/**
	 * @param deliveryToAddressButton the deliveryToAddressButton to set
	 */
	public void setDeliveryToAddressButton(By deliveryToAddressButton) {
		DeliveryToAddressButton = deliveryToAddressButton;
	}

	/**
	 * @return the placeOrderButton2
	 */
	public By getPlaceOrderButton2() {
		return PlaceOrderButton2;
	}

	/**
	 * @param placeOrderButton2 the placeOrderButton2 to set
	 */
	public void setPlaceOrderButton2(By placeOrderButton2) {
		PlaceOrderButton2 = placeOrderButton2;
	}

	/**
	 * @return the payByDelivery
	 */
	public By getPayByDelivery() {
		return PayByDelivery;
	}

	/**
	 * @param payByDelivery the payByDelivery to set
	 */
	public void setPayByDelivery(By payByDelivery) {
		PayByDelivery = payByDelivery;
	}

	/**
	 * @return the continueButton
	 */
	public By getContinueButton() {
		return ContinueButton;
	}

	/**
	 * @param continueButton the continueButton to set
	 */
	public void setContinueButton(By continueButton) {
		ContinueButton = continueButton;
	}

	/**
	 * @return the reviewYourOrderHeader
	 */
	public By getReviewYourOrderHeader() {
		return ReviewYourOrderHeader;
	}

	/**
	 * @param reviewYourOrderHeader the reviewYourOrderHeader to set
	 */
	public void setReviewYourOrderHeader(By reviewYourOrderHeader) {
		ReviewYourOrderHeader = reviewYourOrderHeader;
	}

	/**
	 * @return the reviewYourOrder
	 */
	public By getReviewYourOrder() {
		return ReviewYourOrder;
	}

	/**
	 * @param reviewYourOrder the reviewYourOrder to set
	 */
	public void setReviewYourOrder(By reviewYourOrder) {
		ReviewYourOrder = reviewYourOrder;
	}

	/**
	 * @return the orderSummary
	 */
	public By getOrderSummary() {
		return OrderSummary;
	}

	/**
	 * @param orderSummary the orderSummary to set
	 */
	public void setOrderSummary(By orderSummary) {
		OrderSummary = orderSummary;
	}

	/**
	 * @return the placeOrderButton3
	 */
	public By getPlaceOrderButton3() {
		return PlaceOrderButton3;
	}

	/**
	 * @param placeOrderButton3 the placeOrderButton3 to set
	 */
	public void setPlaceOrderButton3(By placeOrderButton3) {
		PlaceOrderButton3 = placeOrderButton3;
	}

	/**
	 * @return the Menu link
	 */
	public WebElement getMenulink() {
		return getElemenet(Menulink);
	}

	/**
	 * @return the Sign link
	 */
	public WebElement getSignlink() {
		return getElemenet(Signlink);
	}

	/**
	 * set the Sign link
	 */
	public void setSignlink() {
		moveToElementClick(Signlink);
	}

	/**
	 * login
	 */

	public OrderProductPage placetocart(String p_ProductType, String p_Product) {

		// getAmazonTitle();
		// getAmazonLogo();

		System.out.println(getHelloUser().toString());
		System.out.println(getDeliverPincode().toString());

		/*
		 * Search
		 */
		setSearchProductType(p_ProductType);
		setSearchProduct(p_Product);
		getSearchButton().click();

		/*
		 * Sort LowToHigh
		 */
		// getSearchResultsSort().click();
		// getSortLowToHigh().click();
		getSearchResultsFilterTable();
		getSearchResultsTable();

		/*
		 * Select first product in search
		 */
		getSearchResult1();
		System.out.println(getSearchResults1_Price1());
		getSearchResults1_Name().click();

		switchChildBrowser();
		/*
		 * Select first product in search
		 */
		System.out.println(getProductNameHeader());
		if (p_Product.contains("call")) {
			System.out.println(getProductSource());
			getProductSourceLink().click();
		}

		System.out.println(getacPrice());
		System.out.println(getacAvailability());
		System.out.println(getacWithExchangePrice());
		System.out.println(getacWithoutExchangePrice());
		System.out.println(getacDeliveryAddress());
		getAddCartButton().click();

		System.out.println(getcAddedtoCart());
		System.out.println(getcCartPrice());
		getcCartCloselink().click();

		getMenulink().click();
		setSignlink();

		return getInstance(OrderProductPage.class);

	}

}
