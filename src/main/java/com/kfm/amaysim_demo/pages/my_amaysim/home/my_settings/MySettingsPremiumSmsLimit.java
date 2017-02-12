package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsPremiumSmsLimit extends MySettingsPage {

    private By editLinkText;
    private By chooseYouLimitDropdown;
    private By saveButton;
    private By cancelButton;
    
    public MySettingsPremiumSmsLimit(WebDriver driver)
    {
        super(driver);
    
        editLinkText = By.id("edit_settings_premium_sms_limit");
        chooseYouLimitDropdown = By.id("my_amaysim2_setting_psms_spend");
        saveButton = By.xpath("//select[@id='my_amaysim2_setting_psms_spend']/parent::div/parent::div/following-sibling::div/div/input[@value='Save']");
        cancelButton = By.xpath("//select[@id='my_amaysim2_setting_psms_spend']/parent::div/parent::div/following-sibling::div/div/div/a[text()='Cancel']");
    }

    public MySettingsPage clickEditLinkText() {
        click(editLinkText);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage selectLimitDropdown(String limit) {
        selectDropdownByVisibleText(chooseYouLimitDropdown, limit);
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
