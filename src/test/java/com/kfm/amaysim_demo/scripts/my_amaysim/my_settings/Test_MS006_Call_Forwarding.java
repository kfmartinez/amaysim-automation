package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.MyAmaysimHomePage;
import com.kfm.amaysim_demo.pages.my_amaysim.login.MyAmaysimLoginPage;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@CucumberOptions(
    glue = "com.kfm.amaysim_demo.scripts.my_amaysim.my_settings",
    features =  "src/test/resources/cucumber/my_amaysim/my_settings",
    tags = "@ms006",
    plugin =
    {
        "pretty",
        "html:target/CucumberHTMLReport/my_amaysim/my_settings",
        "json:target/CucumberHTMLReport/my_amaysim/my_settings/cucumber-report.json"
    },
    snippets = SnippetType.CAMELCASE)
public class Test_MS006_Call_Forwarding extends BaseTest { 

    private MyAmaysimLoginPage myAmaysimLoginPage;
    private MyAmaysimHomePage myAmaysimHomePage;
    
    @BeforeSuite
    public void setup() {
        
        initialize();
        myAmaysimLoginPage = new MyAmaysimLoginPage(getWebDriver());
        myAmaysimLoginPage.goTo(getTestRequirements().getUrl());
        myAmaysimLoginPage.validatePage();
        myAmaysimLoginPage.typeAmaysimNumber(getTestRequirements().getUsername());
        myAmaysimLoginPage.typePassword(getTestRequirements().getPassword());
        myAmaysimHomePage = myAmaysimLoginPage.clickLogInButton();
        setMyAmaysimHomePage(myAmaysimHomePage);
        myAmaysimHomePage.validatePage();
        myAmaysimHomePage.clickCloseActivateMySimButton();
    }
    
    @AfterSuite
    public void tearDown() {
        getWebDriver().quit();
    }

}
