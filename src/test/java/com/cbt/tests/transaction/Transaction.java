package com.cbt.tests.transaction;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.HomePage;
import com.cbt.pages.TransactionsPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.Driver;

public class Transaction extends TestBase {

	// Huseyin test3 - It is adding existing category
	@Test(priority = 20, groups= {"regression"})
	public void addExistingCategory() {
		extentLogger = report.createTest("Adding existing category");
		WebElement lastone = null;
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
		BrowserUtils.waitFor(1);
		String actual= transactionPage.textExistingCategory.getText();
		String expected = "Category already exists.";
		BrowserUtils.waitFor(3);
		Assert.assertEquals(actual, expected);
		BrowserUtils.waitFor(3);
		//Delete Existing one for running again
		String path = null;
		int count = 0;
		for (WebElement listEx : transactionPage.finderExistingCatogory) {
			count++;
			if(listEx.getText().equals("TestDuplicateCategory")){
			System.out.println(listEx.getText()+ " :"+count);
			break;
			}
		}
		path = "(//span[@class='icon']/../../../td/a[@class='delete_category'])["+count+"]";
		lastone = Driver.getDriver().findElement(By.xpath(path));
		
		 lastone.click();
		 BrowserUtils.waitFor(3);
		 transactionPage.okDeleteExistingLastCategory.click();
		 BrowserUtils.waitFor(3);
		extentLogger.pass("Verified log out link displayed");

	
		 }
	
	
	 // SPA-835, Aizada.  ---Adding existing tag, negative test---
	@Test(priority = 21, groups= {"regression"})
	     public void addingExistingNegativeTag()  {
		extentLogger = report.createTest("Adding existing Tag-Negative");
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
 		BrowserUtils.waitFor(3); 
		Driver.getDriver().get("file:///Users/huseyinaltas/Desktop/Html/actual.html");
		BrowserUtils.waitFor(5);
		Driver.getDriver().findElement(By.id("a")).click();
		BrowserUtils.waitFor(10);

		extentLogger.pass("Verified log out link displayed");
		
		
	}


}