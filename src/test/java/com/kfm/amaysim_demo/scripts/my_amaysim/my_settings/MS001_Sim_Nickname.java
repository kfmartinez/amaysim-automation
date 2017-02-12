package com.kfm.amaysim_demo.scripts.my_amaysim.my_settings;

import com.kfm.amaysim_demo.base.BaseTest;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsSimNickname;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MS001_Sim_Nickname extends BaseTest {
    
    private String oldSimNickname;
    private MySettingsSimNickname mySettingsSimNickname;

    @Given("^that the user wants to checkout his SIM Nickname in My Settings menu$")
    public void thatTheUserWantsToCheckoutHisSIMNicknameInMySettingsMenu() {
        setMySettingsPage(myAmaysimHomePage.clickMySettingsMenu());
        oldSimNickname = mySettingsPage.getSimNicknameText();
        mySettingsPage.validatePage();
        mySettingsSimNickname = mySettingsPage.getMySettingsSimNickname();
    }

    @When("^the user clicks on edit SIM Nickname$")
    public void theUserClicksOnEditSIMNickname() {
       
        mySettingsSimNickname.clickEditLinkText();
    }

    @When("^changes the sim nickname value to \"([^\"]*)\"$")
    public void changesTheValueTo(String newSimNickname) {
        if(newSimNickname.equals("null")){
            newSimNickname = "";
        }

        mySettingsSimNickname.typeSimNicknameTextField(newSimNickname);
    }

    @When("^clicks on the sim nickname save button$")
    public void clicksOnTheSaveButton() throws Throwable {
        mySettingsSimNickname.clickSaveButton();
    }

    @Then("^the old sim nickname should be changed to the \"([^\"]*)\"$")
    public void theOldSimNicknameShouldBeChangedToThe(String simNickname) {
        assertEquals(simNickname, mySettingsPage.getSimNicknameText());
    }
    
    @Then("^there should be an sim nickname error message stating \"([^\"]*)\"$")
    public void thereShouldBeAnErrorMessageStating(String errorMessage) {
        assertTrue(mySettingsPage.isSimNicknameErrorMessageAvailable(errorMessage));
        assertFalse(mySettingsSimNickname.isEditLinkTextDisplayed());
    }
    
    @When("^clicks on the sim nickname cancel button$")
    public void clicksOnTheCancelButton() {
        mySettingsSimNickname.clickCancelButton();
    }

    @Then("^the old nickname should be retained$")
    public void theOldNicknameShouldBeRetained() {
        assertEquals(oldSimNickname, mySettingsPage.getSimNicknameText());
    }

}
