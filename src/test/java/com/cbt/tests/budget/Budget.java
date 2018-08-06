package com.cbt.tests.budget;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.BudgetPage;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;

public class Budget extends TestBase {

	
	// SPA-685  Aizada --Add new budget to the item
	@Test(priority = 14, groups= {"smoke", "regression"})
	public void addNewBudjetItem()  {
		extentLogger = report.createTest("Add New Budget Item");
		HomePage.homePage();
        BudgetPage bPage = new BudgetPage();
        bPage.budget.click();
        Assert.assertTrue(bPage.expenses.isDisplayed());
		bPage.greenBtn.click();
		Assert.assertTrue(bPage.greenBtn.isDisplayed());
		bPage.category.sendKeys("Groceries");
		bPage.budgetAmount.sendKeys("800");
		bPage.submitBtn.click();
		String actualAmount = bPage.totalBudget.getText();
		String expectedAmount = "$800.00";
		Assert.assertEquals(actualAmount, expectedAmount);
		bPage.dashboard.click();
		String actualBudgeted = bPage.VerifyBudgeted.getText();
		String expectedBudgeted = "$800.00";
		Assert.assertEquals(actualBudgeted, expectedBudgeted);
		extentLogger.pass("Verified log out link displayed");	
	}
	
	
	//TC #695 by Aigerim  Adding new budget item
	@Test(priority = 15, groups= {"regression"})
	public void AddNetSalaryBudget() {
		extentLogger = report.createTest("Add Net Salary Budget");
		HomePage.homePage();
        BudgetPage bPage = new BudgetPage();
        bPage.budget.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(bPage.income.isDisplayed());
		bPage.greenBtn.click();
		BrowserUtils.waitFor(2);
		Assert.assertTrue(bPage.greenBtn.isDisplayed());
		bPage.incomeSelect.click();
		BrowserUtils.waitFor(2);
		bPage.category.sendKeys("net salary");
		BrowserUtils.waitFor(2);
		bPage.budgetAmount.sendKeys("5000");
		BrowserUtils.waitFor(2);
		bPage.submitBtn.click();
		BrowserUtils.waitFor(2);
		bPage.incomePanel.click();
		BrowserUtils.waitFor(3);
		String actualBudgeted = bPage.incomeBudgetAmount.getText();
		String expectedBudgeted = "$5,000.00";
		Assert.assertEquals(actualBudgeted, expectedBudgeted);
		extentLogger.pass("Verified log out link displayed");

		}
	}


