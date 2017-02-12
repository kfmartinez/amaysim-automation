package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsCheckboxes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS005_Checkboxes extends BaseTest {
    
    private MySettingsCheckboxes mySettingsCheckboxes;
    
    @Given("^that the user wants to checkout his/her Call Waiting in My Settings menu$")
    public void thatTheUserWantsToCheckoutHisHerCallWaitingInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenuViaJavascript());
        mySettingsPage.validatePage();
        mySettingsCheckboxes = mySettingsPage.getMySettingsCheckboxes();
    }

    @When("^the user tries to change the edit caller id button, depending on its current state, if selected$")
    public void theUserTriesToChangeTheEditCallerIdButtonDependingOnItsCurrentStateIfSelected() throws InterruptedException {
        mySettingsCheckboxes.tickCallerIdCheckbox();
        mySettingsCheckboxes.untickCallerIdCheckbox();
    }

    @When("^the user tries to change the edit call waiting button, depending on its current state, if selected$")
    public void theUserTriesToChangeTheEditCallWaitingButtonDependingOnItsCurrentStateIfSelected() throws InterruptedException {
        mySettingsCheckboxes.tickCallerWaitingCheckbox();
        mySettingsCheckboxes.untickCallerWaitingCheckbox();
    }

    @When("^the user tries to change the edit voice mail button, depending on its current state, if selected$")
    public void theUserTriesToChangeTheEditVoiceMailButtonDependingOnItsCurrentStateIfSelected() throws InterruptedException {
        mySettingsCheckboxes.tickVoiceMailCheckbox();
        mySettingsCheckboxes.untickVoiceMailCheckbox();
    }

    @Then("^there will be a success message stating \"([^\"]*)\"$")
    public void thereWillBeASuccessMessageStating(String successMessage) throws InterruptedException {
        assertTrue(mySettingsCheckboxes.isSuccessMessageDisplayed(successMessage));
        Thread.sleep(3000);
        mySettingsCheckboxes.clickCloseSuccessMessageButton();
    }
    
}
