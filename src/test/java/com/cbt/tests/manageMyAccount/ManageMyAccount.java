package com.cbt.tests.manageMyAccount;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.pages.ManageMyAccountPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;



public class ManageMyAccount extends TestBase {
	
	DashboardPage dashboardPage =  new DashboardPage();
	ManageMyAccountPage maccp=new ManageMyAccountPage();
	
	@Test(groups= {"smoke"},priority=1)
	public void dashboardLink() throws InterruptedException{
         homePage();
		// this is for click dashboard in homepage
		dashboardPage.dashboard.click();
		//this for clicking the manage my accounts link
		maccp.manageAccLink.click();
		JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
		jse.executeScript("window.scrollBy(0,350)", "");
		BrowserUtils.waitForVisibility(maccp.transactionFund, 5);
		//this is clicking for Transaction fund
		Thread.sleep(5000);
		maccp.transactionFund.click();
		Thread.sleep(10000);
		BrowserUtils.waitForVisibility(maccp.amountFrom, 5);
		//this for selecting bank name from dropDown
		Select dropDown=new Select(maccp.amountFrom);
		dropDown.selectByVisibleText("Wells Fargo");
		//to bank
		Select dropDown1=new Select(maccp.amountTo);
		dropDown.selectByVisibleText("Citi");
		// first i have clear placeholders 
		maccp.description.clear();
		maccp.description.sendKeys("July transfer");
		//this for amount input
		maccp.amount.sendKeys("200");
		
		//this is for clicking the submit button in account page
		maccp.submitButton.click();
		
		
		
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
