package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_payments.MyPaymentsPage;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPage;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsRechargePin;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS003_Recharge_Pin extends BaseTest{

    private String oldRechargePin;
    private MySettingsRechargePin mySettingsRechargePin;
    private MyPaymentsPage myPaymentsPage;
    
    @Given("^that the user wants to checkout his Recharge PIN in My Settings menu$")
    public void thatTheUserWantsToCheckoutHisRechargePINInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        oldRechargePin = mySettingsPage.getRechargePINText();
        mySettingsPage.validatePage();
        mySettingsRechargePin = mySettingsPage.getMySettingsRechargePin();
    }

    @When("^the user clicks on edit Recharge PIN$")
    public void theUserClicksOnEditRechargePIN() {
        mySettingsRechargePin.clickEditLinkText();
    }

    @When("^changes to \"([^\"]*)\"$")
    public void changesTo(String rechargePin) {
        if(rechargePin.equals("null")) {
            rechargePin = "";
        }

        mySettingsRechargePin.typeRechargePinTextField(rechargePin);
    }

    @When("^clicks on the recharge pin save button$")
    public void clicksOnTheRechargePinSaveButton() {
        mySettingsRechargePin.clickSaveButton();
    }

    @Then("^the old recharge pin should be change to the \"([^\"]*)\"$")
    public void theOldRechargePinShouldBeChangeToThe(String rechargePin) {
        assertEquals(rechargePin, mySettingsPage.getRechargePINText());
    }
    
    @Then("^there should be an recharge pin error message stating \"([^\"]*)\"$")
    public void thereShouldBeAnErrorMessageStating(String errorMessage) {
        assertTrue(mySettingsPage.isRechargePINErrorMessageAvailable(errorMessage));
        assertFalse(mySettingsRechargePin.isEditLinkTextDisplayed());
    }
    
    @When("^goes to \"([^\"]*)\" menu page$")
    public void goesToMenuPage(String menu) {
        myPaymentsPage = mySettingsRechargePin.clickMyPaymentsMenu();
        myPaymentsPage.validatePage();
    }

    @When("^goes back to \"([^\"]*)\" menu page$")
    public void goesBackToMenuPage(String menu) {
        MySettingsPage mySettingsPage = myPaymentsPage.clickMySettingsMenu();
        mySettingsPage.validatePage();
    }

    @Then("^the \"([^\"]*)\" is still the recharge pin entered earlier$")
    public void theIsStillTheRechargePinEnteredEarlier(String rechargePin) {
        if(rechargePin.equals("null")) {
            rechargePin = "";
        }
        
        assertEquals(rechargePin, mySettingsPage.getRechargePINText());
    }    
    
    @When("^clicks on the recharge pin cancel button$")
    public void clicksOnTheRechargePinCancelButton() {
        mySettingsRechargePin = mySettingsPage.getMySettingsRechargePin();
        mySettingsRechargePin.clickCancelButton();
    }

    @Then("^the old recharge should be retained$")
    public void theOldRechargeShouldBeRetained() {
        assertEquals(oldRechargePin, mySettingsPage.getRechargePINText());
    }
    
}
