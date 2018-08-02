package com.cbt.tests.dashboard;

import static org.testng.Assert.assertTrue;


import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.pages.TransactionsPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class Dashboard extends TestBase {

  
	// Nargiza test1
	@Ignore
	@Test(groups = { "smoke" }, priority = 1)
	public void budgetFunctionality() {
		extentLogger = report.createTest("Positive login test");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		assertTrue(dashboardPage.budgeted.isDisplayed());
		assertTrue(dashboardPage.actualExpense.isDisplayed());
		BrowserUtils.waitForVisibility(dashboardPage.upcomingExpense, 5);
		assertTrue(dashboardPage.upcomingExpense.isDisplayed());

	}

	// Huseyin test1
	@Ignore
	@Test(groups = { "smoke" }, priority = 2)
	public void title() {
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	
	//Aizada's  smoke test case
	@Ignore
			@Test(groups= {"smoke"}, priority = 4)
			public void cashFlow() {
				HomePage.homePage();
				DashboardPage dashboardPage =  new DashboardPage();
				dashboardPage.dashboard.click();
				BrowserUtils.waitForVisibility(dashboardPage.logo,5);
				String actualTitle = driver.getTitle();
				String expectedTitle = "Dashboard | BudgetPulse";
				Assert.assertEquals(actualTitle, expectedTitle);
				dashboardPage.cashFlow.click();
				String actualResult = dashboardPage.defaultValue.getText();
				Assert.assertEquals(actualResult, "Today");
				Assert.assertTrue(dashboardPage.totalIncome.isDisplayed());
			    Assert.assertTrue(dashboardPage.totalExpense.isDisplayed());
			    Assert.assertTrue(dashboardPage.accountBalance.isDisplayed());


		}
@Ignore
	// this is smoke test for Add Account functionality (Adilet)
	@Test(groups = { "smoke" }, priority = 3)
	public void addAccount() {
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(dashboardPage.addAccountBtn.isEnabled(), "Add Account button is not working");
		dashboardPage.addAccountBtn.click();
		Assert.assertTrue(dashboardPage.accountTypeText.isDisplayed(), "Account type text is not visible");

	}

	// this test checks for Add Account functionality (Adilet)
	@Ignore
	@Test(groups = { "tests" })
	public void addAccountTest() {
		HomePage.homePage();
		DashboardPage pom = new DashboardPage();
		Random rd = new Random();
		int accNameGenerator = rd.nextInt(1000);
		pom.dashboard.click();
		pom.addAccountBtn.click();
		BrowserUtils.waitForVisibility(pom.selectAccType, 10);
		Select select = new Select(pom.selectAccType);
		select.selectByVisibleText("Savings Accounts");
		pom.accountName.sendKeys("BofA" + accNameGenerator);
		String openBalance = ConfigurationReader.getProperty("openBalanceAmount");
		pom.openBalance.sendKeys(openBalance);

		// Asserting Net Worth with added Open balance
		String netAmount = pom.openBalanceNet.getText().replace("$", "").replace(",", "");
		double amountNet = Double.parseDouble(netAmount);
		double openingAmount = Double.parseDouble(openBalance);
		double sum = amountNet + openingAmount;

		pom.newAccSubmitBtn.click();
		BrowserUtils.waitFor(3);
		double finalNet = Double.parseDouble(pom.openBalanceNet.getText().replace("$", "").replace(",", ""));

		Assert.assertEquals(sum, finalNet, "Net Worth is not correct");

	}

	//Akmal's test SPA 611
	
	
		TransactionsPage tp=new TransactionsPage();
		DashboardPage dashboardPage = new DashboardPage();
		
			
		@Test	
			public void checkTrasactionDate() throws Exception {
				HomePage.homePage();
				dashboardPage.dashboard.click();
				JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
				jse.executeScript("window.scrollBy(0,350)", "");
				//Thread.sleep(5000);
			//	tp.recentTransactions.click();
				
//				Select dropDown=new Select(dashboardPage.transMonth);
//				dropDown.selectByVisibleText("Custom");
				Thread.sleep(5000);
				dashboardPage.dateFrom.click();;
				//dashboardPage.dateFrom.sendKeys("07/16/2018");
				//Thread.sleep(5000);
				//dashboardPage.dateTo.clear();
				//dashboardPage.dateTo.sendKeys("07/25/2018");
				
				dashboardPage.submitButton1771.click();
				
				
				
			}
			
	
	

	
}
	


