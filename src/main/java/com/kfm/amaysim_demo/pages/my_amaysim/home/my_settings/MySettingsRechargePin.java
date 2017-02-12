package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsRechargePin extends MySettingsPage {
    
    private By editLinkText;
    private By rechargePinTextField;
    private By saveButton;
    private By cancelButton;
    
    public MySettingsRechargePin(WebDriver driver) {
        super(driver);
        
        editLinkText = By.id("edit_settings_recharge_pin");
        rechargePinTextField = By.id("my_amaysim2_setting_topup_pw");
        saveButton = By.xpath("//label[text()='Recharge PIN']/parent::div/following-sibling::div/div/input[@value='Save']");
        cancelButton = By.xpath("//label[text()='Recharge PIN']/parent::div/following-sibling::div/div/div/a[text()='Cancel']");
    }

    public boolean isEditLinkTextDisplayed() {
        return isDisplayed(editLinkText);
    }

    public MySettingsPage clickEditLinkText() {
        click(editLinkText);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage typeRechargePinTextField(String rechargePin) {
        type(rechargePinTextField, rechargePin);
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
