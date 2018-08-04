package com.cbt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import com.cbt.utilities.Driver;

public class BudgetPage{

	public BudgetPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="add_budget_item_header")
	public WebElement collapseIcon;
	
	@FindBy(name="data[TransactionCategory][budget_type]")
	public WebElement transactionCategoryType;
	
	@FindBy(id="TransactionCategoryName")
	public WebElement transactionCategoryName;
	
	@FindBy(id="TransactionCategoryMonthlyBudget")
	public WebElement transactionCategoryMonthlyBudget;
	
	@FindBy(xpath="(//button[@class='submit'])[1]")
	public WebElement budgetSubmit;
	
	@FindBy(xpath="//div[@class='notify']")
	public WebElement budgetErrorMessage;
	
	
	public void selectTransactionCategoryType(String byText) {
		Select select = new Select(transactionCategoryType);
		select.selectByVisibleText(byText);
	}




	@FindBy(xpath = "(//div[@id='nav']/ul//li)[3]")
	public WebElement budget;
	
	@FindBy(xpath= "//*[contains(text(),'Expenses')]")
	public WebElement expenses;
	
	@FindBy(xpath = "//div[@id=\"add_budget_item_header\"]/a")
	public WebElement greenBtn;
	
	@FindBy(id = "TransactionCategoryName")
	public WebElement category;
	
	@FindBy(id = "TransactionCategoryMonthlyBudget")
	public WebElement budgetAmount;
	
	@FindBy(xpath = "//form[@id='budget_form_add_transaction_category']/ul[2]//button")
	public WebElement submitBtn;
	
	@FindBy(xpath = "(//input[@id='Budget0Amount'])[1]")
	public WebElement adjustment;
	
	@FindBy(xpath = "//span[@class='summary']/strong")
	public WebElement totalBudget;
	
	@FindBy(xpath = "//li[@class='first']/a")
	public WebElement dashboard;
	
	@FindBy(xpath = "//*[contains(text(),'$800.00')]")
	public WebElement VerifyBudgeted;

	
}
