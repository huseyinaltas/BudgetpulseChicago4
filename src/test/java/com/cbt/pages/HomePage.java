package com.cbt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "//a[.='Login']")
	public WebElement loginBtn;

	@FindBy(id = "login_username")
	public WebElement email;

	@FindBy(id = "login_password")
	public WebElement password;

	@FindBy(xpath = "//a[.='Login']")
	public WebElement loginClick;

}