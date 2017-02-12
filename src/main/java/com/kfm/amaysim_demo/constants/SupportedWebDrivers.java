package com.kfm.amaysim_demo.constants;

import com.kfm.amaysim_demo.exceptions.AutomationFrameworkException;

public enum SupportedWebDrivers {
    
    CHROME,
    FIREFOX,
    IE;

    public static SupportedWebDrivers determineBrowser(String browser)
            throws AutomationFrameworkException {
        
        if (SupportedWebDrivers.FIREFOX.name().equalsIgnoreCase(browser)) {
            return SupportedWebDrivers.FIREFOX;
        }
        else if (SupportedWebDrivers.IE.name().equalsIgnoreCase(browser)) {
            return SupportedWebDrivers.IE;
        }
        else if (SupportedWebDrivers.CHROME.name().equalsIgnoreCase(browser)) {
            return SupportedWebDrivers.CHROME;
        }
        else {
            throw new AutomationFrameworkException(
                browser + ConstantExceptionMessages.NOT_SUPPORTED);
        }
    }
    
}
