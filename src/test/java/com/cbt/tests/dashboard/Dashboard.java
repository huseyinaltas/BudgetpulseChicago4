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

	// Huseyin test2 - It is deleting Transaction 
		@Test()
		public void deleteTransaction() {
			extentLogger = report.createTest("Delete Transaction");
		//Add a transaction first
			HomePage.homePage();
			DashboardPage dashboardPage = new DashboardPage();
			dashboardPage.dashboard.click();
			BrowserUtils.waitForVisibility(dashboardPage.logo, 5);
			dashboardPage.goToBofAChecking.click();
			dashboardPage.addNewTransactionToBofA.click();
			dashboardPage.transactionAmountBofA.sendKeys("1200");
			Random rd = new Random();
			int discNo = rd.nextInt(100);
			String disc ="This is an Example"+discNo;
			dashboardPage.transactionDescriptionBofA.sendKeys(disc);
			Select select = new Select(dashboardPage.transactionSelectAccountBofA);
			select.selectByVisibleText("BofA");
			dashboardPage.transactionSubmitDoneToBofA.click();
			Driver.getDriver().get("https://www.budgetpulse.com/dashboard");
	
			//Delete the created transaction
			dashboardPage.goToBofAChecking.click();
			String idLastBeforeDelete=dashboardPage.transactionLastOnetoSelecetToBofA1.getAttribute("id");
//			System.out.println(idLastBeforeDelete);
			JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
			jse.executeScript("window.scrollBy(0,350)", "");
			BrowserUtils.waitFor(3);
			dashboardPage.transactionLastOnetoSelecetToBofA.click();
			BrowserUtils.waitFor(3);
			dashboardPage.transactionDeleteSelectedToBofA.click();
			BrowserUtils.waitFor(3);
			dashboardPage.transactionOkbuttonForDeleteToBofA.click();
			BrowserUtils.waitFor(3);
			String idLastAfterDelete=dashboardPage.transactionLastOnetoSelecetToBofA1.getAttribute("id");
			BrowserUtils.waitFor(3);
//			System.out.println(idLastAfterDelete);
			Assert.assertNotEquals(idLastBeforeDelete, idLastAfterDelete);
		}
		
//AddNote TC#612 by Aigerim
@Test
public void addNote() {
	HomePage.homePage();
	DashboardPage dashboardPage = new DashboardPage();
	dashboardPage.dashboard.click();
	BrowserUtils.waitForVisibility(dashboardPage.logo, 3);
	dashboardPage.goToBofAChecking.click();
	dashboardPage.addNewTransactionToBofA.click();
	dashboardPage.transactionAmountBofA.sendKeys("3000");
	Random rd = new Random();
	int discNo = rd.nextInt(100);
	String disc ="Aigerim's transaction"+discNo;
	dashboardPage.transactionDescriptionBofA.sendKeys(disc);
	Select select = new Select(dashboardPage.transactionSelectAccountBofA);
	select.selectByVisibleText("BofA");
	dashboardPage.transactionSubmitDoneToBofA.click();
	BrowserUtils.waitFor(5);
	JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
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
	
	
}

//ReadNote TC#613 by Aigerim
 
	
	@Test
	public void readNote(){
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
		String disc ="Aigerim's transaction"+discNo;
		dashboardPage.transactionDescriptionBofA.sendKeys(disc);
		Select select = new Select(dashboardPage.transactionSelectAccountBofA);
		select.selectByVisibleText("BofA");
		dashboardPage.transactionSubmitDoneToBofA.click();
		BrowserUtils.waitFor(5);
		JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
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
	
	}
}


