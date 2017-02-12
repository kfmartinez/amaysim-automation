package com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySettingsPukCode extends MySettingsPage {

    private By pukCodeText;
    
    public MySettingsPukCode(WebDriver driver) {
        super(driver);
        
        pukCodeText = By.xpath("//div[text()='PUK code']/following-sibling::div");
    }

    public String getPukCodeText() {
        return getWebElementText(pukCodeText);
    }
    
}
