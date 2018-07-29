package com.cbt.tests.dashboard;

import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class Dashboard extends TestBase {
	
	
	@Test(groups= {"smoke"}, priority = 1)
	public void budgetFunctionality() {
		homePage();
		DashboardPage dashboardPage =  new DashboardPage();
		dashboardPage.dashboard.click();	
		assertTrue( dashboardPage.budgeted.isDisplayed());
		assertTrue( dashboardPage.actualExpense.isDisplayed());
		BrowserUtils.waitForVisibility(dashboardPage.upcomingExpense,5);
		assertTrue( dashboardPage.upcomingExpense.isDisplayed());
		
	}
	
	@Test(groups= {"smoke"}, priority = 2)
	public void title() {
		homePage();
		DashboardPage dashboardPage =  new DashboardPage();
		dashboardPage.dashboard.click();
		BrowserUtils.waitForVisibility(dashboardPage.logo,5);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard | BudgetPulse";
		Assert.assertEquals(actualTitle, expectedTitle);
	
	
	}

	public void homePage() {
		HomePage homePage = new HomePage();	
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		homePage.loginBtn.click();
		BrowserUtils.waitForVisibility(homePage.email, 5);
		homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		BrowserUtils.waitForVisibility(homePage.loginClick, 5);
		homePage.loginClick.click();

		
		
		
		
		
	}

}
