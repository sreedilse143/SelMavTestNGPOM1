package com.amazon;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonpages.AddToCartPage;
import com.amazonpages.AmazonLoginPage;
import com.amazonpages.AmazonLogout;
import com.amazonpages.ProductSearchPage;
import com.amazonpages.ProductInfoPage;
import com.wrapers.BaseTest;

public class AmazonTest1 extends BaseTest {

	@Test(priority = 1, enabled = false)
	public void VerifyAmazonTitle() {
		String pt = page.getInstance(AmazonLoginPage.class).getPageTitle();
		AssertJUnit.assertEquals(pt,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 2)
	@Parameters(value = { "TD_Username", "TD_password", "TD_ProdType", "TD_ProdName" })
	public void ProductAddtoCart(String TD_Username, String TD_password, String TD_ProdType, String TD_ProdName) {
		page.getInstance(AmazonLoginPage.class).mlogin(TD_Username, TD_password);
		page.getInstance(ProductSearchPage.class).mProductSearch(TD_ProdType, TD_ProdName);
		page.getInstance(ProductInfoPage.class).mProductInfo(TD_ProdType, TD_ProdName);
		page.getInstance(AddToCartPage.class).mAddTOCart(TD_ProdType, TD_ProdName);
		page.getInstance(AmazonLogout.class).mAmazonLogout();

	}

}
