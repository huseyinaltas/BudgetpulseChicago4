package com.cbt.tests.manageMyAccount;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.pages.ManageMyAccountPage;
import com.cbt.tests.TestBase;
import com.cbt.tests.dashboard.Dashboard;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;



public class ManageMyAccount extends TestBase {
	
	
	//akmal
	@Test()
	public void dashboardLink() throws InterruptedException{
		DashboardPage dashboardPage =  new DashboardPage();
		ManageMyAccountPage maccp=new ManageMyAccountPage();
		HomePage.homePage();
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
	
	//SPA 422 - Mammadova
	@Test
	public void negativeTransferFund() throws InterruptedException{
		DashboardPage dashboardPage =  new DashboardPage();
		ManageMyAccountPage maccp=new ManageMyAccountPage();
		HomePage.homePage();
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
		dropDown.selectByVisibleText("Chase");
		//to bank
		Select dropDown1=new Select(maccp.amountTo);
		dropDown1.selectByVisibleText("Chase");
		// first I have to clear placeholders 
		maccp.description.clear();
		maccp.description.sendKeys("July transfer");
		//this for amount input
		maccp.amount.sendKeys("100");
		
		//this is for clicking the submit button in account page
		maccp.submitButton.click();
	
		BrowserUtils.waitFor(2);
		assertEquals(driver.findElement(By.xpath("//div[@id='transfer_funds_errors']")).getText(),"Please select a different account for transfer.");
		
	
	}
}
