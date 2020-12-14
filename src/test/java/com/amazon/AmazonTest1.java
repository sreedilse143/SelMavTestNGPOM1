package com.amazon;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonpages.AmazonLoginPage;
import com.wrapers.BaseTest;

public class AmazonTest1 extends BaseTest {

	@Test(priority = 1)
	@Parameters(value = {"TD_Username", "TD_password" })	
	public void VerifyAmazonLoginPageTitle() {
		String pt = page.getInstance(AmazonLoginPage.class).getPageTitle();
		AssertJUnit.assertEquals(pt, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 2)
	@Parameters(value = {"TD_Username", "TD_password" })	
	public void AmazonLoginTest(String TD_Username, String TD_password) {
		page.getInstance(AmazonLoginPage.class).login(TD_Username, TD_password);
	}

}
