package com.kfm.amaysim_demo.pages.sydney_testers.car_insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.sydney_testers.SydneyTestersHomePage;
import com.kfm.amaysim_demo.pages.sydney_testers.quote_result.QuoteResultPage;

public class CarInsuranceQuotePage extends SydneyTestersHomePage {
    
    private By makeDropdown;
    private By yearTextField;
    private By driversAgeTextField;
    private By driversGenderMaleRadioButton;
    private By driversGenderFemaleRadioButton;
    private By stateDropdown;
    private By emailTextField;
    private By getQuoteButton;
    
    public CarInsuranceQuotePage(WebDriver driver) {
        super(driver);
        
        makeDropdown = By.id("make");
        yearTextField = By.id("year");
        driversAgeTextField = By.id("age");
        driversGenderMaleRadioButton = By.id("male");
        driversGenderFemaleRadioButton = By.id("female");
        stateDropdown = By.id("state");
        emailTextField = By.id("email");
        getQuoteButton = By.id("getquote");
    }
    
    public CarInsuranceQuotePage selectMakeDropdown(String make) {
        selectDropdownByVisibleText(makeDropdown, make);
        return this;
    }
    
    public CarInsuranceQuotePage typeYearTextField(String year) {
        type(yearTextField, year);
        return this;
    }
    
    public CarInsuranceQuotePage typeDriversAgeTextField(String age) {
        type(driversAgeTextField, age);
        return this;
    }
    
    public CarInsuranceQuotePage tickDriversGenderMaleRadioButton() {
        click(driversGenderMaleRadioButton);
        return this;
    }
    
    public CarInsuranceQuotePage tickDriversGenderFemaleRadioButton() {
        click(driversGenderFemaleRadioButton);
        return this;
    }
    
    public CarInsuranceQuotePage selectStateDropdown(String state) {
        selectDropdownByVisibleText(stateDropdown, state);
        return this;
    }
    
    public CarInsuranceQuotePage typeEmailTextField(String email) {
        type(emailTextField, email);
        return this;
    }
    
    public QuoteResultPage clickGetQuoteButton() {
        click(getQuoteButton);
        return new QuoteResultPage(getWebDriver());
    }
    
}
