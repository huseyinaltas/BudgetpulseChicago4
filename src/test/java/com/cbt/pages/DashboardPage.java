package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class DashboardPage {

	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}


	@FindBy(xpath = "//li[@class='first']/a")
	public WebElement dashboard;

	@FindBy(id = "select_budget_type")
	public WebElement overview;

	@FindBy(xpath = "//div[@class='capsule capsule-neutral capsule-first']")
	public WebElement budgeted;

	@FindBy(xpath = "//div[@class='capsule capsule-neutral'][1]")
	public WebElement actualExpense;

	@FindBy(xpath = "(//div[@class='capsule capsule-neutral']/span)[2]")
	public WebElement upcomingExpense;

	@FindBy(id = "logo")
	public WebElement logo;

	
	
	 //Add Account button 
	@FindBy(id="btn_add_account")
	public WebElement addAccountBtn;
	
	
	 //Account Type text  
	@FindBy(xpath="//label[@for='AccountAccountTypeId']")
	public WebElement accountTypeText;
	
	//Account Type Select 
	@FindBy(id="AccountAccountTypeId")
	public WebElement selectAccType;
	
	//New Account name
	@FindBy(id="AccountName")
	public WebElement accountName;
	
	//Account opening balance
	@FindBy(id="AccountStartingBalance")
	public WebElement  openBalance;
	
	//Add Account submit button
	@FindBy(xpath="(//button[@class='submit'])[1]")
	public WebElement newAccSubmitBtn;
	
	//Net Worth Amount
	@FindBy(xpath="//strong[@class='in net_worth']")
	public WebElement openBalanceNet;



	@FindBy(xpath = "//*[contains(text(),'Cash Flow')]")
	public WebElement cashFlow;

	@FindBy(xpath = "//option[@value='today']")
	public WebElement defaultValue;

	@FindBy(xpath = "//div[@id='panel_all']//div[@class='capsule capsule-neutral capsule-first']/span")
	public WebElement totalIncome;

	@FindBy(xpath = "(//div[@class='capsule capsule-neutral'])[3]")
	public WebElement totalExpense;

	@FindBy(xpath = "(//div[@class='capsule capsule-neutral'])[4]")
	public WebElement accountBalance;

}


