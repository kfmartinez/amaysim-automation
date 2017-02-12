package com.kfm.amaysim_demo.pages.sydney_testers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.base.Page;
import com.kfm.amaysim_demo.pages.sydney_testers.car_insurance.CarInsuranceQuotePage;
import com.kfm.amaysim_demo.pages.sydney_testers.life_insurance.LifeInsuranceQuotePage;

public class SydneyTestersHomePage extends Page {
    
    private By getCarInsuranceQuoteButton;
    private By getLifeInsuranceQuoteButton;
    
    public SydneyTestersHomePage(WebDriver driver) {
        super(driver);
        
        getCarInsuranceQuoteButton = By.id("getcarquote");
        getLifeInsuranceQuoteButton = By.id("getlifequote");
    }

    public CarInsuranceQuotePage clickCarInsuranceQuoteButton() {
        click(getCarInsuranceQuoteButton);
        return new CarInsuranceQuotePage(getWebDriver());
    }
    
    public LifeInsuranceQuotePage clickLifeInsuranceQuoteButton() {
        click(getLifeInsuranceQuoteButton);
        return new LifeInsuranceQuotePage(getWebDriver());
    }

    @Override
    public By getHtmlBody()
    {
        return null;
    }
    
    @Override
    public String getPageId()
    {
        return null;
    }
    
}
