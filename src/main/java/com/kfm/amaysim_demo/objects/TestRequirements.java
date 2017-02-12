package com.kfm.amaysim_demo.objects;

import com.kfm.amaysim_demo.constants.SupportedWebDrivers;

public class TestRequirements {
     
    private static TestRequirements instance;

    private String username;
    private String password;
    private String url;
    private String suiteName;

    private SupportedWebDrivers browser;

    private TestRequirements() {
        
    }

    public static TestRequirements getInstance() {
        
        if (instance == null) {
            instance = new TestRequirements();
        }
        
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public SupportedWebDrivers getBrowser() {
        return browser;
    }

    public void setBrowser(SupportedWebDrivers browser) {
        this.browser = browser;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}
