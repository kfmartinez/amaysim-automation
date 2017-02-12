package com.kfm.amaysim_demo.pages.my_amaysim.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.base.Page;
import com.kfm.amaysim_demo.pages.my_amaysim.home.MyAmaysimHomePage;

public class MyAmaysimLoginPage extends Page {

    private By amaysimNumberTextField;
    private By passwordTextField;
    private By showPasswordCheckbox;
    private By loginButton;
    
    public MyAmaysimLoginPage(WebDriver driver) {
        super(driver);
        
        amaysimNumberTextField = By.id("mobile_number");
        passwordTextField = By.id("password");
        showPasswordCheckbox = By.id("show_password");
        loginButton = By.xpath("//input[@value='Login']");
    }

    public MyAmaysimLoginPage typeAmaysimNumber(String amaysimNumber) {
        type(amaysimNumberTextField, amaysimNumber);
        return this;
    }
 
    public MyAmaysimLoginPage typePassword(String password) {
        type(passwordTextField, password);
        return this;
    }
    
    public MyAmaysimLoginPage tickShowPasswordCheckbox() {
        click(showPasswordCheckbox);
        return this;
    }
    
    public MyAmaysimHomePage clickLogInButton() {
        click(loginButton);
        return new MyAmaysimHomePage(getWebDriver());
    }

    @Override
    public By getHtmlBody()
    {
        return By.xpath("//body");
    }
    
    @Override
    public String getPageId()
    {
        return "/identity/login";
    }

}
