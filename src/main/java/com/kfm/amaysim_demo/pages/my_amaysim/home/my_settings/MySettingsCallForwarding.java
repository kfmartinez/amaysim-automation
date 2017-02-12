package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsCallForwarding extends MySettingsPage {
    
    private By editLinkText;
    private By confirmButton;
    private By confirmationCancelButton;
    private By yesRadioButton;
    private By noRadioButton;
    private By forwardCallsToTextField;
    private By saveButton;
    private By cancelButton;
    private By closeSuccessMessage;
    private By errorMessage;
    
    public MySettingsCallForwarding(WebDriver driver) {
        super(driver);
        
        editLinkText = By.id("edit_settings_call_forwarding");
        confirmButton = By.xpath("//div[@id='lc_overlay_layer']/following-sibling::div/div/div/div/div/a[text()='Confirm']");
        confirmationCancelButton = By.xpath("//div[@id='lc_overlay_layer']/following-sibling::div/div/div/div/div/a[text()='Cancel']");
        yesRadioButton = By.id("my_amaysim2_setting_call_divert_true");
        noRadioButton = By.id("my_amaysim2_setting_call_divert_false");
        forwardCallsToTextField = By.id("my_amaysim2_setting_call_divert_number");
        saveButton = By.xpath("//label[text()='Forward calls to']/parent::div/following-sibling::div/div/input[@value='Save']");
        cancelButton = By.xpath("//label[text()='Forward calls to']/parent::div/following-sibling::div/div/div/a[text()='Cancel']");
//        closeSuccessMessage = By.xpath("//div[15]/a");
        closeSuccessMessage = By.xpath("//div[@data-popup-type='success']/a");
    }
    
    public boolean isYesRadioButtonSelected() {
        return isSelected(yesRadioButton);
    }
    
    public boolean isNoRadioButtonSelected() {
        return isSelected(noRadioButton);
    }
    
    public boolean isErrorMessagePresent(String errorMessage) {
        By xpath = By.xpath("//label[text()='Forward calls to']/following-sibling::small[text()='" + errorMessage + "']");
        return isDisplayed(xpath);
    }
    
    public MySettingsPage clickCloseSuccessMessage() {
        click(closeSuccessMessage);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickEditLinkText() {
        click(editLinkText);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickConfirmButton() {
        click(confirmButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickConfirmationCancelButton() {
        click(confirmationCancelButton);
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
    
    public MySettingsPage typeForwardCallsToTextField(String forwardCalls) {
        type(forwardCallsToTextField, forwardCalls);
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
