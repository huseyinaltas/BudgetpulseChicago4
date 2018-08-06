package com.cbt.tests.transaction;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;

public class RecentTransactions extends TestBase{


	//SPA 707 - Mammadova
		@Test(priority = 19, groups= {"regression"})
		public void negativeTransferFund2() throws InterruptedException{
			extentLogger = report.createTest("TransferFund-Negative");
			DashboardPage dashboardPage =  new DashboardPage();
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
			extentLogger.pass("Verified log out link displayed");

		}
}
