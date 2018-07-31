package com.cbt.tests.dashboard;

import static org.testng.Assert.assertTrue;


import java.util.Random;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;

public class Dashboard extends TestBase {


	// Nargiza test1
	@Test(groups = { "smoke" }, priority = 1)
	public void budgetFunctionality() {
		homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		assertTrue(dashboardPage.budgeted.isDisplayed());
		assertTrue(dashboardPage.actualExpense.isDisplayed());
		BrowserUtils.waitForVisibility(dashboardPage.upcomingExpense, 5);
		assertTrue(dashboardPage.upcomingExpense.isDisplayed());

	}

	// Huseyin test1
	@Test(groups = { "smoke" }, priority = 2)
	public void title() {
		homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	
	//Aizada's  smoke test case
			@Test(groups= {"smoke"}, priority = 4)
			public void cashFlow() {
				homePage();
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

	// this is smoke test for Add Account functionality (Adilet)
	@Test(groups = { "smoke" }, priority = 3)
	public void addAccount() {
		homePage();
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
	@Test(groups = { "tests" })
	public void addAccountTest() {
		homePage();
		DashboardPage pom = new DashboardPage();
		Random rd = new Random();
		int accNameGenerator = rd.nextInt(1000);
		homePage();
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

	
		public void homePage() {
			HomePage homePage = new HomePage();
			BrowserUtils.waitForVisibility(homePage.loginBtn, 5);
			homePage.loginBtn.click();
			BrowserUtils.waitForVisibility(homePage.email, 5);
			homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
			homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
			BrowserUtils.waitForVisibility(homePage.loginClick, 5);
			homePage.loginClick.click();

		}

	
}
	


