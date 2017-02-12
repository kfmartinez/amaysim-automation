package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPukCode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS004_Puk_Code extends BaseTest {
    
    private MySettingsPukCode mySettingsPukCode;
    
    @Given("^that the user wants to checkout his PUK Code$")
    public void thatTheUserWantsToCheckoutHisPUKCode() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        mySettingsPage.validatePage();
    }

    @When("^the user goes to PUK Code My Settings menu$")
    public void theUserGoesToPUKCodeMySettingsMenu() {
        mySettingsPukCode = mySettingsPage.getMySettingsPukCode();
    }

    @Then("^the user should visibly view the PUK Code$")
    public void theUserShouldVisiblyViewThePUKCode() {
        assertFalse(mySettingsPukCode.getPukCodeText().equals(""));
    }
    
}
