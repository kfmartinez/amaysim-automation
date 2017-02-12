package com.kfm.amaysim_demo.exceptions;

import org.testng.Assert;

public class AutomationFrameworkException extends Exception {
    
    private static final long serialVersionUID = -2782359514498154865L;

    public AutomationFrameworkException(String message) {
        super(message);
        Assert.fail(message);
    }

    public AutomationFrameworkException(Throwable cause) {
        super(cause);
        Assert.fail();
    }

    public AutomationFrameworkException(String message, Throwable cause) {
        super(message, cause);
        Assert.fail(message);
    }
    
}
