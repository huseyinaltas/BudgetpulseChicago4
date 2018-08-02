package com.cbt.tests.transaction;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.pages.TransactionsPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;

public class Transaction extends TestBase {

	// Huseyin test3 - It is adding existing category
	@Test()
	public void addExistinCategory() {
		WebElement lastone = null;
		extentLogger = report.createTest("Adding existing category");
		// Add a transaction first
		HomePage.homePage();
		TransactionsPage transactionPage = new TransactionsPage();
		transactionPage.transactionPage.click();
		BrowserUtils.waitFor(3);
		transactionPage.clickCategories.click();
		BrowserUtils.waitFor(3);
		transactionPage.addCategory.click();
		BrowserUtils.waitFor(3);
		
		//write a category and submit
		transactionPage.writeCategory.sendKeys("TestDuplicateCategory");
		BrowserUtils.waitFor(3);
		transactionPage.submitCategory.click();
		BrowserUtils.waitFor(3);
		
		
		//write same category and submit
		transactionPage.addCategory.click();
		BrowserUtils.waitFor(3);
		transactionPage.writeCategory.sendKeys("TestDuplicateCategory");
		BrowserUtils.waitFor(3);
		transactionPage.submitCategory.click();	
		
		//Existing notfy  text 
		
		String expected = "Category already exists.";
		String actual= transactionPage.textExistingCategory.getText();
		BrowserUtils.waitFor(3);
		Assert.assertEquals(actual, expected);
		BrowserUtils.waitFor(3);
		//Delete Existing one for running again
		for(WebElement list : transactionPage.deleteExistingLastCategory ) {
			 lastone = list;
		}
		 lastone.click();
		 BrowserUtils.waitFor(3);
		 transactionPage.okDeleteExistingLastCategory.click();
		 BrowserUtils.waitFor(3);
		 

	}

}