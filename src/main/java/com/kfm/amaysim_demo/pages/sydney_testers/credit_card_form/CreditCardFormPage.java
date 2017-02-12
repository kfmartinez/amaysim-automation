package com.kfm.amaysim_demo.pages.sydney_testers.credit_card_form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.sydney_testers.credit_card_form.pay_now.PayNowPage;
import com.kfm.amaysim_demo.pages.sydney_testers.quote_result.QuoteResultPage;

public class CreditCardFormPage extends QuoteResultPage {

    private By nameOnCardTextField;
    private By emailOrUsernameTextField;
    private By passwordTextField;
    private By cardNumberTextField;
    private By expiryDateDropdownMonth;
    private By expiryDateDropdownYear;
    private By cardCVVTextField;
    private By payNowButton;

    public CreditCardFormPage(WebDriver driver) {
        super(driver);

        nameOnCardTextField = By.id("cardholdername");
        emailOrUsernameTextField = By.id("username");
        passwordTextField = By.id("password");
        cardNumberTextField = By.id("card-number");
        expiryDateDropdownMonth = By.id("expiry-month");
        //take note it doesn't have an id
        expiryDateDropdownYear = By.xpath("//select[@id='expiry-month']/parent::div/following-sibling::div/select");
        cardCVVTextField = By.id("cvv");
        payNowButton = By.id("pay");
    }

    public CreditCardFormPage typeNameOnCardTextField(String name) {
        type(nameOnCardTextField, name);
        return this;
    }
    
    public CreditCardFormPage typeEmailOrUsernameTextField(String emailOrUsername) {
        type(emailOrUsernameTextField, emailOrUsername);
        return this;
    }
    
    public CreditCardFormPage typePasswordTextField(String password) {
        type(passwordTextField, password);
        return this;
    }
    
    public CreditCardFormPage typeCardNumberTextField(String cardNumber) {
        type(cardNumberTextField, cardNumber);
        return this;
    }
    
    public CreditCardFormPage selectExpiryDateDropdownMonth(String month) {
        selectDropdownByVisibleText(expiryDateDropdownMonth, month);
        return this;
    }
    
    public CreditCardFormPage selectExpiryDateDropdownYear(String year) {
        selectDropdownByVisibleText(expiryDateDropdownYear, year);
        return this;
    }
    
    public CreditCardFormPage typeCardCVVTextField(String cardCVV) {
        type(cardCVVTextField, cardCVV);
        return this;
    }
    
    public PayNowPage clickPayNowbutton() {
        click(payNowButton);
        return new PayNowPage(getWebDriver());
    }
    
}
