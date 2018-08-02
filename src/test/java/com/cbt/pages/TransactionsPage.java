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
	
	@FindBy(xpath="(//div[@id='nav']/ul//li)[2]")
	public WebElement Trasactions;
	
	@FindBy(xpath="(//div[@class='box-header']//h2)[1]")
	public WebElement recentTransactions;
	
	
}

