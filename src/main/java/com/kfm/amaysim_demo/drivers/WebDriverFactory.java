package com.kfm.amaysim_demo.drivers;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.kfm.amaysim_demo.constants.SupportedWebDrivers;

public final class WebDriverFactory {
    
    private WebDriverFactory() {
        
    }

    public static WebDriver getWebDriver(SupportedWebDrivers webDriver) {
        switch (webDriver) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src" + File.separatorChar +
                    "test" + File.separatorChar + 
                    "resources" + File.separatorChar +
                    "drivers" + File.separatorChar + 
                    "chromedriver.exe");
                
//                System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                return new ChromeDriver();

            case FIREFOX:
                return new FirefoxDriver();

            case IE:
                return new InternetExplorerDriver();

            default:
                return null;
        }
    }

    public static WebDriver getWebDriver(SupportedWebDrivers webDriver, Capabilities capabilities) {
        switch (webDriver) {
            case CHROME:
                return new ChromeDriver(capabilities);
                
            case FIREFOX:
                return new FirefoxDriver(capabilities);

            case IE:
                return new InternetExplorerDriver(capabilities);
            
            default:
                return null;
        }
    }
    
}
