package com.cbt.tests.dashboard;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class Dashboard extends TestBase {
	HomePage homePage = new HomePage();
	DashboardPage dashboardPage =  new DashboardPage();
	
	@Test(groups= {"smoke"}, priority = 1)
	public void budgetFunctionality() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		homePage.loginBtn.click();
		BrowserUtils.waitForVisibility(homePage.email, 5);
		homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		BrowserUtils.waitForVisibility(homePage.loginClick, 5);
		homePage.loginClick.click();

		dashboardPage.dashboard.click();
		
		assertTrue( dashboardPage.budgeted.isDisplayed());
		assertTrue( dashboardPage.actualExpense.isDisplayed());
		System.out.println(dashboardPage.budgeted.getText());
		BrowserUtils.waitForVisibility(dashboardPage.upcomingExpense,10);
		assertTrue( dashboardPage.upcomingExpense.isDisplayed());
		
	}

}
