package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.my_amaysim.home.MyAmaysimHomePage;

public class MySettingsPage extends MyAmaysimHomePage {
    
    private MySettingsValues mySettingsValues;
    
    private By simNicknameText;
    private By planSettingsPaymentTypeText;
    private By rechargePINText;
    private By pukCodeText;
    private By isCallerIdSelected;
    private By isCallerWaitingSelected;
    private By isVoiceMailSelected;
    private By isUsageAlertsSelected;
    private By isInternationalRoamingSelected;
    private By callForwardingText;
    private By callForwardingTextValue;
    private By premiumSMSLimitText;
    private By autoRechargeText;
    private By autoRechargeTextStatus;
    
    private MySettingsSimNickname mySettingsSimNickname;
    private MySettingsPlanSettings mySettingsPlanSettings;
    private MySettingsRechargePin mySettingsRechargePin;
    private MySettingsPukCode mySettingsPukCode;
    private MySettingsCheckboxes mySettingsCheckboxes;
    private MySettingsCallForwarding mySettingsCallForwarding;
    private MySettingsPremiumSmsLimit mySettingsPremiumSmsLimit;
    private MySettingsAutoRecharge mySettingsAutoRecharge;
    
    public MySettingsPage(WebDriver driver)
    {
        super(driver);
        mySettingsValues = new MySettingsValues();
        
        simNicknameText = By.xpath("//div[text()='SIM Nickname']/following-sibling::div");
        planSettingsPaymentTypeText = By.xpath("//a[text()='Prepaid, BPay']");
        rechargePINText = By.xpath("//div[text()='Recharge PIN']/following-sibling::div");
        pukCodeText = By.xpath("//div[text()='PUK code']/following-sibling::div");
        isCallerIdSelected = By.id("my_amaysim2_setting_caller_id_out");
        isCallerWaitingSelected = By.id("my_amaysim2_setting_caller_waiting");
        isVoiceMailSelected = By.id("my_amaysim2_setting_voice_mail");
        isUsageAlertsSelected = By.id("my_amaysim2_setting_usage_alert");
        isInternationalRoamingSelected = By.id("my_amaysim2_setting_intl_roaming");
        callForwardingText = By.xpath("//div[@id='settings_call_forwarding']/div/div/div[2]");
        callForwardingTextValue = By.xpath("//div[@id='settings_call_forwarding']/div/div/div/div/div[contains(text(), 'Forward calls to')]");
        premiumSMSLimitText = By.xpath("//div[@id='settings_premium_sms_limit']/div/div/div[contains(text(), '$')] | //div[@id='settings_premium_sms_limit']/div/div/div[contains(text(), 'N')]");
        autoRechargeText = By.xpath("//div[text()='Auto-recharge']/parent::div/following-sibling::div/div[contains(text(), 'Recharge my mobile service')]");
        autoRechargeTextStatus = By.xpath("//div[@id='settings_auto_recharge']/div/div/div[2]");
    }

    public String getForwardingCallsTextValue() {
        return getWebElementText(callForwardingTextValue);
    }

    public boolean isFormatErrorMessageAvailable(String errorMessage) {
        By xpath = By.xpath("//label[text()='Forward calls to']/following-sibling::span[contains(text(), '" + errorMessage + "')]");
        return isDisplayed(xpath);
    }
    
    public boolean isValidityErrorMessageAvailable(String label, String errorMessage) {
        By xpath = By.xpath("//label[text()='" + label + "']/following-sibling::div/small[text()='" + errorMessage + "']");
        return isDisplayed(xpath);
    }
    
    public boolean isSimNicknameErrorMessageAvailable(String errorMessage) {
        return isValidityErrorMessageAvailable("SIM Nickname", errorMessage);
    }
    
    public boolean isRechargePINErrorMessageAvailable(String errorMessage) {
        return isValidityErrorMessageAvailable("Recharge PIN", errorMessage);
    }
    
    public boolean isForwardCallsToErrorMessageAvailable(String errorMessage) {
        return isValidityErrorMessageAvailable("Forward calls to", errorMessage);
    }

    public String getSimNicknameText() {
        return getWebElementText(simNicknameText);
    }

    public String getPlanSettingsPaymentTypeText() {
        return getWebElementText(planSettingsPaymentTypeText);
    }
    
    public String getRechargePINText() {
        return getWebElementText(rechargePINText);
    }
    
    public String getPukCodeText() {
        return getWebElementText(pukCodeText);
    }
    
    public boolean isCallerIdSelected() {
        return isSelected(isCallerIdSelected);
    }
    
    public boolean isCallerWaitingSelected() {
        return isSelected(isCallerWaitingSelected);
    }
    
    public boolean isVoiceMailSelected() {
        return isSelected(isVoiceMailSelected);
    }
    
    public boolean isUsageAlertsSelected() {
        return isSelected(isUsageAlertsSelected);
    }
    
