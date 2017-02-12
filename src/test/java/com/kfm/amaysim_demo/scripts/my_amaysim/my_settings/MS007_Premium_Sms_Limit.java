package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPremiumSmsLimit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS007_Premium_Sms_Limit extends BaseTest {

    private MySettingsPremiumSmsLimit mySettingsPremiumSmsLimit;

    @Given("^that the user wants to check out his Premium SMS Limit in My Settings menu$")
    public void thatTheUserWantsToCheckOutHisPremiumSMSLimitInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        mySettingsPage.validatePage();
        mySettingsPremiumSmsLimit = mySettingsPage.getMySettingsPremiumSmsLimit();
    }

    @When("^clicks on edit Premium SMS Limit$")
    public void clicksOnEditPremiumSMSLimit() {
        mySettingsPremiumSmsLimit.clickEditLinkText();
    }

    @When("^the user changes his/her PremiumSMS limit to \"([^\"]*)\"$")
    public void theUserChangesHisHerPremiumSMSLimitTo(String limit) {
        mySettingsPremiumSmsLimit.selectLimitDropdown(limit);
        mySettingsPremiumSmsLimit.clickSaveButton();
    }

    @Then("^the user should see the \"([^\"]*)\" has been updated$")
    public void theUserShouldSeeTheHasBeenUpdated(String limit) {
        if(limit.equals("OFF")) {
            limit = "No";
        }
        assertEquals(limit, mySettingsPage.getPremiumSMSLimitText());
    }


    @When("^clicks on the cancel button$")
    public void clicksOnTheCancelButton() {
        mySettingsPremiumSmsLimit.clickCancelButton();
    }

    @Then("^the user should be redirected to the My Settings menu page$")
    public void theUserShouldBeRedirectedToTheMySettingsMenuPage() {
        mySettingsPage.validatePage();
    }

}
