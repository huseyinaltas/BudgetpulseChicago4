package com.cbt.tests.transaction;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.cbt.pages.BudgetPage;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;

public class AddBudgetItem extends TestBase{

	DashboardPage dashboardPage =  new DashboardPage();
	BudgetPage budgetPage = new BudgetPage();

	//SPA 831 - Mammadova
	
		@Test
		public void negativeTransferFund() throws InterruptedException{
			HomePage.homePage();
			// this is for click dashboard in homepage
			dashboardPage.dashboard.click();
			
			budgetPage.budget.click();
			budgetPage.collapseIcon.click();
			budgetPage.selectTransactionCategoryType("Income");
			budgetPage.transactionCategoryName.sendKeys("Net Salary");
			budgetPage.transactionCategoryMonthlyBudget.sendKeys("5000");
			budgetPage.budgetSubmit.click();
			
			assertEquals(budgetPage.budgetErrorMessage.getText(), "Category already exists");
		}
		
		
			
}