    public boolean isInternationalRoamingSelected() {
        return isSelected(isInternationalRoamingSelected);
    }

    public String getCallForwardingText() {
        return getWebElementText(callForwardingText);
    }
    
    public String getPremiumSMSLimitText() {
        return getWebElementText(premiumSMSLimitText);
    }
    
    public String getAutoRechargeText() {
        return getWebElementText(autoRechargeText);
    }
    
    public String getAutoRechargeTextStatus() {
        return getWebElementText(autoRechargeTextStatus);
    }
    
    public void setAllMySettingsPageValues() {

        String simNickname = getSimNicknameText();
        String planSettingsPaymentType = getPlanSettingsPaymentTypeText();
        String rechargePIN = getRechargePINText();
        String pukCode = getPukCodeText();
        
        boolean callerId = isCallerIdSelected();
        boolean callerWaiting = isCallerWaitingSelected();
        boolean voiceMail = isVoiceMailSelected();
        boolean usageAlerts = isUsageAlertsSelected();
        boolean internationalRoaming = isInternationalRoamingSelected();
        
        String callForwarding = getWebElementText(callForwardingText);
        String premiumSMSLimit = getWebElementText(premiumSMSLimitText);
        String autoRecharge = getWebElementText(autoRechargeText);
        
        mySettingsValues.setSimNickname(simNickname);
        mySettingsValues.setPlanSettingsPaymentType(planSettingsPaymentType);
        mySettingsValues.setRechargePIN(rechargePIN);
        mySettingsValues.setPukCode(pukCode);
        mySettingsValues.setCallerId(callerId);
        mySettingsValues.setCallerWaiting(callerWaiting);
        mySettingsValues.setVoiceMail(voiceMail);
        mySettingsValues.setUsageAlerts(usageAlerts);
        mySettingsValues.setInternationalRoaming(internationalRoaming);
        mySettingsValues.setCallForwarding(callForwarding);
        mySettingsValues.setPremiumSMSLimit(premiumSMSLimit);
        mySettingsValues.setAutoRecharge(autoRecharge);
    }

    public MySettingsValues getMySettingsValues() {
        return mySettingsValues;
    }

    public MySettingsSimNickname getMySettingsSimNickname()
    {
        return new MySettingsSimNickname(getWebDriver());
    }

    public void setMySettingsSimNickname(MySettingsSimNickname mySettingssimNickname)
    {
        this.mySettingsSimNickname = mySettingssimNickname;
    }

    public MySettingsPlanSettings getMySettingsPlanSettings()
    {
        return new MySettingsPlanSettings(getWebDriver());
    }

    public void setPlanSettings(MySettingsPlanSettings mySettingsPlanSettings)
    {
        this.mySettingsPlanSettings = mySettingsPlanSettings;
    }
    
    public MySettingsRechargePin getMySettingsRechargePin()
    {
        return new MySettingsRechargePin(getWebDriver());
    }

    public void setMySettingsRechargePin(MySettingsRechargePin mySettingsRechargePin)
    {
        this.mySettingsRechargePin = mySettingsRechargePin;
    }

    @Override
    public String getPageId() {
        return "/my-account/my-amaysim/settings";
    }

    public MySettingsPukCode getMySettingsPukCode()
    {
        return new MySettingsPukCode(getWebDriver());
    }

    public void setMySettingsPukCode(MySettingsPukCode mySettingsPukCode)
    {
        this.mySettingsPukCode = mySettingsPukCode;
    }

    public MySettingsCheckboxes getMySettingsCheckboxes()
    {
        return new MySettingsCheckboxes(getWebDriver());
    }

    public void setMySettingsCheckboxes(MySettingsCheckboxes mySettingsCheckboxes)
    {
        this.mySettingsCheckboxes = mySettingsCheckboxes;
    }

    public MySettingsCallForwarding getMySettingsCallForwarding()
    {
        return new MySettingsCallForwarding(getWebDriver());
    }

    public void setMySettingsCallForwarding(MySettingsCallForwarding mySettingsCallForwarding)
    {
        this.mySettingsCallForwarding = mySettingsCallForwarding;
    }

    public MySettingsPremiumSmsLimit getMySettingsPremiumSmsLimit()
    {
        return new MySettingsPremiumSmsLimit(getWebDriver());
    }

    public void setMySettingsPremiumSmsLimit(MySettingsPremiumSmsLimit mySettingsPremiumSmsLimit)
    {
        this.mySettingsPremiumSmsLimit = mySettingsPremiumSmsLimit;
    }

    public MySettingsAutoRecharge getMySettingsAutoRecharge()
    {
        return new MySettingsAutoRecharge(getWebDriver());
    }

    public void setMySettingsAutoRecharge(MySettingsAutoRecharge mySettingsAutoRecharge)
    {
        this.mySettingsAutoRecharge = mySettingsAutoRecharge;
    }

}
