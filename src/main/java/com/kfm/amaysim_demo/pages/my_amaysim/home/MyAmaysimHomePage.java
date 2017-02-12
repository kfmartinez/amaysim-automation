package com.kfm.amaysim_demo.pages.my_amaysim.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.base.Page;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_payments.MyPaymentsPage;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPage;

public class MyAmaysimHomePage extends Page {
    
    private By closeActivateMySimButton;
    private By mySettingsLinkText;
    private By myPaymentsLinkText;
    private By iFrame;
    
    public MyAmaysimHomePage(WebDriver driver) {
        super(driver);
        
        closeActivateMySimButton = By.xpath("//h1[text()='Welcome to My amaysim']/following-sibling::a[text()='×']");
        mySettingsLinkText = By.xpath("//span[contains(text(), 'My Settings')]/parent::a");
        myPaymentsLinkText = By.xpath("//span[contains(text(), 'My Payments')]/parent::a");
        iFrame = By.id("rufous-sandbox");
    }
    
    public void switchToIFrame() {
        switchToFrame(iFrame);
    }
    
    public MyAmaysimHomePage clickCloseActivateMySimButton() {
        click(closeActivateMySimButton);
        return this;
    }
    
    public MySettingsPage clickMySettingsMenu() {
        click(mySettingsLinkText);
        return new MySettingsPage(getWebDriver());
    }
    
    public MySettingsPage clickMySettingsMenuViaJavascript() {
        clickViaJavaScript(mySettingsLinkText);
        return new MySettingsPage(getWebDriver());
    }

    public MyPaymentsPage clickMyPaymentsMenu() {
        click(myPaymentsLinkText);
        return new MyPaymentsPage(getWebDriver());
    }
    
    @Override
    public By getHtmlBody()
    {
        return By.xpath("//body[@class='logged-in-customer']");
    }

    @Override
    public String getPageId() {
        return "/my-account/my-amaysim/dashboards";
    }

}
