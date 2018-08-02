package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class TransactionsPage {
	
	public TransactionsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//a[@href='/transactions']")
	public WebElement transactionPage;
	
	@FindBy(xpath = "(//a[@class='box-header-action box-toggler button-expand'])[2]")
	public WebElement clickCategories;
	
	@FindBy(id = "add_category")
	public WebElement addCategory;
	
	@FindBy(xpath = "(//input[@id='TransactionCategoryName'])[2]")
	public WebElement writeCategory;
	
	@FindBy(xpath = "//span[@id='add_category_form']//form//button")
	public WebElement submitCategory;
	
	@FindBy(xpath = "//div[@class='notify']")
	public WebElement textExistingCategory;
	
	@FindBy(xpath = "//td/a/span[@class='icon']")
	public List<WebElement> deleteExistingLastCategory;
	
	@FindBy(xpath = "//button[@class='ui-state-default ui-corner-all']")
	public WebElement okDeleteExistingLastCategory;
	
	
	
	
	
	
}

