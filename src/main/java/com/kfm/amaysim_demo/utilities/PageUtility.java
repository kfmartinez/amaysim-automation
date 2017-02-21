package com.kfm.amaysim_demo.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.kfm.amaysim_demo.constants.Constants;
import com.kfm.amaysim_demo.exceptions.AutomationFrameworkException;

public class PageUtility {
    
    private static WebElement getWebElementViaFluentWait(WebDriver driver, final By by) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                                                                .pollingEvery(1, TimeUnit.SECONDS)
                                                                .ignoring(WebDriverException.class);
        
        WebElement webElement = wait.until(
            new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            }
        );

        return webElement;
    }
    
    public static void validatePage(WebDriver driver, By by, String pageId) throws AutomationFrameworkException {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        wait.until(ExpectedConditions.urlContains(pageId));
        assertEquals(driver, true, driver.getCurrentUrl().contains(pageId));
    }
    
    public static void click(WebDriver driver, By by) throws AutomationFrameworkException {
//        click(driver, by, 0, false);
        clickViaFluentWait(driver, by, false);
    }
    
    public static void clickViaJavascript(WebDriver driver, By by) throws AutomationFrameworkException {
//        click(driver, by, 0, true);
        clickViaFluentWait(driver, by, true);
    }
    
    private static void click(WebDriver driver, By by, int counter, boolean isClickViaJavascript) throws AutomationFrameworkException {
        String errorMessage = "";
        int max = 100;
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element;
        
        if(isClickViaJavascript) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else {
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        
        if(counter < max) {
            try {

                if(isClickViaJavascript) {
                    jse.executeScript("arguments[0].click();", element);
                }
                else {
                    element.click();
                }
            }
            catch(WebDriverException e)
            {
                errorMessage = "Cannot click WebElement!\n" + e.getMessage();
                sleep(20);
                click(driver, by, counter++, isClickViaJavascript);
            }
        }
        else
        {
            throw new AutomationFrameworkException(errorMessage);
        }
    }
    
    private static void clickViaFluentWait(WebDriver driver, By by, boolean isClickViaJavascript) {
        WebElement element = getWebElementViaFluentWait(driver, by);
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        
        if(isClickViaJavascript) {
            jse.executeScript("arguments[0].click();", element);
        }
        else {
            element.click();
        }
    }
    
    private static void sleep(int timeout)
    {
        try
        {
            Thread.sleep(timeout);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void type(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
    }
    
    public static void tickCheckBox(WebDriver driver, By by) throws AutomationFrameworkException {
        if(!isSelected(driver, by)) {
            click(driver, by, 0, true);
        }
    }
    
    public static void untickCheckBox(WebDriver driver, By by) throws AutomationFrameworkException {
        if(isSelected(driver, by)) {
            click(driver, by, 0, true);
        }
    }
    
    public static String getWebElementText(WebDriver driver, By by)
            throws AutomationFrameworkException {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element.getText();
    }
    
    public static void selectByVisibleText(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static boolean isSelected(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element.isSelected();
    }
    
    public static boolean isFieldAvailable(WebDriver driver, By by) {
        List<WebElement> webElementList = new ArrayList<WebElement>();
        webElementList = driver.findElements(by);
        
        if(webElementList == null || webElementList.isEmpty())
        {
            return false;
        }
        
        return true;
    }
    
    public static boolean isDisplayed(WebDriver driver, By by) {
        
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement element = null;
        
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            return element.isDisplayed();
        }
        catch(WebDriverException e) {
            return false;
        }
    }

    public static void assertEquals(WebDriver driver, boolean expected, boolean actual)
            throws AutomationFrameworkException {
        boolean result = expected == actual;

        if (!result) {
            throw new AutomationFrameworkException(
                    "Expected: [" + expected + "] is not equal to Actual: [" + actual + "]");
        }
    }

    public static void assertEquals(WebDriver driver, String expected, String actual) throws AutomationFrameworkException {
        boolean result = expected.equals(actual);

        if (!result) {
            throw new AutomationFrameworkException(
                    "Expected: [" + expected + "] is not equal to Actual: [" + actual + "]");
        }
    }
    
    public static void switchTo(WebDriver driver, By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.switchTo().frame(webElement);
    }
    
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    
}
