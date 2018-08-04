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
	
	@FindBy(xpath = "(//a[.='Budget'])[1]")
	public WebElement budget;
	
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
	
}
