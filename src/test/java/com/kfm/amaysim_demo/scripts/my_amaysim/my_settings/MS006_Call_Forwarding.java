package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsCallForwarding;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS006_Call_Forwarding extends BaseTest {

    private MySettingsCallForwarding mySettingsCallForwarding;
    private boolean isNoRadioButtonSelected;
    
    @Given("^that the user wants to check out his Call Forwarding in My Settings menu$")
    public void thatTheUserWantsToCheckOutHisCallForwardingInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenuViaJavascript());
        mySettingsPage.validatePage();
        mySettingsCallForwarding = mySettingsPage.getMySettingsCallForwarding();
    }

    @When("^the user clicks on the edit call forwarding button$")
    public void theUserClicksOnTheEditCallForwardingButton() {
        String forwardCalls = mySettingsCallForwarding.getCallForwardingText();
        if(forwardCalls.equals("No")) {
            isNoRadioButtonSelected = true;
        }
        else {
            isNoRadioButtonSelected = false;
        }

        mySettingsCallForwarding.clickEditLinkText();
    }

    @When("^clicks on confirm in the confirmation screen$")
    public void clicksOnConfirmInTheConfirmationScreen() {
        mySettingsCallForwarding.clickConfirmButton();
        
    }

    @When("^changes Forward Calls To to \"([^\"]*)\"$")
    public void changesForwardCallsToTo(String forwardCalls) {
        if(forwardCalls.equals("null")) {
            forwardCalls = "";
        }

        mySettingsCallForwarding.typeForwardCallsToTextField(forwardCalls);
    }

    @When("^clicks on save button$")
    public void clicksOnSaveButton() {
        mySettingsCallForwarding.clickSaveButton();
    }

    @Then("^there should be a successful message screen$")
    public void thereShouldBeASuccessfulMessageScreen() {
        mySettingsCallForwarding.clickCloseSuccessMessage();
    }

    @Then("^the Forward Calls To should be updated to \"([^\"]*)\"$")
    public void theForwardCallsToShouldBeUpdatedTo(String forwardCalls) {
        if(forwardCalls.equals("null")) {
            forwardCalls = "";
        }

        assertEquals("Forward calls to " + forwardCalls, mySettingsPage.getForwardingCallsTextValue());
    }
    
    @Then("^there should be an \"([^\"]*)\"$")
    public void thereShouldBeAn(String errorMessage) {
        if(errorMessage.equals("Please enter a valid Australian mobile number.")) {
            assertTrue(mySettingsCallForwarding.isForwardCallsToErrorMessageAvailable(errorMessage));
        }
        else {
            assertTrue(mySettingsCallForwarding.isFormatErrorMessageAvailable(errorMessage));
        }
    }

    @When("^clicks on the \"([^\"]*)\" radio button$")
    public void clicksOnTheRadioButton(String radioButton) {
        mySettingsCallForwarding.switchToDefaultContent();
        mySettingsCallForwarding.clickNoRadioButton();
    }

    @Then("^the Call Forwarding should be disabled$")
    public void theCallForwardingShouldBeDisabled() {
        assertEquals("No", mySettingsPage.getCallForwardingText());
    }
    
    @When("^clicks on cancel in the confirmation screen$")
    public void clicksOnCancelInTheConfirmationScreen() {
        mySettingsCallForwarding.clickConfirmationCancelButton();
    }

    @Then("^the user should be redirected to the My Settings page$")
    public void theUserShouldBeRedirectedToTheMySettingsPage() {
        mySettingsPage.validatePage();
    }
    
    @Then("^the radio button should be selected depending on the current settings$")
    public void theRadioButtonShouldBeSelectedDependingOnTheCurrentSettings() {
        assertEquals(isNoRadioButtonSelected, mySettingsCallForwarding.isNoRadioButtonSelected());
    }

}
