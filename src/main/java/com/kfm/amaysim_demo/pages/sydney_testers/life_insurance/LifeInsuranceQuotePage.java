package com.kfm.amaysim_demo.pages.sydney_testers.life_insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.sydney_testers.SydneyTestersHomePage;
import com.kfm.amaysim_demo.pages.sydney_testers.quote_result.QuoteResultPage;

public class LifeInsuranceQuotePage extends SydneyTestersHomePage {
    
    private By ageTextField;
    private By genderMaleRadioButton;
    private By genderFemaleRadioButton;
    private By occupationCategoryDropdown;
    private By stateDropdown;
    private By emailTextField;
    private By getQuoteButton;
    
    public LifeInsuranceQuotePage(WebDriver driver) {
        super(driver);
        
        ageTextField = By.id("age");
        genderMaleRadioButton = By.id("male");
        genderFemaleRadioButton = By.id("female");
        occupationCategoryDropdown = By.id("occupation");
        stateDropdown = By.id("state");
        emailTextField = By.id("email");
        getQuoteButton = By.id("getquote");
    }
    
    public LifeInsuranceQuotePage typeAgeTextField(String age) {
        type(ageTextField, age);
        return this;
    }
    
    public LifeInsuranceQuotePage clickGenderMaleRadioButton() {
        click(genderMaleRadioButton);
        return this;
    }
    
    public LifeInsuranceQuotePage clickFemaleRadioButton() {
        click(genderFemaleRadioButton);
        return this;
    }
    
    public LifeInsuranceQuotePage selectOccupationCategoryDropdown(String occupation) {
        selectDropdownByVisibleText(occupationCategoryDropdown, occupation);
        return this;
    }
    
    public LifeInsuranceQuotePage selectStateDropdown(String state) {
        selectDropdownByVisibleText(stateDropdown, state);
        return this;
    }
    
    public LifeInsuranceQuotePage typeEmailTextField(String email) {
        type(emailTextField, email);
        return this;
    }
    
    public QuoteResultPage clickGetQuoteButton() {
        click(getQuoteButton);
        return new QuoteResultPage(getWebDriver());
    }
    
}
