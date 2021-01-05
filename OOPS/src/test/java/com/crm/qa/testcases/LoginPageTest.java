package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	HomePage hp = new HomePage();
	LoginPage lp;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException  {
		initialisebrowser();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void pageTitleTest() {

		Assert.assertEquals(lp.validatePageTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	public void logoTest() {

		Assert.assertTrue(lp.validateOrmLogo());
	}

	@Test(priority = 3)
	public void loginTest() {
		lp.validateLogin(prop.getProperty("username"), "pwd");
	}

	@AfterMethod
	public void finish() {
		driver.quit();

	}

}
