package com.cbt.pages;

import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class BudgetPage {
	
	public BudgetPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
