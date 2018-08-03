package com.cbt.tests.transaction;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

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
	
	    // SPA-835, Aizada.  ---Adding existing tag, negative test---
	     @Test
	     public void addingExistingNegativeTag()  {
	    	 HomePage.homePage();
	 	 TransactionsPage transactionPage = new TransactionsPage();
	 	 transactionPage.transactionPage.click();
	 	 BrowserUtils.waitFor(1);
	 	 transactionPage.tag.click();
	 	 transactionPage.addTag.click();
	 	 Assert.assertTrue(transactionPage.addTag.isDisplayed());
		 BrowserUtils.waitFor(1);
	 	 transactionPage.tagName.sendKeys("TestDuplicateTag");
	 	 transactionPage.submitTag.click();
         String actualAlert =  transactionPage.errorAlert.getText();
         String expectedAlert = "Tag already exists.";
         Assert.assertEquals(actualAlert, expectedAlert);
	 	 
	     }
	     
	

}