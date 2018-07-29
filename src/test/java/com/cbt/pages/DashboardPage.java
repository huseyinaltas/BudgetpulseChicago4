package com.cbt.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class DashboardPage {

	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//li[@class='first']/a")
	public WebElement dashboard;

	@FindBy(id = "select_budget_type")
	public WebElement overview;

	@FindBy(xpath = "//div[@class='capsule capsule-neutral capsule-first']")
	public WebElement budgeted;

	@FindBy(xpath = "//div[@class='capsule capsule-neutral'][1]")
	public WebElement actualExpense;

	@FindBy(xpath = "//div[@class='dashboard_panel_content']/div[3]")
	public WebElement upcomingExpense;

}