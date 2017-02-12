package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.my_amaysim.home.my_payments.MyPaymentsPage;

public class MySettingsPlanSettings extends MySettingsPage {

    private By paymentTypeLinkText;
    
    public MySettingsPlanSettings(WebDriver driver) {
        super(driver);
        paymentTypeLinkText = By.xpath("//a[@href='/my-account/my-amaysim/payment_methods']");
    }
    
    public MyPaymentsPage clickPaymentTypeLinkText() {
        click(paymentTypeLinkText);
        return new MyPaymentsPage(getWebDriver());
    }
    
    @Override
    public String getPageId() {
        return null;
    }

}
