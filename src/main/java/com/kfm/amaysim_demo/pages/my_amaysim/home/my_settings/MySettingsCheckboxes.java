package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsCheckboxes extends MySettingsPage {

    private By callerIdCheckbox;
    private By callerWaitingCheckbox;
    private By voiceMailCheckbox;
    private By usageAlertsCheckbox;
    private By internationalRoamingCheckbox;
    private By internationalRoamingForm;
    private By closeSuccessMessage;
    private By usageAlertsForm;
    
    public MySettingsCheckboxes(WebDriver driver)
    {
        super(driver);
        
        callerIdCheckbox = By.id("my_amaysim2_setting_caller_id_out");
        callerWaitingCheckbox = By.id("my_amaysim2_setting_caller_waiting");
        voiceMailCheckbox = By.id("my_amaysim2_setting_voice_mail");
        usageAlertsForm = By.id("edit_setting_usage_alert_730817");
        usageAlertsCheckbox = By.xpath("my_amaysim2_setting_usage_alert");
        internationalRoamingCheckbox = By.id("my_amaysim2_setting_intl_roaming");
        internationalRoamingForm = By.id("edit_setting_intl_roaming_730817");
        closeSuccessMessage = By.xpath("//p[text()='We have successfully updated your SIM settings.']/following-sibling::a");
    }
    
    public MySettingsPage clickCloseSuccessMessageButton() {
        click(closeSuccessMessage);
        return new MySettingsPage(getWebDriver());
    }
    
    public boolean isSuccessMessageDisplayed(String successMessage) {
        By xpath = By.xpath("//p[@class='popup-content'][text()='" + successMessage + "']");
        return isDisplayed(xpath);
    }
    
    public MySettingsPage tickCallerIdCheckbox() {
        tickCheckbox(callerIdCheckbox);
        return new MySettingsPage(getWebDriver());
    }

    public MySettingsPage tickCallerWaitingCheckbox() {
        tickCheckbox(callerWaitingCheckbox);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage tickVoiceMailCheckbox() {
        tickCheckbox(voiceMailCheckbox);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage tickUsageAlertsCheckbox() {
        By confirmButton = By.xpath("//h1[text()='Confirmation']/following-sibling::div/div/div/div/a[text()='Yes']");
        click(usageAlertsForm);
        click(confirmButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage tickInternationalRoamingCheckbox() {
        By confirmButton = By.xpath("//h1[text()='Confirmation']/following-sibling::div/div/div/div/a[text()='Yes']");
        tickCheckbox(internationalRoamingForm);
        click(confirmButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage untickCallerIdCheckbox() {
        untickCheckbox(callerIdCheckbox);
        return new MySettingsPage(getWebDriver());
    }

    public MySettingsPage untickCallerWaitingCheckbox() {
        untickCheckbox(callerWaitingCheckbox);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage untickVoiceMailCheckbox() {
        untickCheckbox(voiceMailCheckbox);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage untickUsageAlertsCheckbox() {
        By confirmButton = By.xpath("//h1[text()='Confirmation']/following-sibling::div/div/div/div/a[text()='Yes']");
        click(usageAlertsForm);
        click(confirmButton);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage untickInternationalRoamingCheckbox() {
        By confirmButton = By.xpath("//h1[text()='Confirmation']/following-sibling::div/div/div/div/a[text()='Yes']");
        untickCheckbox(internationalRoamingForm);
        click(confirmButton);
        return new MySettingsPage(getWebDriver());
    }
    
}
