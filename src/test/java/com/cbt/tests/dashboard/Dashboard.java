package com.cbt.tests.dashboard;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

		homePage.loginBtn.click();
		BrowserUtils.waitForVisibility(homePage.email, 5);
		homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		BrowserUtils.waitForVisibility(homePage.loginClick, 5);
		homePage.loginClick.click();

	}

}
