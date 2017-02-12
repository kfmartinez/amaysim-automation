package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsSimNickname extends MySettingsPage {

    private By editLinkText;
    private By simNicknameTextField;
    private By saveButton;
    private By cancelButton;

    public MySettingsSimNickname(WebDriver driver) {
        super(driver);
    
        editLinkText = By.id("edit_settings_phone_label");
        simNicknameTextField = By.id("my_amaysim2_setting_phone_label");
        saveButton = By.xpath("//label[text()='SIM Nickname']/parent::div/following-sibling::div/div/input[@value='Save']");
        cancelButton = By.id("show_settings_sim_nickname");
    }

    public boolean isEditLinkTextDisplayed() {
        return isDisplayed(editLinkText);
    }
    
    public MySettingsPage clickEditLinkText() {
        click(editLinkText);
        return this;
    }
    
    public MySettingsPage typeSimNicknameTextField(String simNickname) {
        type(simNicknameTextField, simNickname);
        return this;
    }
    
    public MySettingsPage clickSaveButton() {
        click(saveButton);
        return this;
    }
    
    public MySettingsPage clickCancelButton() {
        click(cancelButton);
        return this;
    }
    
    @Override
    public String getPageId() {
        return null;
    }
    
}
