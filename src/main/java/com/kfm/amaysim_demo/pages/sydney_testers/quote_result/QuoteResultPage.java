package com.kfm.amaysim_demo.pages.sydney_testers.quote_result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.sydney_testers.SydneyTestersHomePage;
import com.kfm.amaysim_demo.pages.sydney_testers.credit_card_form.CreditCardFormPage;

public class QuoteResultPage extends SydneyTestersHomePage {
    
    private By buyInsuranceButton;
    
    public QuoteResultPage(WebDriver driver) {
        super(driver);
        
        buyInsuranceButton = By.id("payment");
    }
    
    public CreditCardFormPage clickBuyInsuranceButton() {
        click(buyInsuranceButton);
        return new CreditCardFormPage(getWebDriver());
    }
    
}
