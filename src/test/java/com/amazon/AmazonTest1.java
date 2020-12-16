package com.amazon;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonpages.AmazonLoginPage;
import com.amazonpages.OrderProductPage;
import com.wrapers.BaseTest;

public class AmazonTest1 extends BaseTest {

	@Test(priority = 1)
	public void VerifyAmazonLoginPageTitle() {
		String pt = page.getInstance(AmazonLoginPage.class).getPageTitle();
		AssertJUnit.assertEquals(pt,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 2, enabled = false)
	@Parameters(value = { "TD_Username", "TD_password" })
	public void AmazonLoginTest(String TD_Username, String TD_password) {
		page.getInstance(AmazonLoginPage.class).login(TD_Username, TD_password);
	}

	@Test(priority = 3, enabled = false)
	@Parameters(value = { "TD_Username", "TD_password", "TD_ProdType", "TD_ProdName" })
	public void ProductAddtoCart(String TD_Username, String TD_password, String TD_ProdType, String TD_ProdName) {
		page.getInstance(AmazonLoginPage.class).login(TD_Username, TD_password);
		page.getInstance(OrderProductPage.class).placetocart(TD_ProdType, TD_ProdName);

	}

}
