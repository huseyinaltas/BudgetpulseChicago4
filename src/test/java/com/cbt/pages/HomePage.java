package com.cbt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(css = "div#logbutton")
	public WebElement loginBtn;

	@FindBy(id = "login_username")
	public WebElement email;

	@FindBy(id = "login_password")
	public WebElement password;

	@FindBy(css = "a#login-link")
	public WebElement loginClick;

	public static void homePage() {
		HomePage homePage = new HomePage();
		BrowserUtils.waitForVisibility(homePage.loginBtn, 5);
		homePage.loginBtn.click();
		BrowserUtils.waitForVisibility(homePage.email, 5);
		homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		BrowserUtils.waitForVisibility(homePage.loginClick, 5);
		homePage.loginClick.click();

	}
}