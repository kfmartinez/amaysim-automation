package com.kfm.amaysim_demo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.exceptions.AutomationFrameworkException;

public final class VerificationUtility {
    
    private VerificationUtility() {

    }
    
    public static void validatePage(WebDriver driver, By by, String pageId) {
        try {
            PageUtility.validatePage(driver, by, pageId);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }
    public static void type(WebDriver driver, By by, String text) {
        PageUtility.type(driver, by, text);
    }
    
    public static void click(WebDriver driver, By by) {
        try
        {
            PageUtility.click(driver, by);
        }
        catch (AutomationFrameworkException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void clickViaJavaScript(WebDriver driver, By by) {
        try {
            PageUtility.clickViaJavascript(driver, by);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }

    public static String getWebElementText(WebDriver driver, By by) {
        try {
            return PageUtility.getWebElementText(driver, by);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
        
        return "";
    }
    
    public static boolean isSelected(WebDriver driver, By by) {
        return PageUtility.isSelected(driver, by);
    }
    
    public static boolean isDisplayed(WebDriver driver, By by) {
        return PageUtility.isDisplayed(driver, by);
    }
    
    public static void selectByVisibleText(WebDriver driver, By by, String text) {
        PageUtility.selectByVisibleText(driver, by, text);
    }

    public static boolean isFieldAvailable(WebDriver driver, By by) {
        return PageUtility.isFieldAvailable(driver, by);
    }

    public static void assertEquals(WebDriver driver, boolean expected, boolean actual) {
        try {
            PageUtility.assertEquals(driver, expected, actual);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }

    public static void assertEquals(WebDriver driver, String expected, String actual) {
        try {
            PageUtility.assertEquals(driver, expected, actual);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }

    public static void switchTo(WebDriver driver, By by) {
        PageUtility.switchTo(driver, by);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        PageUtility.switchToDefaultContent(driver);
    }
    
    public static void tickCheckbox(WebDriver driver, By by) {
        try {
            PageUtility.tickCheckBox(driver, by);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }
    
    public static void untickCheckbox(WebDriver driver, By by) {
        try {
            PageUtility.untickCheckBox(driver, by);
        }
        catch (AutomationFrameworkException e) {
            e.printStackTrace();
        }
    }
}
