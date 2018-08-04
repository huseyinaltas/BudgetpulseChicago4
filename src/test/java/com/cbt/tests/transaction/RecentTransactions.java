package com.cbt.tests.transaction;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;

public class RecentTransactions extends TestBase{

	DashboardPage dashboardPage =  new DashboardPage();

	//SPA 707 - Mammadova
		@Test
		public void negativeTransferFund() throws InterruptedException{
			HomePage.homePage();
			// this is for click dashboard in homepage
			dashboardPage.dashboard.click();
			
			dashboardPage.addNew.click();
			dashboardPage.selectTransaction("Income");
			dashboardPage.transactionCategoryName.sendKeys("Net Salary");
			dashboardPage.transactionDescription.sendKeys("Tom's first two week salary");
			dashboardPage.transactionAmount.sendKeys("2500");
			dashboardPage.selectTransactionAccount("BofA");
			dashboardPage.submitDone.click();
			
			assertEquals(dashboardPage.transactionDescriptionInTable.getText(),"Tom's first two week salary");
			
		}
}
