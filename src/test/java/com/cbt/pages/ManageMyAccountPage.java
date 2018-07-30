package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cbt.utilities.Driver;

public class ManageMyAccountPage {
	
	public ManageMyAccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//this is for manage account link
	@FindBy(id="link_manage_accounts")
	public WebElement manageAccLink;
	
	@FindBy(xpath="(//div[@class='box-header'])[8]//a")
	public WebElement transactionFund;
	
	@FindBy(id="TransactionFromAccountId")
	public WebElement amountFrom;
	
	@FindBy(id="TransactionToAccountId")
	public WebElement amountTo;
	
	@FindBy(xpath="//input[@id='TransferTransactionDescription']")
	public WebElement description;
	
	@FindBy(xpath="//input[@id='TransferTransactionAmount']")
	public WebElement amount;
	
	@FindBy(xpath="(//button[@class='submit'])[3]")
	public WebElement submitButton;
	
//	public Select amountFrom() {
//		return new Select(Driver.getDriver().findElement(By.id("TransactionFromAccountId")));
//	}
//	public Select amountTo() {
//		return new Select(Driver.getDriver().findElement(By.id("TransactionToAccountId")));
//	}
	
	
	
	
	
}