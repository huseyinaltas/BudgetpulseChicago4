package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsPage {
    public ToolsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // Export Account
    @FindBy(xpath = "//h2[contains(text(), 'Export Accounts')]")
    public WebElement exportAccounts;

    @FindBy (id = "ToolsAccount")
    public WebElement selectAccount;

    @FindBy (id="ToolsTransaction")
    public WebElement selectTransactions;

    @FindBy (id="export-button")
    public WebElement exportBtn;
}
