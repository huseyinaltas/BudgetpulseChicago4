package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbt.utilities.Driver;

public class DashboardPage {

	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//li[@class='first']/a")
	public WebElement dashboard;

	@FindBy(id = "select_budget_type")
	public WebElement overview;
	
	public void selectSortBy(String option, WebElement select) {
		Select sortBy = new Select(select);
		sortBy.selectByVisibleText(option);
	}
	
	@FindBy(xpath = "//div[@class='capsule capsule-neutral'][1]")
	public WebElement actualIncome;
	
	@FindBy(xpath = "(//div[@class='capsule capsule-neutral']/span)[2]")
	public WebElement upcomingIncome;

	@FindBy(css="div.notify")
	public WebElement nameAlreadyExist;
	
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
	

	//akmal's part Spa-611
	
	
	@FindBy(xpath="(//div[@class='box-header']//h2)[1]")
	public WebElement recentTransactions;
	
	@FindBy(id="select_transaction_details_month")
	public WebElement transMonth;
	
	@FindBy(xpath="(//input[@id='TransFromDate'])[1]")
	public WebElement dateFrom;
	
	@FindBy(xpath="//input[@id='TransToDate']")
	public WebElement dateTo;
	
	@FindBy(xpath="//button[@class='submit-button']")
	public WebElement submitButton1771;
	
	@FindBy(xpath="//div[@class='ui-datepicker-prev']")
	public WebElement prePicker;
	
	@FindBy(xpath="//table[@class='ui-datepicker']//tr[3]//td[2]")
	public WebElement specificDate1;
	
	@FindBy(xpath="//table[@class='ui-datepicker']//tr[4]//td[4]")
	public WebElement specificDate2;

	@FindBy(xpath="(//form[@class='clear']/input)[1]")
	public WebElement actual1;
	@FindBy(xpath="(//form[@class='clear']/input)[2]")
	public WebElement actual2;
	
	@FindBy(xpath="//span[@id='description_16671452']")
	public WebElement hoverOver;
	
	@FindBy(css=".toggle-edit")
	public WebElement editClick;

	@FindBy(xpath="//span[@id='description_16671452']/form/input")
	public WebElement write;

	@FindBy(xpath="(//span[@id='description_16671452']/form/button)[1]")
	public WebElement save;
	
	@FindBy(xpath="//table/tbody//tr[7]//td[3]/span")
	public WebElement text;

	//my locator finishes here

	@FindBy(xpath = "//dt[@class='account-name']//a[@rel='253273']")
	public WebElement goToBofAChecking;
	
	@FindBy(xpath = "(//td[@colspan='6']/div/a)[1]")
	public WebElement addNewTransactionToBofA;
	
	@FindBy(id = "TransactionAccountId")
	public WebElement transactionSelectAccountBofA;
	
	@FindBy(id = "TransactionDescription")
	public WebElement transactionDescriptionBofA;
	
	
	@FindBy(id = "TransactionAmount")
	public WebElement transactionAmountBofA;
	
	@FindBy(id = "submitDone")
	public WebElement transactionSubmitDoneToBofA;
	
	@FindBy(xpath = "((//form[@id='TransactionDeleteForm']/table/tbody/tr)[1]//td)[1]")
	public WebElement transactionLastOnetoSelecetToBofA;
	
	@FindBy(id = "delete-transaction")
	public WebElement transactionDeleteSelectedToBofA;
	
	@FindBy(xpath = "//button[@class='ui-state-default ui-corner-all']")
	public WebElement transactionOkbuttonForDeleteToBofA;
	
	@FindBy(xpath = "(((//form[@id='TransactionDeleteForm']/table/tbody/tr)[1]//td)[1]/div/input)[2]")
	public WebElement transactionLastOnetoSelecetToBofA1;
	
	@FindBy(xpath = "(//a[@class='toggle-arrow recent'])[1]")
	public WebElement transactionToddleArrowBtn;
	

	@FindBy(xpath = "(//tr[@class='options-row expanded']//li)[3]")
	public WebElement transactionAddNote;
	@FindBy(xpath ="(//a[@class='delete'])[1]")
	public WebElement deleteTransactionOnDashboard;
	
}

