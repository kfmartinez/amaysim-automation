package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsAutoRecharge extends MySettingsPage {

    private By editLinkText;
    private By yesRadioButton;
    private By noRadioButton;
    private By balanceDropsDropdown;
    private By rechargeSimDropdown;
    private By saveButton;
    private By cancelButton;
    
    public MySettingsAutoRecharge(WebDriver driver) {
        super(driver);
        
        editLinkText = By.id("edit_settings_auto_recharge");
        yesRadioButton = By.id("my_amaysim2_setting_auto_topup_true");
        noRadioButton = By.id("my_amaysim2_setting_auto_topup_false");
        balanceDropsDropdown = By.id("my_amaysim2_setting_auto_topup_min_balance");
        rechargeSimDropdown = By.id("my_amaysim2_setting_auto_topup_amount");
        saveButton = By.xpath("//select[@id='my_amaysim2_setting_auto_topup_amount']/parent::div/parent::div/parent::div/following-sibling::div/div/input[@value='Save']");
        cancelButton = By.xpath("//select[@id='my_amaysim2_setting_auto_topup_amount']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[text()='Cancel']");
    }
    
    public boolean isNoRadioButtonSelected() {
        return isSelected(noRadioButton);
    }
    
    public MySettingsPage clickEditLinkText() {
        click(editLinkText);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickYesRadioButton() {
        tickCheckbox(yesRadioButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickNoRadioButton() {
        tickCheckbox(noRadioButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage selectBalanceDropsDropdown(String balance) {
        selectDropdownByVisibleText(balanceDropsDropdown, balance);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage selectRechargeSimDropdown(String sim) {
        selectDropdownByVisibleText(rechargeSimDropdown, sim);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickSaveButton() {
        click(saveButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickCancelButton() {
        click(cancelButton);
        return new MySettingsPage(getWebDriver());
    }
    
}
