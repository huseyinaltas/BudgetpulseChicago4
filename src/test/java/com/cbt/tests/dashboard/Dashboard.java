package com.cbt.tests.dashboard;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import com.cbt.pages.ToolsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

	//Nargiza, checking budget functionality, expense
	@Test(groups= {"smoke", "regression"},priority = 1)
	public void budgetFunctionalityExpense() {
		extentLogger = report.createTest("Budget Functionality Expense Test");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		assertTrue(dashboardPage.budgeted.isDisplayed());
		assertTrue(dashboardPage.actualExpense.isDisplayed());
		BrowserUtils.waitForVisibility(dashboardPage.upcomingExpense, 5);
		assertTrue(dashboardPage.upcomingExpense.isDisplayed());
		extentLogger.pass("Verified log out link displayed");
	}

	// Nargiza, checking budget functionality, income
	@Test(groups= {"regression"}, priority = 2)
	public void budgetFunctionalityIncome() {
		extentLogger = report.createTest("Budget Functionality Income Test");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		dashboardPage.selectSortBy("Income", dashboardPage.overview);
		assertTrue(dashboardPage.budgeted.isDisplayed());
		assertTrue(dashboardPage.actualIncome.isDisplayed());
		BrowserUtils.waitFor(3);
		assertTrue(dashboardPage.upcomingIncome.isDisplayed());
		extentLogger.pass("Verified log out link displayed");

	}

	// Nargiza adding duplicate account, negative scenario
	@Test(priority = 3, groups= {"regression"})
	public void addDuplicateAccountNegativ() {
		extentLogger = report.createTest("Add duplicate Account-Negative");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		dashboardPage.addAccountBtn.click();
		dashboardPage.selectSortBy("Checking Accounts", dashboardPage.selectAccType);
		dashboardPage.accountName.sendKeys(ConfigurationReader.getProperty("name"));
		dashboardPage.openBalance.sendKeys(ConfigurationReader.getProperty("openingBalance"));
		dashboardPage.newAccSubmitBtn.submit();
		String expectedMsg = ConfigurationReader.getProperty("nameExist");
		String actualMsg = dashboardPage.nameAlreadyExist.getText();
		assertEquals(actualMsg, expectedMsg);
		extentLogger.pass("Verified log out link displayed");

	}

	// Huseyin test1
	@Test(priority = 4, groups= {"smoke", "regression"})
	public void title() {
		extentLogger = report.createTest("Title");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);
		extentLogger.pass("Verified log out link displayed");

	}

	// Aizada's smoke test case
	@Test(priority = 5, groups= {"smoke", "regression"})
	public void cashFlow() {
		extentLogger = report.createTest("Cashflow Test");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);
		dashboardPage.cashFlow.click();
		String actualResult = dashboardPage.defaultValue.getText();
		Assert.assertEquals(actualResult, "Today");
		Assert.assertTrue(dashboardPage.totalIncome.isDisplayed());
		Assert.assertTrue(dashboardPage.totalExpense.isDisplayed());
		Assert.assertTrue(dashboardPage.accountBalance.isDisplayed());
		extentLogger.pass("Verified log out link displayed");
	}

	// this is smoke test for Add Account functionality (Adilet)

	@Test(priority = 6, groups= {"smoke", "regression"})
	public void addAccount() {
		extentLogger = report.createTest("Add account");
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
		extentLogger.pass("Verified log out link displayed");
	}

	// this test checks for Add Account functionality (Adilet)

	@Test(priority = 7, groups= {"regression"})
	public void addAccountTest() {
		extentLogger = report.createTest("Add account-negative");
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
		extentLogger.pass("Verified log out link displayed");
	}

	// akmal's test case SPA-611
	@Test(priority = 8, groups= {"smoke", "regression"})
	public void checkTrasactionDate() throws Exception {
		extentLogger = report.createTest("Check Transaction Date");
		TransactionsPage tp = new TransactionsPage();
		DashboardPage dashboardPage = new DashboardPage();
		HomePage.homePage();
		dashboardPage.dashboard.click();
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
		// Thread.sleep(5000);
		// tp.recentTransactions.click();

		// Select dropDown=new Select(dashboardPage.transMonth);
		// dropDown.selectByVisibleText("Custom");
		BrowserUtils.waitFor(3);
		dashboardPage.dateFrom.click();
		BrowserUtils.waitFor(3);
		dashboardPage.prePicker.click();
		BrowserUtils.waitFor(3);
		dashboardPage.specificDate1.click();

		BrowserUtils.waitFor(3);

		String expectedDate1 = "07/16/2018";
		String actualDate1 = dashboardPage.actual1.getAttribute("value");
		System.out.println(expectedDate1);
		System.out.println(actualDate1);
		Assert.assertEquals(expectedDate1, actualDate1);

		// dashboardPage.dateFrom.sendKeys("07/16/2018");
		// Thread.sleep(5000);
		// dashboardPage.dateTo.clear();
		// dashboardPage.dateTo.sendKeys("07/25/2018");

		BrowserUtils.waitFor(3);
		dashboardPage.dateTo.click();
		BrowserUtils.waitFor(3);
		dashboardPage.prePicker.click();
		BrowserUtils.waitFor(3);
		dashboardPage.specificDate2.click();

		BrowserUtils.waitFor(3);
		String expectedDate2 = "07/25/2018";
		String actualDate2 = dashboardPage.actual2.getAttribute("value");
		System.out.println(expectedDate2);
		System.out.println(actualDate2);

		Assert.assertEquals(expectedDate2, actualDate2);

		BrowserUtils.waitFor(10);
		dashboardPage.submitButton1771.click();
		extentLogger.pass("Verified log out link displayed");
	}

	// Huseyin test2 - It is deleting Transaction

	@Test(priority = 9, groups= {"regression"})
	public void deleteTransaction() {
		extentLogger = report.createTest("Delete Transaction");
		// Add a transaction first
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
		dashboardPage.goToBofAChecking.click();
		dashboardPage.addNewTransactionToBofA.click();
		dashboardPage.transactionAmountBofA.sendKeys("1200");
		Random rd = new Random();
		int discNo = rd.nextInt(100);
		String disc = "This is an Example" + discNo;
		dashboardPage.transactionDescriptionBofA.sendKeys(disc);
		Select select = new Select(dashboardPage.transactionSelectAccountBofA);
		select.selectByVisibleText("BofA");
		dashboardPage.transactionSubmitDoneToBofA.click();
		Driver.getDriver().get("https://www.budgetpulse.com/dashboard");

		// Delete the created transaction
		dashboardPage.goToBofAChecking.click();
		String idLastBeforeDelete = dashboardPage.transactionLastOnetoSelecetToBofA1.getAttribute("id");
		// System.out.println(idLastBeforeDelete);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,350)", "");
		BrowserUtils.waitFor(3);
		dashboardPage.transactionLastOnetoSelecetToBofA.click();
		BrowserUtils.waitFor(3);
		dashboardPage.transactionDeleteSelectedToBofA.click();
		BrowserUtils.waitFor(3);
		dashboardPage.transactionOkbuttonForDeleteToBofA.click();
		BrowserUtils.waitFor(3);
		String idLastAfterDelete = dashboardPage.transactionLastOnetoSelecetToBofA1.getAttribute("id");
		BrowserUtils.waitFor(3);
		// System.out.println(idLastAfterDelete);
		Assert.assertNotEquals(idLastBeforeDelete, idLastAfterDelete);
		extentLogger.pass("Verified log out link displayed");
	}

	// AddNote TC#612 by Aigerim
	@Test(priority = 10, groups= {"regression"})
	public void addNote() {
		extentLogger = report.createTest("Add Note");
		HomePage.homePage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 3);
		dashboardPage.goToBofAChecking.click();
		dashboardPage.addNewTransactionToBofA.click();
		dashboardPage.transactionAmountBofA.sendKeys("3000");
		Random rd = new Random();
		int discNo = rd.nextInt(100);
		String disc = "Aigerim's transaction" + discNo;
		dashboardPage.transactionDescriptionBofA.sendKeys(disc);
		Select select = new Select(dashboardPage.transactionSelectAccountBofA);
		select.selectByVisibleText("BofA");
		dashboardPage.transactionSubmitDoneToBofA.click();
		BrowserUtils.waitFor(5);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,350)", "");
		BrowserUtils.waitFor(3);
		dashboardPage.transactionToddleArrowBtn.click();
		BrowserUtils.waitFor(3);
		dashboardPage.transactionAddNote.click();
		TransactionsPage transaction = new TransactionsPage();
		BrowserUtils.waitFor(3);
		transaction.addNote.sendKeys("Cybertek payment");
		transaction.submitDone.click();
		dashboardPage.transactionToddleArrowBtn.click();
		BrowserUtils.waitFor(3);
		dashboardPage.deleteTransactionOnDashboard.click();
		extentLogger.pass("Verified log out link displayed");
	}

	// ReadNote TC#613 by Aigerim
	@Test(priority = 11, groups= {"regression"})
	public void readNote() {
		extentLogger = report.createTest("Read Note");
		HomePage.homePage();
		TransactionsPage transaction = new TransactionsPage();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo, 3);
		dashboardPage.goToBofAChecking.click();
		dashboardPage.addNewTransactionToBofA.click();
		dashboardPage.transactionAmountBofA.sendKeys("3000");
		Random rd = new Random();
		int discNo = rd.nextInt(100);
		String disc = "Aigerim's transaction" + discNo;
		dashboardPage.transactionDescriptionBofA.sendKeys(disc);
		Select select = new Select(dashboardPage.transactionSelectAccountBofA);
		select.selectByVisibleText("BofA");
		dashboardPage.transactionSubmitDoneToBofA.click();
		BrowserUtils.waitFor(5);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,350)", "");
		BrowserUtils.waitFor(3);
		dashboardPage.transactionToddleArrowBtn.click();
		BrowserUtils.waitFor(3);
		dashboardPage.transactionAddNote.click();
		BrowserUtils.waitFor(3);
		transaction.addNote.sendKeys("Cybertek payment");
		transaction.submitDone.click();
		dashboardPage.transactionToddleArrowBtn.click();
		BrowserUtils.waitFor(3);
		dashboardPage.transactionAddNote.click();
		String actualText = transaction.addNote.getText();
		System.out.println(transaction.addNote.getText());
		String expectedText = "Cybertek payment";
		Assert.assertEquals(actualText, expectedText);
		transaction.submitDone.click();
		dashboardPage.transactionToddleArrowBtn.click();
		BrowserUtils.waitFor(3);
		dashboardPage.deleteTransactionOnDashboard.click();
		extentLogger.pass("Verified log out link displayed");
	}

	// Akmal's test case SPA-610
	@Test(priority = 12, groups= {"regression"})
	public void changeTransactionDescription() {
		extentLogger = report.createTest("Change Transaction Description");
		TransactionsPage tp = new TransactionsPage();
		DashboardPage dashboardPage = new DashboardPage();
		HomePage.homePage();
		dashboardPage.dashboard.click();
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");

		BrowserUtils.waitFor(3);
		Actions action = new Actions(driver);
		BrowserUtils.waitFor(3);
		action.moveToElement(dashboardPage.hoverOver).perform();

		BrowserUtils.waitFor(3);
		// action.moveToElement(dashboardPage.editClick).perform();

		dashboardPage.editClick.click();

		BrowserUtils.waitFor(3);

		dashboardPage.write.sendKeys("June Expenses");

		BrowserUtils.waitFor(3);

		dashboardPage.save.click();
		BrowserUtils.waitFor(3);
		String expectedDescription = "June Expenses";
		String actualDescription = dashboardPage.text.getText();
		BrowserUtils.waitFor(3);
		Assert.assertEquals(actualDescription, expectedDescription);
		System.out.println(actualDescription);
		extentLogger.pass("Verified log out link displayed");
	}

	// SPA-803 Export Account
	@Test(priority = 13, groups= {"regression"})
	public void exportAccount() {
		extentLogger = report.createTest("Export Account");
		HomePage.homePage();
		DashboardPage pom = new DashboardPage();
		ToolsPage tools = new ToolsPage();
		pom.dashboard.click();
		pom.bofa.click();
		pom.exportData.click();
		tools.exportAccounts.click();
		BrowserUtils.waitForVisibility(tools.selectAccount, 5);
		Select select = new Select(tools.selectAccount);
		select.selectByVisibleText("BofA");
		BrowserUtils.waitForVisibility(tools.selectTransactions, 5);
		Select select2 = new Select(tools.selectTransactions);
		select2.selectByVisibleText("All Transactions");
		Assert.assertTrue(tools.exportBtn.isEnabled(), "Export button is disabled");
		extentLogger.pass("Verified log out link displayed");
	}

}
