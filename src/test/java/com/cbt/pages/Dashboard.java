package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class Dashboard {
	
	public Dashboard() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	
}