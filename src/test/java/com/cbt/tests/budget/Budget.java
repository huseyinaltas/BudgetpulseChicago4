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
	@Ignore
	@Test
	public void addNewBudjetItem()  {
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
		}
	//TC #695 by Aigerim  Adding new budget item
	
	@Test
	public void AddNetSalaryBudget() {
		HomePage.homePage();
        BudgetPage bPage = new BudgetPage();
        bPage.budget.click();
        Assert.assertTrue(bPage.income.isDisplayed());
		bPage.greenBtn.click();
		Assert.assertTrue(bPage.greenBtn.isDisplayed());
		bPage.category.sendKeys("net salary");
		bPage.budgetAmount.sendKeys("5000");
		bPage.submitBtn.click();
		String actualAmount = bPage.totalBudget.getText();
		System.out.println(bPage.totalBudget.getText());
		String expectedAmount = "$5,000.00";
		Assert.assertEquals(actualAmount, expectedAmount);
		bPage.dashboard.click();
		String actualBudgeted = bPage.netSalaryBudgeted.getText();
		String expectedBudgeted = "Budgeted: $5,000.00";
		Assert.assertEquals(actualBudgeted, expectedBudgeted);
		}
	}



