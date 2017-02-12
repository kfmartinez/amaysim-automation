package com.kfm.amaysim_demo.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.utilities.VerificationUtility;

public abstract class Page {

    private WebDriver driver;
    
    public Page(WebDriver driver) {
        this.driver = driver;
    }
    
    public void goTo(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.MINUTES);
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }
    
    public void click(By by) {
        VerificationUtility.click(driver, by);
    }
    
    public void clickViaJavaScript(By by) {
        VerificationUtility.clickViaJavaScript(driver, by);
    }
    
    public void type(By by, String text) {
        VerificationUtility.type(driver, by, text);
    }
    
    public void tickCheckbox(By by) {
        VerificationUtility.tickCheckbox(driver, by);
    }
    
    public void untickCheckbox(By by) {
        VerificationUtility.untickCheckbox(driver, by);
    }
    
    public String getWebElementText(By by) {
       return VerificationUtility.getWebElementText(driver, by);
    }
    
    public void selectDropdownByVisibleText(By by, String text) {
        VerificationUtility.selectByVisibleText(driver, by, text);
    }

    public void assertEquals(boolean expected, boolean actual) {
        VerificationUtility.assertEquals(driver, expected, actual);
    }

    public void assertEquals(String expected, String actual) {
        VerificationUtility.assertEquals(driver, expected, actual);
    }

    public void assertTrue(boolean actual) {
        VerificationUtility.assertEquals(driver, true, actual);
    }

    public void assertFalse(boolean actual) {
        VerificationUtility.assertEquals(driver, false, actual);
    }
    
    public WebDriver getWebDriver() {
        return driver;
    }

    public void switchToFrame(By by) {
        VerificationUtility.switchTo(driver, by);
    }
    
    public void switchToDefaultContent() {
        VerificationUtility.switchToDefaultContent(driver);
    }
    
    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isSelected(By by) {
        return VerificationUtility.isSelected(driver, by);
    }
    
    public boolean isDisplayed(By by) {
        return VerificationUtility.isDisplayed(driver, by);
    }
    
    public boolean isFieldAvailable(By by) {
        return VerificationUtility.isFieldAvailable(driver, by);
    }
    
    public void clickEscButton() {
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
        ( ( JavascriptExecutor ) driver )
        .executeScript( "window.onbeforeunload = function(e){};" );
    }
    
    public abstract By getHtmlBody();
    public abstract String getPageId();
    
    public void validatePage() {
        VerificationUtility.validatePage(driver, getHtmlBody(), getPageId());
    }
}
