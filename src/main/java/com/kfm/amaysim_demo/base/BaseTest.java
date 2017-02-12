package com.kfm.amaysim_demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.kfm.amaysim_demo.constants.SupportedWebDrivers;
import com.kfm.amaysim_demo.drivers.WebDriverFactory;
import com.kfm.amaysim_demo.exceptions.AutomationFrameworkException;
import com.kfm.amaysim_demo.objects.TestRequirements;
import com.kfm.amaysim_demo.pages.my_amaysim.home.MyAmaysimHomePage;
import com.kfm.amaysim_demo.pages.my_amaysim.home.my_settings.MySettingsPage;
import com.kfm.amaysim_demo.utilities.VerificationUtility;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class BaseTest extends AbstractTestNGCucumberTests {

    private static TestRequirements testRequirements;

    private WebDriver driver;
    private SupportedWebDrivers browser;
    
    protected static MyAmaysimHomePage myAmaysimHomePage;
    protected static MySettingsPage mySettingsPage;
 
    public BaseTest() {
        this(TestRequirements.getInstance());
    }

    public BaseTest(TestRequirements testRequirements) {
        BaseTest.testRequirements = testRequirements;
    }
    
    public void setMyAmaysimHomePage(MyAmaysimHomePage myAmaysimHomePage) {
        BaseTest.myAmaysimHomePage = myAmaysimHomePage;
    }
    
    public MyAmaysimHomePage getMyAmaysimHomePage() {
        return myAmaysimHomePage;
    }
    
    public void setMySettingsPage(MySettingsPage mySettingsPage) {
        BaseTest.mySettingsPage = mySettingsPage;
    }
    
    public MySettingsPage getmySettingsPage() {
        return mySettingsPage;
    }
    
    @BeforeSuite(alwaysRun = true)
    @Parameters({"username", "password", "url", "browser"})
    public synchronized void setTestRequirements(
            @Optional("Username undefined") String username,
            @Optional("Password undefined") String password,
            @Optional("Url undefined") String url,
            @Optional("Browser undefined") String browser) throws AutomationFrameworkException {
        
        testRequirements.setUsername(username);
        testRequirements.setPassword(password);
        testRequirements.setUrl(url);
        testRequirements.setBrowser(SupportedWebDrivers.determineBrowser(browser));
    }

//    @BeforeTest(alwaysRun = true)
    public synchronized void initialize() {
        browser = testRequirements.getBrowser();
        driver = WebDriverFactory.getWebDriver(browser);
    }

    public void signIn() {
    }

    public synchronized void quit() {
        driver.quit();
    }

    public synchronized WebDriver getWebDriver() {
        return driver;
    }

    public synchronized void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public SupportedWebDrivers getBrowser() {
        return browser;
    }

    public void setBrowser(SupportedWebDrivers browser) {
        this.browser = browser;
    }

    protected String getCurrentDate(String format) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date).toUpperCase();
    }

    protected String getCurrentMonth() {
        return getCurrentDate("MMMM");
    }

    protected String getCurrentDay() {
        return getCurrentDate("dd");
    }

    protected String getCurrentYear() {
        return getCurrentDate("yyyy");
    }

    protected String getMonthAfterCurrent() {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(simpleDateFormat.parse(getCurrentMonth()));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.add(Calendar.MONTH, 1);

        return simpleDateFormat.format(calendar.getTime()).toUpperCase();
    }

    public TestRequirements getTestRequirements() {
        return testRequirements;
    }

    protected void assertTrue(boolean actual) {
        VerificationUtility.assertEquals(driver, true, actual);
    }

    protected void assertFalse(boolean actual) {
        VerificationUtility.assertEquals(driver, false, actual);
    }

    protected void assertEquals(boolean expected, boolean actual) {
        VerificationUtility.assertEquals(driver, expected, actual);
    }

    protected void assertEquals(String expected, String actual) {
        VerificationUtility.assertEquals(driver, expected, actual);
    }

}
