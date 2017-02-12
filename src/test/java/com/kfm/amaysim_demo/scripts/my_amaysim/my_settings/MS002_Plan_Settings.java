package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_payments.MyPaymentsPage;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPlanSettings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS002_Plan_Settings extends BaseTest {
    
    private MySettingsPlanSettings mySettingsPlanSettings;
    private MyPaymentsPage myPaymentsPage;
    
    @Given("^that the user wants to check out his Plan Settings in My Settings menu$")
    public void thatTheUserWantsToCheckOutHisPlanSettingsInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        mySettingsPage.validatePage();
        mySettingsPlanSettings = mySettingsPage.getMySettingsPlanSettings();
    }

    @When("^the user clicks on \"([^\"]*)\" in the Payment Type$")
    public void theUserClicksOnInThePaymentType(String paymentType) {
        myPaymentsPage = mySettingsPlanSettings.clickPaymentTypeLinkText();
    }

    @Then("^the user is redirected to \"([^\"]*)\" menu page$")
    public void theUserIsRedirectedToMenuPage(String page) {
        myPaymentsPage.validatePage();
    }
    
}
