package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsAutoRecharge;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS008_Auto_Recharge extends BaseTest {
    
    private MySettingsAutoRecharge mySettingsAutoRecharge;
    private boolean isAutoRechargeTextStatusDisabled;

    @Given("^that the user wants to check out his Auto Recharge settings in My Settings menu$")
    public void thatTheUserWantsToCheckOutHisAutoRechargeSettingsInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        mySettingsPage.validatePage();
        mySettingsAutoRecharge = mySettingsPage.getMySettingsAutoRecharge();
    }

    @When("^the user clicks on edit Auto-Recharge$")
    public void theUserClicksOnEditAutoRecharge() {
        String status = mySettingsPage.getAutoRechargeTextStatus();
        if(status.equals("No")) {
            isAutoRechargeTextStatusDisabled = true;
        }
        else {
            isAutoRechargeTextStatusDisabled = false;
        }
            
        mySettingsAutoRecharge.clickEditLinkText();
    }

    @When("^the user changes \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserChangesAnd(String balance, String sim) {
        mySettingsAutoRecharge.clickYesRadioButton();
        mySettingsAutoRecharge.selectBalanceDropsDropdown(balance);
        mySettingsAutoRecharge.selectRechargeSimDropdown(sim);
        mySettingsAutoRecharge.clickSaveButton();
    }

    @Then("^the Auto-Recharge should be updated to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theAutoRechargeShouldBeUpdatedToAnd(String balance, String sim) {
        String text = "Recharge my mobile service with " + sim + " whenever the balance drops below " + balance;
        assertEquals(text, mySettingsAutoRecharge.getAutoRechargeText());
    }
    
    @When("^the user clicks on \"([^\"]*)\"$")
    public void theUserClicksOn(String no) {
        mySettingsAutoRecharge.clickNoRadioButton();
        mySettingsAutoRecharge.clickSaveButton();
    }

    @Then("^the Auto-Recharge should be disabled$")
    public void theAutoRechargeShouldBeDisabled() {
        assertEquals("No", mySettingsPage.getAutoRechargeTextStatus());
    }
    
    @Then("^the state should be whatever it is in\\. \\(if disabled, it should be on No, if not, then on Yes\\)$")
    public void theStateShouldBeWhateverItIsInIfDisabledItShouldBeOnNeIfNotThenOnYes() {
        assertEquals(isAutoRechargeTextStatusDisabled, mySettingsAutoRecharge.isNoRadioButtonSelected());
    }
    
    @When("^clicks on cancel button$")
    public void clicksOnCancelButton() {
        mySettingsAutoRecharge.clickCancelButton();
    }

    @Then("^the user should be redirected to My Settings menu$")
    public void theUserShouldBeRedirectedToMySettingsMenu() {
        mySettingsPage.validatePage();
    }
}
