package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	@FindBy(name = "txtUsername")
	WebElement userName;

	@FindBy(name = "txtPassword")
	WebElement Password;

	@FindBy(name = "Submit")
	WebElement Submit;

	@FindBy(xpath = "//img[@src='/webres_5faa8393a82311.28834036/themes/default/images/login/logo.png']")
	WebElement logo;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

//actions
	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean validateOrmLogo() {
		return logo.isDisplayed();
	}

	public HomePage validateLogin(String un, String pwd) {
		userName.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();

		return new HomePage();
	}

}
